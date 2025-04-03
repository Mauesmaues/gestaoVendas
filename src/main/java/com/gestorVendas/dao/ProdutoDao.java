package com.gestorVendas.dao;

import com.gestorVendas.model.Categoria;
import com.gestorVendas.model.Perfil;
import com.gestorVendas.model.Produto;
import com.gestorVendas.model.Usuario;
import com.gestorVendas.service.Sessao;
import com.gestorVendas.util.ConexaoMysql;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ProdutoDao {
        private ConexaoMysql conexao;
        private JLabel mensagemError;
        private Produto produtoGlobal;

        public String adicionar(Produto produto, JLabel mensagemError) {
            this.conexao = new ConexaoMysql();
            this.mensagemError = mensagemError;
            this.produtoGlobal = produto;
            String sql = "INSERT INTO produto (nome, descricao, preco, quantidade, categoria_id, usuario_id, data_hora_criacao) VALUES (?,?, ?, ?, ?, ?, ?)";

            Produto produtoTemp = buscarPeloProduto(produtoGlobal.getNome());
            if (produtoTemp != null) {
                this.mensagemError.setText("Produto já cadastrada!");
                return String.format("Error: Produto %s ja existe no banco de dados", produto.getNome());
            }
            try{
                PreparedStatement preparedStatement = conexao.conectar().prepareStatement(sql);
                preencherValoresPreperedStatement(preparedStatement, produtoGlobal);
                int resultado = preparedStatement.executeUpdate();
                System.out.println(resultado);
                return resultado == 1 ? "Categoria adicionada com sucesso" : "Nao foi possivel adicionar categoria";
            }catch(SQLException e){
                return String.format("Error %s",  e.getMessage());
            }
        }

        private void preencherValoresPreperedStatement(PreparedStatement preparedStatement, Produto produto) throws SQLException {
            System.out.println("preencherValoresPreperedStatement");
            preparedStatement.setString(1, produto.getNome());
            System.out.println(produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            System.out.println(produto.getDescricao());
            preparedStatement.setBigDecimal(3, produto.getPreco());
            System.out.println(produto.getPreco());
            System.out.println(produto.getQuantidade());
            preparedStatement.setInt(4, produto.getQuantidade());
            System.out.println(produto.getCategoria().getNome());
            if (produto.getCategoria() != null && produto.getCategoria().getNome() != null) {
                String nomeCategoria = produto.getCategoria().getNome();
                preparedStatement.setInt(5, buscarPelaCategoria(nomeCategoria));
            } else {
                throw new IllegalArgumentException("Categoria inválida para o produto.");
            }
            //System.out.println(Sessao.getUsuarioLogado().getNome());
            Long idUser = buscarPeloUSuario(Sessao.getUsuarioLogado().getNome());
            preparedStatement.setLong(6, idUser);
            preparedStatement.setTimestamp(7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
        }

        public Produto buscarPeloProduto(String nome){
            String sql = String.format("SELECT * FROM produto WHERE nome = '%s'", nome);
            try{
                ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
                if(result.next()){
                    return getProduto(result);
                }
            } catch(SQLException e){
                System.out.println("Error" + e.getMessage());
            }

            return null;
        }

        private Produto getProduto(ResultSet result) throws SQLException {
            Produto produto = new Produto();
            produto.setNome(result.getString("nome"));
            produto.setDescricao(result.getString("descricao"));
            produto.setPreco(result.getBigDecimal("preco"));
            produto.setQuantidade(result.getInt("quantidade"));
            Usuario usuarioLogado = Sessao.getUsuarioLogado();
            if (usuarioLogado != null) {
                produto.setUsuario(usuarioLogado);
            } else {
                throw new IllegalStateException("Nenhum usuário logado encontrado na sessão.");
            }

            produto.setUsuario(Sessao.getUsuarioLogado());
            produto.setCategoria(produtoGlobal.getCategoria());
            produto.setDataHoraCriacao(result.getObject("data_hora_criacao", LocalDateTime.class));
            return produto;
        }

        public int buscarPelaCategoria(String nome){
            String sql = String.format("SELECT * FROM categoria WHERE nome = '%s'", nome);
            ConexaoMysql conexao = new ConexaoMysql();
        try{
            ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
            if(result.next()){
                return getCategoria(result);
            }
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }

        return 0;
    }

        private int getCategoria(ResultSet result) throws SQLException {
            int idCategoria = result.getInt("id");

            return idCategoria;
        }

    public Long buscarPeloUSuario(String nome){
        String sql = String.format("SELECT * FROM usuario WHERE nome = '%s'", nome);
        ConexaoMysql conexao = new ConexaoMysql();
        try{
            ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
            if(result.next()){
                return getIdUsuario(result);
            }
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }

        return null;
    }

    private Long getIdUsuario(ResultSet result) throws SQLException {
        Long idUsuario = result.getLong("id");

        return idUsuario;
    }

}
