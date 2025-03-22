package com.gestorVendas;

import com.gestorVendas.dao.UsuarioDao;
import com.gestorVendas.model.Perfil;
import com.gestorVendas.model.Usuario;

import java.time.LocalDateTime;

public class UsuarioTest {
    public static void main(String[] args){
        Usuario usuario = new Usuario(0, "Eduada Budnik", "1234", "Duda", Perfil.ADMIN, LocalDateTime.MIN, LocalDateTime.MIN);

        UsuarioDao usuarioDao = new UsuarioDao();

        String mensagem = usuarioDao.salvar(usuario);
        System.out.println(mensagem);

    }
}
