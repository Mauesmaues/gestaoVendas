package com.gestorVendas.view;

import com.gestorVendas.controller.LoginController;

import javax.swing.*; // Importa a biblioteca Swing para criação da 'interface' gráfica
import java.awt.*; // Importa classes para gerenciamento de layout
import java.awt.event.ActionEvent; // Importa a classe para eventos de ação
import java.awt.event.ActionListener; // Importa a 'interface' para escutar eventos de ação

// Classe Screan que herda de JFrame para criar uma janela gráfica
public class Screan extends JFrame {
    private JTextField campoUsuario; // Campo de texto para o 'utilizador' inserir o nome
    private JPasswordField campoSenha; // Campo de senha para inserir a senha
    private JButton botaoLogin; // Botão para acionar o 'login'
    private LoginController controller;
    private JButton botaoCancelar;
    private JLabel loginMensagem;

        public Screan() {
            setTitle("Login");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Centraliza a janela
            setLayout(null); // Define layout nulo para personalização
            this.controller = new LoginController(this);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setResizable(false);

            // Título
            JLabel titulo = new JLabel("Bem-vindo");
            titulo.setFont(new Font("Arial", Font.BOLD, 24));
            titulo.setBounds(130, 10, 200, 30); // Define a posição e o tamanho

            // Rótulo e campo de usuário
            JLabel labelUsuario = new JLabel("Usuário:");
            labelUsuario.setBounds(50, 70, 80, 25);

            campoUsuario = new JTextField();
            campoUsuario.setBounds(130, 70, 200, 25);

            // Rótulo e campo de senha
            JLabel labelSenha = new JLabel("Senha:");
            labelSenha.setBounds(50, 110, 80, 25);

            campoSenha = new JPasswordField(); // Troquei para JPasswordField
            campoSenha.setBounds(130, 110, 200, 25);

            // Botão de login
            botaoLogin = new JButton("Login");
            botaoLogin.setBounds(130, 160, 90, 30);
            botaoLogin.setActionCommand("login");

            // Botão de cancelar
            botaoCancelar = new JButton("Cancelar");
            botaoCancelar.setBounds(240, 160, 90, 30);
            botaoCancelar.setActionCommand("cancelar");

            // Mensagem de erro
            loginMensagem = new JLabel();
            loginMensagem.setForeground(Color.RED);
            loginMensagem.setBounds(80, 200, 250, 25);

            // Adicionando os componentes ao JFrame
            add(titulo);
            add(labelUsuario);
            add(campoUsuario);
            add(labelSenha);
            add(campoSenha);
            add(botaoLogin);
            add(botaoCancelar);
            add(loginMensagem);

            // Configurações de fundo e estilo da tela
            getContentPane().setBackground(new Color(220, 220, 220)); // Fundo cinza claro
            eventos();
        }


    private void eventos(){
        botaoLogin.addActionListener(controller);
        botaoCancelar.addActionListener(controller);

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

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public JLabel getLoginMensagem() {
        return loginMensagem;
    }
}

