package com.example.Vendas.models.dtos;
import com.example.Vendas.models.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


// metodo transformou produto em produto dto
public class ProdutoDTO {
    private Long id;
    private String codigo;
    private  String descricao;
    private String preco;
    private String unidadeMedida;
    private String grupo;
    private  String urlFoto;

    //construtor vazio
    public ProdutoDTO(){

    }
    //costrutor do id
    public ProdutoDTO(Long id){

    }

     //construtor que recebe  a entidade produtos que será convertido em dto
    public ProdutoDTO(Produto produto){
      this.id = produto.getId();
      this.codigo = produto.getCodigo();
      this.descricao = produto.getDescricao();
      this.preco = produto.getPreco();
      this.unidadeMedida = produto.getUnidadeMedida();
      this.grupo = produto.getGrupo();
      this.urlFoto = produto.getUrlFoto();
    }


    //converti produto DTO para produto
    public static Produto convert(ProdutoDTO produtoDTO){

        Produto produto = new Produto();

        produto.setId(produtoDTO.getId());
        produto.setCodigo(produtoDTO.getCodigo());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setUnidadeMedida(produtoDTO.getUnidadeMedida());
        produto.setGrupo(produtoDTO.getGrupo());
        produto.setUrlFoto(produtoDTO.getUrlFoto());
        return produto;
    }
}
