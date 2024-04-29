package com.example.Vendas.services;

import com.example.Vendas.models.Venda;
import com.example.Vendas.models.dtos.VendaDTO;
import com.example.Vendas.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    public VendaDTO save(VendaDTO dto) {
        Venda venda = VendaDTO.convert(dto);
        for(int i = 0; i < venda.getItens().size(); i++){
            venda.getItens().get(i).setVenda(venda);
        }
        venda = this.vendaRepository.save(venda);
        return  new VendaDTO(venda);
    }

    public List<VendaDTO> findAll() {
        List<Venda>venda = this.vendaRepository.findAll();
        return venda.stream().map(VendaDTO::new).collect(Collectors.toList());
    }

    public VendaDTO findById(Long id) {
        Optional<Venda>venda = this.vendaRepository.findById(id);
        if(venda.isEmpty()){
            throw new RuntimeException("venda não encontrada");
        }else{
            return new VendaDTO(venda.get());
        }
    }
}
