package com.example.Vendas.controllers;
import com.example.Vendas.models.dtos.ProdutoDTO;
import com.example.Vendas.services.ProdutoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Getter
@Setter
@RestController

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //rota que é incluido os produtos
    @PostMapping( "/produtos")
    public ProdutoDTO save(@RequestBody ProdutoDTO dto) {

        return produtoService.save(dto);
    }


    //rota que lista todos os produtos
    @GetMapping("/produtos")
    public List<ProdutoDTO> findAll(){

        return produtoService.findAll();
    }


    //rota que retorna apenas um produto especifico, caso não encontre retorna null
    @GetMapping("/produtos/{id}")
    public ProdutoDTO findById(@PathVariable Long id){

        return produtoService.findById(id);
    }


    //rota que deleta um produto, retorna void pois não retorna valor, apenas exclui
    @DeleteMapping("produtos/{id}")
    public void deleteById(@PathVariable Long id){
        produtoService.deleteById(id);
    }


    //editar o produto, passando o id do produto para depois salvar o produto editado, se não ele cria um novo produto
    @PutMapping("/produtos/{id}")
    public ProdutoDTO updateById(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        dto.setId(id);
        return produtoService.save(dto);
    }

}
