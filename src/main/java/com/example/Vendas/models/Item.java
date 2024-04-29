package com.example.Vendas.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float valorParcial;
    private int quantidade;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;

    public Item() {

    }
}
