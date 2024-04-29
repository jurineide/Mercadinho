package com.example.Vendas.models.dtos;
import com.example.Vendas.models.Item;
import com.example.Vendas.models.Produto;
import com.example.Vendas.models.Venda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private  Long id;
    private  Float valorParcial;
    private int quantidade;
    private Long idVenda;
    private Long idProduto;



    public ItemDTO(Item item) {
        this.id = item.getId();
        this.valorParcial = item.getValorParcial();
        this.quantidade = item.getQuantidade();
        this.idVenda = item.getVenda().getId();
        this.idProduto = item.getProduto().getId();
    }
    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setValorParcial(itemDTO.getValorParcial());
        item.setQuantidade(itemDTO.getQuantidade());
        item.setVenda(new Venda(itemDTO.getIdVenda()));
        item.setProduto(new Produto(itemDTO.idProduto));
        return  item;
    }

    public ItemDTO(){

    }


}
