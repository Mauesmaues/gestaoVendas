package com.gestorVendas.dao;

import com.gestorVendas.model.Categoria;
import com.gestorVendas.model.Cliente;
import com.gestorVendas.util.ConexaoMysql;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDao {
    private ConexaoMysql conexao;
    private JLabel mensagemError;

    public String adicionar(Categoria categoria, JLabel mensagemError) {
        this.conexao = new ConexaoMysql();
        this.mensagemError = mensagemError;

        String sql = "INSERT INTO categoria (nome, descricao) VALUES (?,?)";

        Categoria categoriaTemp = buscarPelaCategoria(categoria.getNome());
        if (categoriaTemp != null) {
            this.mensagemError.setText("Categoria já cadastrada!");
            return String.format("Error: Categoria %s ja existe no banco de dados", categoria.getNome());
        }
        try{
            PreparedStatement preparedStatement = conexao.conectar().prepareStatement(sql);
            preencherValoresPreperedStatement(preparedStatement, categoria);
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Categoria adicionada com sucesso" : "Nao foi possivel adicionar categoria";
        }catch(SQLException e){
            return String.format("Error %s",  e.getMessage());
        }
    }

    private void preencherValoresPreperedStatement(PreparedStatement preparedStatement, Categoria categoria) throws SQLException {
        preparedStatement.setString(1, categoria.getNome());
        preparedStatement.setString(2, categoria.getDescricao());
    }

    public Categoria buscarPelaCategoria(String nome){
        String sql = String.format("SELECT * FROM categoria WHERE nome = '%s'", nome);
        try{
            ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
            if(result.next()){
                return getCategoria(result);
            }
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }

        return null;
    }

    private Categoria getCategoria(ResultSet result) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNome(result.getString("nome"));
        categoria.setDescricao(result.getString("descricao"));

        return categoria;
    }
}
