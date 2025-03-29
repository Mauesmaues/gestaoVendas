package com.gestorVendas.componentes;

import com.gestorVendas.controller.CadastrarController;
import com.gestorVendas.view.PainelCliente;

import javax.swing.*;
import java.awt.*;

public class PainelDeComandoProduto extends JPanel {
    public PainelDeComandoProduto() {
        ConexaoPainelEBotaoCadastrarProduto controller = new ConexaoPainelEBotaoCadastrarProduto(this);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(300, 200)); // Tamanho ajustado
        botaoCadastrarProduto botaoCadastrarProduto = new botaoCadastrarProduto();
        add(botaoCadastrarProduto);
        botaoCadastrarProduto.addActionListener(controller);
    }
}
