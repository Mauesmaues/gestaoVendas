package com.gestorVendas.view;

import com.gestorVendas.controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class PainelCliente extends JButton {

    PainelCliente() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(100, 50));
        setActionCommand("cadastrar");
        setText("Cadastrar");

    }
}
