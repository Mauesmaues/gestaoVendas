package com.gestorVendas.model;

import java.math.BigDecimal;

public class VendaItem {
    private Venda venda;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal total;
    private BigDecimal desconto;

    public VendaItem() {
    }

    public VendaItem(Venda venda, Cliente cliente, Produto produto, Integer quantidade, BigDecimal total, BigDecimal desconto) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
        this.desconto = desconto;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
