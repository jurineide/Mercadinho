package com.example.Vendas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //numerar id com ordem
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private String telefone;

    public Cliente(Long idCliente){

    }

}
