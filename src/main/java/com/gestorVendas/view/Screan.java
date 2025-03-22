package com.gestorVendas.view;

import javax.swing.*; // Importa a biblioteca Swing para criação da interface gráfica
import java.awt.*; // Importa classes para gerenciamento de layout
import java.awt.event.ActionEvent; // Importa a classe para eventos de ação
import java.awt.event.ActionListener; // Importa a interface para escutar eventos de ação

// Classe Screan que herda de JFrame para criar uma janela gráfica
public class Screan extends JFrame {
    private JTextField campoUsuario; // Campo de texto para o usuário inserir o nome
    private JPasswordField campoSenha; // Campo de senha para inserir a senha
    private JButton botaoLogin; // Botão para acionar o login

    // Construtor da classe Screan
    public Screan() {
        setTitle("Login"); // Define o título da janela
        setSize(300, 500); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new GridLayout(3, 2, 5, 5)); // Define o layout da tela com uma grade de 3 linhas e 2 colunas

        JLabel labelUsuario = new JLabel("Usuário:"); // Rótulo para o campo de usuário
        campoUsuario = new JTextField(); // Criação do campo de texto para entrada do usuário
        JLabel labelSenha = new JLabel("Senha:"); // Rótulo para o campo de senha
        campoSenha = new JPasswordField(); // Criação do campo de senha
        botaoLogin = new JButton("Login"); // Criação do botão de login

        // Adiciona um evento ao botão de login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText(); // Obtém o texto digitado no campo de usuário
                String senha = new String(campoSenha.getPassword()); // Obtém a senha digitada
            }
        });

        // Adiciona os componentes na tela
        add(labelUsuario);
        add(campoUsuario);
        add(labelSenha);
        add(campoSenha);
        add(new JLabel()); // Espaço vazio para ajuste no layout
        add(botaoLogin);
    }
    public JTextField getCampoUsuario() {
        return campoUsuario;
    }

    // Método para obter o campo de senha
    public JPasswordField getCampoSenha() {
        return campoSenha;
    }

    public JButton getBotaoLogin() {
        return botaoLogin;
    }
}

