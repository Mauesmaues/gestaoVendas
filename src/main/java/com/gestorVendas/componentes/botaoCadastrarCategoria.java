package com.gestorVendas.componentes;

import javax.swing.*;
import java.awt.*;

public class botaoCadastrarCategoria extends JButton {
    botaoCadastrarCategoria(){
        setActionCommand("abrircadastrar");
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.magenta);
        setPreferredSize(new Dimension(100, 50));
        setText("Cadastrar Categoria");

    }
}
