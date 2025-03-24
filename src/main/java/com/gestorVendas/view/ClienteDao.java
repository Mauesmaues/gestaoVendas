package com.gestorVendas.view;

import javax.swing.*;

public class ClienteDao extends JFrame {
    private JTextField nome;
    private JTextField telefone;
    private JTextField endereco;
    private JButton cadastrar;
    private JLabel labelNome;
    private JLabel labelTelefone;
    private JLabel labelEndereco;

    public ClienteDao() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(null); // Define layout nulo para personalização
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(50, 60, 80, 25);

        nome = new JTextField();
        nome.setBounds(130, 60, 200, 25);

        // Rótulo e campo de senha
        JLabel labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(50, 100, 80, 25);

        telefone = new JTextField(); // Troquei para JPasswordField
        telefone.setBounds(130, 100, 200, 25);

        JLabel labelEndereco = new JLabel("Endereco:");
        labelEndereco.setBounds(50, 140, 80, 25);

        endereco = new JTextField();
        endereco.setBounds(130, 140, 200, 25);

        // Botão de login
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(150, 200, 90, 30);
        cadastrar.setActionCommand("Cadastrar");


        add(labelNome);
        add(nome);
        add(labelTelefone);
        add(telefone);
        add(labelEndereco);
        add(endereco);
        add(cadastrar);

    }

    public static void main(String[] args) {
        new ClienteDao().setVisible(true);
    }

}


