package com.gestorVendas.util;

import com.gestorVendas.controller.CadastrarProdutoController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuscaTabelaCategoria{

    public static ArrayList<String> getOptions() {
        ArrayList<String> options = new ArrayList<>();
        ConexaoMysql conexao = new ConexaoMysql();
        try {
            String query = "SELECT nome FROM categoria";
            PreparedStatement statement = conexao.conectar().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                options.add(resultSet.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return options;
    }
}
