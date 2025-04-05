package com.gestorVendas.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class FormularioCadastro {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Cadastro de Usuário");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new GridLayout(5, 2));

            // Labels e campos de texto
            JLabel nomeLabel = new JLabel("Nome:");
            JTextField nomeField = new JTextField();

            JLabel emailLabel = new JLabel("Email:");
            JTextField emailField = new JTextField();

            JLabel senhaLabel = new JLabel("Senha:");
            JPasswordField senhaField = new JPasswordField();

            // Botão de cadastro
            JButton cadastrarButton = new JButton("Cadastrar");
            JLabel mensagemLabel = new JLabel("");

            cadastrarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = nomeField.getText();
                    String email = emailField.getText();
                    String senha = new String(senhaField.getPassword());

                    if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty()) {
                        mensagemLabel.setText("Usuário cadastrado com sucesso!");
                    } else {
                        mensagemLabel.setText("Por favor, preencha todos os campos.");
                    }
                }
            });

            // Adicionando componentes ao frame
            frame.add(nomeLabel);
            frame.add(nomeField);
            frame.add(emailLabel);
            frame.add(emailField);
            frame.add(senhaLabel);
            frame.add(senhaField);
            frame.add(new JLabel()); // Espaço vazio
            frame.add(cadastrarButton);
            frame.add(mensagemLabel);

            frame.setVisible(true);
        }
    }
