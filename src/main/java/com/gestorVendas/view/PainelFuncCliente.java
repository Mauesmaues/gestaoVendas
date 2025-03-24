package com.gestorVendas.view;

import com.gestorVendas.controller.CadastrarController;

import javax.swing.*;
import java.awt.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class PainelFuncCliente extends JPanel {
    private CadastrarController cadastrarController;
    public PainelFuncCliente() {
        cadastrarController = new CadastrarController(this);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(300, 200)); // Tamanho ajustado
        PainelCliente botaoCadastrar = new PainelCliente();
        add(botaoCadastrar);
        botaoCadastrar.addActionListener(cadastrarController);




    }
}
