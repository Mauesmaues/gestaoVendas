package com.gestorVendas.controller;

import com.gestorVendas.view.Screan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private final Screan screan;
    public LoginController(Screan screan) {
        this.screan = screan;
    }

    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        switch(acao){
            case "login": login(); break;
            case "cancelar": cancelar(); break;
        }
    }

    private void cancelar() {
    }

    private void login() {
        String usuario = this.screan.getCampoUsuario().getText();
        String senha = this.screan.getCampoSenha().getText();
    }

}
