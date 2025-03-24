package com.gestorVendas.view;

import com.gestorVendas.controller.CadastrarController;
import com.gestorVendas.controller.RealizarCadastroController;

import javax.swing.*;
import java.awt.*;

public class ClienteDao extends JFrame {
    private JTextField nome;
    private JTextField telefone;
    private JTextField endereco;
    private JButton cadastrar;
    private JLabel labelNome;
    private JLabel labelTelefone;
    private JLabel labelEndereco;
    private JLabel mensagemError;
    private RealizarCadastroController controller;

    public ClienteDao() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(null); // Define layout nulo para personalização
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        controller = new RealizarCadastroController(this);

        labelNome = new JLabel("Nome:");
        labelNome.setBounds(50, 60, 80, 25);

        nome = new JTextField();
        nome.setBounds(130, 60, 200, 25);

        // Rótulo e campo de senha
        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(50, 100, 80, 25);

        telefone = new JTextField(); // Troquei para JPasswordField
        telefone.setBounds(130, 100, 200, 25);

        labelEndereco = new JLabel("Endereco:");
        labelEndereco.setBounds(50, 140, 80, 25);

        endereco = new JTextField();
        endereco.setBounds(130, 140, 200, 25);

        // Botão de login
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(150, 200, 90, 30);
        cadastrar.setActionCommand("realizarCadastro");

        mensagemError = new JLabel();
        mensagemError.setBounds(130, 225, 200, 25);
        mensagemError.setForeground(Color.red);


        add(labelNome);
        add(nome);
        add(labelTelefone);
        add(telefone);
        add(labelEndereco);
        add(endereco);
        add(cadastrar);
        add(mensagemError);

        eventos();

    }

    public JTextField getNome() {
        return nome;
    }

    public JTextField getTelefone() {
        return telefone;
    }

    public JTextField getEndereco() {
        return endereco;
    }

    public JLabel getMensagemError() {
        return mensagemError;
    }

    private void eventos(){
        cadastrar.addActionListener(controller);
    }


}


