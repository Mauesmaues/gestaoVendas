package com.gestorVendas.dao;

import com.gestorVendas.model.Perfil;
import com.gestorVendas.model.Usuario;
import com.gestorVendas.util.ConexaoMysql;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private final ConexaoMysql conexao;

    public UsuarioDao() {
        this.conexao = new ConexaoMysql();
    }
    
    public String salvar(Usuario usuario) {
        return usuario.getId() == 0 ? adicionar(usuario) : editar(usuario);
    }

    private String editar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, usuario = ?, senha = ?, perfil = ?, estado = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = conexao.conectar().prepareStatement(sql);
            preencherValoresPreperedStatement(preparedStatement, usuario);
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuario atualizado com sucesso" : "Nao foi possivel atualizar usuario";
        }catch(SQLException e){
            return String.format("Error %s",  e.getMessage());
        }
    }

    private String adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, usuario, senha, perfil, estado) VALUES (?,?,?,?,?)";

        Usuario usuarioTemp = buscarUsuarioPeloUsuario(usuario.getUsuario());
        if (usuarioTemp != null) {
            return String.format("Error: username %s ja existe no banco de dados", usuario.getUsuario());
        }
        try{
            PreparedStatement preparedStatement = conexao.conectar().prepareStatement(sql);
            preencherValoresPreperedStatement(preparedStatement, usuario);
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuario adicionado com sucesso" : "Nao foi possivel adicionar usuario";
        }catch(SQLException e){
            return String.format("Error %s",  e.getMessage());
        }
    }

    private void preencherValoresPreperedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String senhaCrypto = passwordEncoder.encode(usuario.getSenha());
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getUsuario());
        preparedStatement.setString(3, senhaCrypto);
        preparedStatement.setString(4, usuario.getPerfil().name());
        preparedStatement.setBoolean(5, usuario.isEstado());
        if(usuario.getId() != 0){
            preparedStatement.setLong(6, usuario.getId());
        }
    }

    public List<Usuario> buscarTodosUsuarios(){
        String sql = "Select * from usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try{
            ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
            while(result.next()){
                usuarios.add(getUsuario(result));
            }
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }

        return usuarios;
    }

    private Usuario getUsuario(ResultSet result) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));
        usuario.setPerfil(result.getObject("perfil", Perfil.class));
        usuario.setEstado(result.getBoolean("estado"));
        usuario.setDataHoraCriacao(result.getObject("data hora criacao", LocalDateTime.class));
        usuario.setUltimoLogin(result.getObject("ultimo login", LocalDateTime.class));

        return usuario;
    }

    public Usuario buscarUsuarioPeloID(Long id){
        String sql = String.format("SELECT * FROM usuario WHERE id = %d", id);
        try{
            ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
            if(result.next()){
                return getUsuario(result);
            }
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }

        return null;
    }

    public Usuario buscarUsuarioPeloUsuario(String usuario){
        String sql = String.format("SELECT * FROM usuario WHERE id = '%s'", usuario);
        try{
            ResultSet result = conexao.conectar().prepareStatement(sql).executeQuery();
            if(result.next()){
                return getUsuario(result);
            }
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }

        return null;
    }
}
