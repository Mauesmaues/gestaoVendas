package com.gestorVendas.view;

import com.gestorVendas.controller.LoginController;

import javax.swing.*; // Importa a biblioteca Swing para criação da interface gráfica
import java.awt.*; // Importa classes para gerenciamento de layout
import java.awt.event.ActionEvent; // Importa a classe para eventos de ação
import java.awt.event.ActionListener; // Importa a interface para escutar eventos de ação

// Classe Screan que herda de JFrame para criar uma janela gráfica
public class Screan extends JFrame {
    private JTextField campoUsuario; // Campo de texto para o usuário inserir o nome
    private JTextField campoSenha; // Campo de senha para inserir a senha
    private JButton botaoLogin; // Botão para acionar o login
    private LoginController controller;
    private JButton botaoCancelar;
    // Construtor da classe Screan
    public Screan () {

            this.controller = new LoginController(this);
            setTitle("Login"); // Define o título da janela
            setSize(400, 400); // Define o tamanho da janela
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
            setLocationRelativeTo(null); // Centraliza a janela na tela
            setLayout(new GridLayout(5, 2, 30, 2)); // Define o layout da tela com uma grade de 3 linhas e 2 colunas

            JLabel labelUsuario = new JLabel("Usuário:"); // Rótulo para o campo de usuário
            campoUsuario = new JTextField(); // Criação do campo de texto para entrada do usuário
            JLabel labelSenha = new JLabel("Senha:"); // Rótulo para o campo de senha
            campoSenha = new JPasswordField();// Criação do campo de senha
            botaoCancelar = new JButton("Cancelar");
            botaoCancelar.setActionCommand("cancelar");
            botaoLogin = new JButton("Login");// Criação do botão de login
            botaoLogin.setActionCommand("login");
            // Adiciona os componentes na tela
            add(labelUsuario);
            add(campoUsuario);
            add(new JLabel());
            add(new JLabel());
            add(labelSenha);
            add(campoSenha);
            add(new JLabel());
            add(new JLabel());
            add(botaoCancelar); // Espaço vazio para ajuste no layout
            add(botaoLogin);
            eventos();
    }

    private void eventos(){
        botaoLogin.addActionListener(controller);

    }

    public JTextField getCampoUsuario() {
        return campoUsuario;
    }

    // Método para obter o campo de senha
    public JTextField getCampoSenha() {
        return campoSenha;
    }

    public JButton getBotaoLogin() {
        return botaoLogin;
    }
}

