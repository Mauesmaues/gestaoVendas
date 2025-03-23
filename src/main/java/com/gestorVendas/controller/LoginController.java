package com.gestorVendas.controller;

import com.gestorVendas.dao.AutenficacoDao;
import com.gestorVendas.dao.LoginDto;
import com.gestorVendas.model.Usuario;
import com.gestorVendas.view.DashBoard;
import com.gestorVendas.view.Screan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private final Screan screan;
    private AutenficacoDao AutentificacaoDao;
    public LoginController(Screan screan) {
        this.screan = screan;
        this.AutentificacaoDao = new AutenficacoDao();
    }

    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        switch(acao){
            case "login": login(); break;
            case "cancelar": cancelar(); break;
        }
    }

    private void cancelar() {
        int confirmar = JOptionPane.showConfirmDialog(screan, "Tem certeza que deseja sair?", "Sair do sistema",JOptionPane.YES_NO_OPTION);
        if(confirmar == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    private void login() {
        String usuario = this.screan.getCampoUsuario().getText();
        String senha = this.screan.getCampoSenha().getText();

        if(usuario.equals("") || senha.equals("")){
            this.screan.getLoginMensagem().setText("Usuario e senha devem ser preenchidos");
            return;
        }

        LoginDto loginDto = new LoginDto(usuario, senha);

        Usuario usuarioTemp = this.AutentificacaoDao.login(loginDto);

        if(usuarioTemp != null){
            JOptionPane.showMessageDialog(null, usuarioTemp.getNome());
            DashBoard dashboard = new DashBoard();
            dashboard.setVisible(true);
            limparCampos();
        }else{
            this.screan.getLoginMensagem().setText("Usuario ou senha incorretos");
        }
    }

    private void limparCampos(){
        this.screan.getCampoUsuario().setText("");
        this.screan.getCampoSenha().setText("");
        this.screan.getLoginMensagem().setText("");
    }

}
