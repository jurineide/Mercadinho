package com.example.Vendas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private  String descricao;
    private String preco;
    private String unidadeMedida;
    private String grupo;
    private  String urlFoto;

    public Produto(Long idProduto) {
    }
}
