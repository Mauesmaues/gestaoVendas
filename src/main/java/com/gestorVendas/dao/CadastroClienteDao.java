package com.gestorVendas.dao;

import com.gestorVendas.controller.RealizarCadastroController;
import com.gestorVendas.model.Cliente;
import com.gestorVendas.model.Perfil;
import com.gestorVendas.model.Usuario;
import com.gestorVendas.util.ConexaoMysql;
import com.gestorVendas.view.ClienteDao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CadastroClienteDao {
    private ConexaoMysql conexao;
    private JLabel mensagemError;
    public String adicionar(Cliente cliente, JLabel mensagemError) {
        this.conexao = new ConexaoMysql();
        this.mensagemError = mensagemError;

        String sql = "INSERT INTO cliente (nome, telefone, endereco) VALUES (?,?,?)";

        Cliente clienteTemp = buscarPeloCliente(cliente.getNome());
        if (clienteTemp != null) {
            mensagemError.setText("Usuário já cadastrado!");
            return String.format("Error: cliente %s ja existe no banco de dados", cliente.getNome());
        }
        try{
            PreparedStatement preparedStatement = conexao.conectar().prepareStatement(sql);
            preencherValoresPreperedStatement(preparedStatement, cliente);
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuario adicionado com sucesso" : "Nao foi possivel adicionar usuario";
        }catch(SQLException e){
            return String.format("Error %s",  e.getMessage());
        }
    }

    private void preencherValoresPreperedStatement(PreparedStatement preparedStatement, Cliente cliente) throws SQLException {
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getTelefone());
        preparedStatement.setString(3, cliente.getEndereco());
    }

    public Cliente buscarPeloCliente(String nome){
        String sql = String.format("SELECT * FROM cliente WHERE nome = '%s'", nome);
        try{
            ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
            if(result.next()){
                return getCliente(result);
            }
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }

        return null;
    }

    private Cliente getCliente(ResultSet result) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNome(result.getString("nome"));
        cliente.setTelefone(result.getString("telefone"));
        cliente.setEndereco(result.getString("endereco"));

        return cliente;
    }
}
