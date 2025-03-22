package com.gestorVendas;

import com.gestorVendas.model.Categoria;
import com.gestorVendas.util.Conexao;
import com.gestorVendas.util.ConexaoMysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        String sql = "Select * from categoria"; // codigo sql para ser inserido

        ConexaoMysql conexao = new ConexaoMysql(); // instancia da conexão

        System.out.println(conexao.conectar()); //verificando conexão

        Categoria categoria = new Categoria (null, "Bedidas não alcoolicas", "Bebidas não alcoolicas");

        String inserirSQL = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
        PreparedStatement inserindoCategoria = conexao.conectar().prepareStatement(inserirSQL);
        inserindoCategoria.setString(1, categoria.getNome());
        inserindoCategoria.setString(2, categoria.getDescricao());
        int resultadoDoCadastro = inserindoCategoria.executeUpdate();

        System.out.println(resultadoDoCadastro);

        ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();//conectando e inserindo o codigo sql
        // ResultSet é uma classe da biblioteca java.sql.ResultSet

        while (result.next()) {
            System.out.println(result.getString("nome"));
            // buscando na instancia result uma string na tabela categoria = nome
        }
    }
}