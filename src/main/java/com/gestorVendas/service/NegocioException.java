package com.gestorVendas.service;

public class NegocioException extends RuntimeException {
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
