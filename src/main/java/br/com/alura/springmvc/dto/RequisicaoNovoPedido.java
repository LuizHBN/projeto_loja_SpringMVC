package br.com.alura.springmvc.dto;

import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.model.StatusPedido;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {
    @NotBlank(message = "O campo deve ser preenchido")
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;

    private String descricao;

    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setNomeProduto(nomeProduto);
        pedido.setStatus(StatusPedido.AGUARDANDO);

        return pedido;
    }


    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
