package com.gestorVendas.view;


import com.gestorVendas.componentes.PainelDeComandoProduto;
import com.gestorVendas.controller.CadastrarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class DashBoard extends JFrame {
        private JPanel painelEsquerdo; // Barra lateral com os botões
        private JPanel painelDireito; // Área de conteúdo dinâmico

        public DashBoard() {
            setTitle("Dashboard");
            setSize(1000, 700);
            setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para ocupar 100% da tela
            setUndecorated(false); // Remove a barra de título para uma experiência em tela cheia
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            // Painel esquerdo com botões
            painelEsquerdo = new JPanel();
            painelEsquerdo.setLayout(new GridLayout(6, 1, 5, 5)); // Layout de grade para os botões
            painelEsquerdo.setBackground(Color.LIGHT_GRAY);

            // Botões do painel esquerdo
            JButton btnHome = new JButton("Home");
            JButton btnProdutos = new JButton("Produtos");
            JButton btnClientes = new JButton("Clientes");
            JButton btnVendas = new JButton("Vendas");
            JButton btnUsuarios = new JButton("Usuários");
            JButton btnSair = new JButton("Sair");

            // Adiciona os botões ao painel esquerdo
            painelEsquerdo.add(btnHome);
            painelEsquerdo.add(btnProdutos);
            painelEsquerdo.add(btnClientes);
            painelEsquerdo.add(btnVendas);
            painelEsquerdo.add(btnUsuarios);
            painelEsquerdo.add(btnSair);

            // Painel direito (dinâmico)
            painelDireito = new JPanel();
            painelDireito.setLayout(new CardLayout()); // Usando CardLayout para alternar os "frames"

            // Sub-painéis para cada botão
            JPanel painelHome = criarPainel("Bem-vindo ao Dashboard");
            JPanel painelProdutos = criarPainel("Gestão de Produtos");
            JPanel painelClientes = criarPainel("Gestão de Clientes");
            JPanel painelVendas = criarPainel("Gestão de Vendas");
            JPanel painelUsuarios = criarPainel("Gestão de Usuários");

            painelDireito.add(painelHome, "Home");
            PainelDeComandoProduto painelControllerProduto = new PainelDeComandoProduto();
            painelProdutos.add(painelControllerProduto);
            painelDireito.add(painelProdutos, "Produtos");
            PainelFuncCliente painelController = new PainelFuncCliente();
            painelClientes.add(painelController);
            painelDireito.add(painelClientes, "Clientes");
            painelDireito.add(painelVendas, "Vendas");
            painelDireito.add(painelUsuarios, "Usuários");

            // Define o comportamento dos botões
            btnHome.addActionListener(e -> alternarPainel("Home"));
            btnProdutos.addActionListener(e -> alternarPainel("Produtos"));
            btnClientes.addActionListener(e -> alternarPainel("Clientes"));
            btnVendas.addActionListener(e -> alternarPainel("Vendas"));
            btnUsuarios.addActionListener(e -> alternarPainel("Usuários"));
            btnSair.addActionListener(e -> System.exit(0)); // Encerra o programa ao clicar em "Sair"

            // Adiciona os painéis à janela principal
            add(painelEsquerdo, BorderLayout.WEST);
            add(painelDireito, BorderLayout.CENTER);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelEsquerdo, painelDireito);
            splitPane.setDividerLocation(0.35); // Define o divisor para 35% da tela
            splitPane.setResizeWeight(0.35); // Prioriza o lado esquerdo
            splitPane.setOneTouchExpandable(false); // Desativa os controles do divisor
            splitPane.setDividerSize(2); // Define a espessura da linha do divisor

            // Adiciona o divisor à janela principal
            add(splitPane);

        }

        // Método para criar um painel com uma mensagem centralizada
        private JPanel criarPainel(String mensagem) {
            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());
            JLabel label = new JLabel(mensagem, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            painel.add(label, BorderLayout.CENTER);
            return painel;
        }

        // Método para alternar os painéis no CardLayout
        private void alternarPainel(String nomeDoPainel) {
            CardLayout cl = (CardLayout) painelDireito.getLayout();
            cl.show(painelDireito, nomeDoPainel);
        }

    }
