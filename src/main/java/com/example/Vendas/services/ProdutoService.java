package com.example.Vendas.services;

import com.example.Vendas.models.Produto;
import com.example.Vendas.models.dtos.ProdutoDTO;
import com.example.Vendas.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    // inclui os produtos, converti produto em dto
    public ProdutoDTO save(@RequestBody ProdutoDTO dto){
        Produto produto = ProdutoDTO.convert(dto);
        produto =  produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    //lista todos os produtos, converti a lista em uma nova lista

    public List<ProdutoDTO> findAll(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    //retorna apenas um produto especifico, caso não encontre retorna null
    public ProdutoDTO findById(@PathVariable Long id){
        Optional<Produto> resultado = this.produtoRepository.findById(id);
        if(resultado.isEmpty()){
            throw new RuntimeException("Produto não encontrado");
        }else{
            return new ProdutoDTO(resultado.get());
        }
    }

    //rota que deleta um produto, retorna void pois não retorna valor, apenas exclui
    public void deleteById(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

    //editar o produto, passando o id do produto para depois salvar o produto editado, se não ele cria um novo produto
    public ProdutoDTO updateById(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        Produto produto = ProdutoDTO.convert(dto);
        produto.setId(id);
        produto= produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

}
