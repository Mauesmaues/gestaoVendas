package com.gestorVendas.controller;

import com.gestorVendas.componentes.botaoCadastrarCategoria;
import com.gestorVendas.view.FormularioCadastroDeCategoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoCategoriaController implements ActionListener {
    private botaoCadastrarCategoria botaoCadastrar;

    public BotaoCategoriaController(botaoCadastrarCategoria botaoCadastrar) {
        this.botaoCadastrar = botaoCadastrar;
    }

    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        if (acao.equals("abrircadastrar")) {
            abrirCadastro();
        }
    }

    private void abrirCadastro() {
        FormularioCadastroDeCategoria form = new FormularioCadastroDeCategoria();
        form.setVisible(true);
    }
}
