package com.gestorVendas.controller;

import com.gestorVendas.dao.AutenficacoDao;
import com.gestorVendas.dao.LoginDto;
import com.gestorVendas.model.Usuario;
import com.gestorVendas.view.ClienteDao;
import com.gestorVendas.view.DashBoard;
import com.gestorVendas.view.PainelFuncCliente;
import com.gestorVendas.view.Screan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarController implements ActionListener {
    private final PainelFuncCliente cadastrar;
    private  AutenficacoDao AutentificacaoDao;

    public CadastrarController (PainelFuncCliente cadastrar) {
        this.cadastrar = cadastrar;
        this.AutentificacaoDao = new AutenficacoDao();
    }

    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        switch(acao){
            case "cadastrar": login(); break;
        }
    }


    private void login() {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.setVisible(true);
    }
}
