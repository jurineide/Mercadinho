package com.example.Vendas.models.dtos;

import com.example.Vendas.models.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private String telefone;

    //construtor vazio
    public ClienteDTO(){

    }
    //costrutor do id
    public ClienteDTO(Long id){

    }
    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
    }

    public static Cliente convert(ClienteDTO clienteDTO){

        Cliente cliente = new Cliente(clienteDTO.id);

        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setTelefone(clienteDTO.getTelefone());
        return cliente;
    }


}
