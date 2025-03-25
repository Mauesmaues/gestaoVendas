package com.gestorVendas.view;

import com.gestorVendas.controller.CategoriaController;
import com.gestorVendas.controller.RealizarCadastroController;

import javax.swing.*;
import java.awt.*;

public class FormularioCadastroDeCategoria extends JFrame {

    private JLabel nomeLabel;
    private JTextField nome;
    private JLabel descricaoLabel;
    private JTextField descricao;
    private JLabel mensagemError;
    private JButton cadastrar;

    private CategoriaController controller;

       FormularioCadastroDeCategoria() {
            setTitle("Cadastro de Categoria");
            setSize(400, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null); // Define layout nulo para personalização
            //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setResizable(false);
            this.controller = new CategoriaController(this);


            nomeLabel = new JLabel("Nome:");
            nomeLabel.setBounds(50, 60, 80, 25);

            nome = new JTextField();
            nome.setBounds(130, 60, 200, 25);

            // Rótulo e campo de senha
            descricaoLabel = new JLabel("descricao:");
            descricaoLabel.setBounds(50, 100, 80, 25);

            descricao = new JTextField(); // Troquei para JPasswordField
            descricao.setBounds(130, 100, 200, 25);

            // Botão de login
            cadastrar = new JButton("Cadastrar");
            cadastrar.setBounds(150, 160, 90, 30);
            cadastrar.setActionCommand("realizarCadastro");

            mensagemError = new JLabel();
            mensagemError.setBounds(130, 190, 200, 25);
            mensagemError.setForeground(Color.red);


            add(nomeLabel);
            add(nome);
            add(descricaoLabel);
            add(descricao);
            add(cadastrar);
            add(mensagemError);

            eventos();
        }

        public JTextField getNome() {
           return nome;
        }

        public JTextField getDescricao() {
           return descricao;
        }

        public JLabel getMensagemError() {
           return mensagemError;
        }

        public void eventos(){
           cadastrar.addActionListener(controller);
        }


        public static void main(String[] args) {
           FormularioCadastroDeCategoria frame = new FormularioCadastroDeCategoria();
           frame.setVisible(true);
        }
    }
