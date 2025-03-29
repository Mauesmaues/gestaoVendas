package com.gestorVendas.componentes;

import javax.swing.*;
import java.awt.*;

public class botaoCadastrarProduto extends JButton {
    botaoCadastrarProduto() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(100, 50));
        setActionCommand("cadastrarProduto");
        setText("Cadastrar");

    }
}
