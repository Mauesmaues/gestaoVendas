package com.gestorVendas.dao;

import com.gestorVendas.model.Perfil;
import com.gestorVendas.model.Usuario;
import com.gestorVendas.service.NegocioException;
import com.gestorVendas.service.Sessao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;

public class AutenficacoDao {
    private final UsuarioDao usuarioDao;

    public AutenficacoDao() {
        this.usuarioDao = new UsuarioDao();
    }

    public boolean temPermissao(Usuario usuario) {
        try{
            permissao(usuario);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissao", 0);
            return false;
        }
    }

    private void permissao(Usuario usuario) {
        if(!Perfil.ADMIN.equals(usuario.getPerfil())) {
            throw new NegocioException("Sem permissao para realizar essa acao");
        }
    }

    public  Usuario login(LoginDto login){
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsuario(login.getUsuario());
        if(usuario == null || !usuario.isEstado()){
            return null;
        }
        if(usuario.isEstado() && validaSenha(usuario.getSenha(), login.getSenha())){
            Sessao.setUsuarioLogado(usuario);
            return usuario;
        }
        return null;
    }

    private boolean validaSenha(String senhaUsuario, String senhaLogin){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(senhaLogin, senhaUsuario);
    }
}
