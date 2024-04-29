package com.example.Vendas.services;

import com.example.Vendas.models.Item;
import com.example.Vendas.models.dtos.ItemDTO;
import com.example.Vendas.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    public List<ItemDTO>findByIdVenda(Long idVenda){
        List<Item> itens = this.itemRepository.findByIdVenda(idVenda);
        return itens.stream().map(ItemDTO::new).collect(Collectors.toList());
    }
}
