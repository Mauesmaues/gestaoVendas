package com.gestorVendas.controller;

import com.gestorVendas.dao.CadastroClienteDao;
import com.gestorVendas.model.Cliente;
import com.gestorVendas.view.ClienteDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealizarCadastroController implements ActionListener {
    private final ClienteDao clienteDao;

    public RealizarCadastroController(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("clicou");
        String nome = this.clienteDao.getNome().getText();
        String telefone = this.clienteDao.getTelefone().getText();
        String endereco = this.clienteDao.getEndereco().getText();
        String acao = e.getActionCommand().toLowerCase();
        if(nome.equals("")){
            this.clienteDao.getMensagemError().setText("O campo nome é obrigatório!");
        }else {
            switch (acao) {

                case "realizarcadastro":
                    System.out.println("entrou");
                    cadastrar(nome, telefone, endereco);
                    break;
            }
        }
    }

    public void cadastrar(String nome, String telefone, String endereco){
        Cliente cliente = new Cliente(0L, nome, telefone, endereco);
        CadastroClienteDao cadastrar = new CadastroClienteDao();
        cadastrar.adicionar(cliente, this.clienteDao.getMensagemError());
    }


}
