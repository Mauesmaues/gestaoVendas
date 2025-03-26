package com.gestorVendas.view;
import com.gestorVendas.controller.CadastrarProdutoController;
import com.gestorVendas.util.BuscaTabelaCategoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FormularioCadastroProduto extends JFrame {
    private JTextField nome;
    private JTextField descricao;
    private JTextField preco;
    private JTextField quantidade;
    private JComboBox<String> categoria;
    private JLabel ErrorMensagem;
    private JButton saveButton;
    CadastrarProdutoController controller;
    public FormularioCadastroProduto() {
        // Configuração do frame
        setTitle("Cadastro de Produto");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        controller = new CadastrarProdutoController(this);

        // Painel central para o formulário
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margem entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos do formulário
        JLabel nomeLabel = new JLabel("Nome:");
        nome = new JTextField(20);
        JLabel descriptionLabel = new JLabel("Descrição:");
        descricao = new JTextField(20);
        JLabel priceLabel = new JLabel("Preço:");
        preco = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantidade:");
        quantidade = new JTextField(10);
        JLabel categoryLabel = new JLabel("Categoria:");
        categoria = new JComboBox<>();
        ErrorMensagem = new JLabel();

        // Carregar opções no JComboBox (simulação do banco de dados)
        ArrayList<String> options = BuscaTabelaCategoria.getOptions(); // Busca categorias do banco
        for (String option : options) {
            categoria.addItem(option);
        }

        // Adicionando os campos ao painel
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(nomeLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(nome, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(descriptionLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(descricao, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(priceLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(preco, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(quantidade, gbc);
        gbc.gridx = 1;
        formPanel.add(quantidade, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(categoryLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(categoria, gbc);

        // Painel inferior para botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        saveButton = new JButton("Salvar");
        JButton clearButton = new JButton("Limpar");
        JButton cancelButton = new JButton("Cancelar");
        saveButton.setActionCommand("cadastrar");

        // Adicionando botões ao painel
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(cancelButton);

        // Adicionando os painéis ao frame
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        eventos();
    }

    public void eventos(){
        saveButton.addActionListener(controller);
    }

    public JTextField getNome() {
        return nome;
    }

    public JTextField getDescricao() {
        return descricao;
    }

    public JTextField getPreco() {
        return preco;
    }

    public JTextField getQuantitidade() {
        return quantidade;
    }

    public JComboBox<String> getCategoria() {
        return categoria;
    }

    public JLabel getErrorMensagem() {
        return ErrorMensagem;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormularioCadastroProduto().setVisible(true);
        });
    }
}

