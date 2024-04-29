package com.example.Vendas.services;
import com.example.Vendas.models.Cliente;
import com.example.Vendas.models.dtos.ClienteDTO;
import com.example.Vendas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO save(ClienteDTO dto) {
        Cliente cliente = ClienteDTO.convert(dto);
        cliente = this.clienteRepository.save(cliente);
        return  new ClienteDTO(cliente);
    }

    public List<ClienteDTO> findAll() {
        List<Cliente> cliente = this.clienteRepository.findAll();
        return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO findById(Long id) {
        Optional<Cliente>cliente = this.clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }else{
            return new ClienteDTO(cliente.get());
        }
    }

    public ClienteDTO updateById(Long id, ClienteDTO dto) {
        this.findById(id);
        Cliente cliente = ClienteDTO.convert(dto);
        cliente.setId(id);
        this.clienteRepository.save(cliente);
        return new ClienteDTO(cliente);

    }

    public ClienteDTO deleteById(Long id) {
        ClienteDTO dto = findById(id);
        this.clienteRepository.deleteById(id);
        return dto;
    }


}
