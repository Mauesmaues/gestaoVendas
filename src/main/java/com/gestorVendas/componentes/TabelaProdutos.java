package com.gestorVendas.componentes;

import com.gestorVendas.util.ConexaoMysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TabelaProdutos extends JPanel {
    private JTable tabela;

    public TabelaProdutos() {
        setLayout(new BorderLayout());

        // Modelo da tabela
        DefaultTableModel tableModel = new DefaultTableModel();
        tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);

        // Chamar o método para buscar dados
        carregarDados(tableModel);
    }

    private void carregarDados(DefaultTableModel tableModel) {
        try {
            // Obter conexão usando sua classe ConexaoMysql
            ConexaoMysql conexao = new ConexaoMysql();

            // Query SQL para buscar dados
            String query = "SELECT * FROM produto";
            PreparedStatement statement = conexao.conectar().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Adicionar colunas ao modelo
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Adicionar linhas ao modelo
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }

            // Fechar recursos
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
        }
    }
}
