package com.example.Vendas.controllers;

import com.example.Vendas.models.dtos.VendaDTO;
import com.example.Vendas.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @PostMapping("/vendas")
    public VendaDTO save(@RequestBody VendaDTO dto){
        return this.vendaService.save(dto);
    }

    @GetMapping("/vendas")
    public List<VendaDTO>findAll(){
        return this.vendaService.findAll();
    }

    @GetMapping("/vendas/{id}")
    public VendaDTO findById(@PathVariable Long id){
        return this.vendaService.findById(id);
    }

}
