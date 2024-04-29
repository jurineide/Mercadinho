package com.example.Vendas.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataRegistro;

    @ManyToOne  //muitas vendas para um cliente
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda") // uma venda para muitos itens
    private List<Item> itens;

    public Venda(Long idVenda) {

    }
}