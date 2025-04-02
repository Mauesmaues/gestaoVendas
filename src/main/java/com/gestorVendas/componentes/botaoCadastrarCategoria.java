package com.gestorVendas.componentes;

import com.gestorVendas.controller.BotaoCategoriaController;

import javax.swing.*;
import java.awt.*;

public class botaoCadastrarCategoria extends JButton {
    botaoCadastrarCategoria(){
        setActionCommand("abrircadastrar");
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.magenta);
        setPreferredSize(new Dimension(160, 50));
        setText("Cadastrar Categoria");
        BotaoCategoriaController controller = new BotaoCategoriaController(this);
        addActionListener(controller);


    }
}
