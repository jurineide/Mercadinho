package com.example.Vendas.controllers;

import com.example.Vendas.models.dtos.ClienteDTO;
import com.example.Vendas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
@Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    public ClienteDTO save(@RequestBody ClienteDTO dto){
        return this.clienteService.save(dto);

    }

    @GetMapping("/clientes")
public List<ClienteDTO> findAll(){
        return this.clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
public  ClienteDTO findById(@PathVariable Long id){
        return this.clienteService.findById(id);
    }

    @PutMapping("/clientes/{id}")
    public ClienteDTO updateById(@PathVariable Long id, @RequestBody ClienteDTO dto){
        return this.clienteService.updateById(id, dto);
    }
    @DeleteMapping("/clientes/{id}")
    public  ClienteDTO deleteById(@PathVariable Long id){
        return this.clienteService.deleteById(id);
    }

}
