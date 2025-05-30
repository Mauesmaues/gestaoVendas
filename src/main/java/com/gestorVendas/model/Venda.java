package com.gestorVendas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venda {
    private Long id;
    private Cliente cliente;
    private Usuario usuario;
    private BigDecimal totalDaVenda;
    private BigDecimal valorPago;
    private BigDecimal desconto;
    private BigDecimal troco;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime ultimaatualizacao;

    public Venda() {
    }

    public Venda( Long id, Cliente cliente, Usuario usuario, BigDecimal totalDaVenda, BigDecimal valorPago, BigDecimal desconto, BigDecimal troco, LocalDateTime dataHoraCriacao, LocalDateTime ultimaatualizacao) {
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.totalDaVenda = totalDaVenda;
        this.valorPago = valorPago;
        this.desconto = desconto;
        this.troco = troco;
        this.dataHoraCriacao = dataHoraCriacao;
        this.ultimaatualizacao = ultimaatualizacao;
    };

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalDaVenda() {
        return totalDaVenda;
    }

    public void setTotalDaVenda(BigDecimal totalDaVenda) {
        this.totalDaVenda = totalDaVenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public LocalDateTime getUltimaatualizacao() {
        return ultimaatualizacao;
    }

    public void setUltimaatualizacao(LocalDateTime ultimaatualizacao) {
        this.ultimaatualizacao = ultimaatualizacao;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
}
