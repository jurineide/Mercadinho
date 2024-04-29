package com.example.Vendas.models.dtos;
import com.example.Vendas.models.Cliente;
import com.example.Vendas.models.Venda;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter

public class VendaDTO {
    private Long id;
    private String dataRegistro;
    private Long idCliente;
    private List<ItemDTO> itens;

    //construtor vazio
    public VendaDTO(){

    }

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.dataRegistro = venda.getDataRegistro();
        this.idCliente = venda.getCliente().getId();
        this.itens = venda.getItens().stream().map(ItemDTO::new).collect(Collectors.toList());
    }

    public static Venda convert(VendaDTO vendaDTO) {
        Venda venda = new Venda(vendaDTO.id);

        venda.setId(vendaDTO.getId());
        venda.setDataRegistro(vendaDTO.getDataRegistro());
        venda.setCliente(new Cliente(vendaDTO.getIdCliente()));
        venda.setItens(vendaDTO.getItens().stream().map(ItemDTO::convert).collect(Collectors.toList()));
        return venda;

    }




}

