package com.gestorVendas.controller;

import com.gestorVendas.dao.CategoriaDao;
import com.gestorVendas.model.Categoria;
import com.gestorVendas.view.FormularioCadastroDeCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriaController implements ActionListener {

    private final FormularioCadastroDeCategoria categoria;

    public CategoriaController (FormularioCadastroDeCategoria categoria) {
        this.categoria = categoria;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = this.categoria.getNome().getText();
        String descricao = this.categoria.getDescricao().getText();
        String acao = e.getActionCommand().toLowerCase();

        if(nome.equals("")){
            this.categoria.getMensagemError().setText("Preencha o campo nome!");
        }else {
            switch (acao) {
                case "realizarcadastro":
                    System.out.println("Realizando cadastro de categoria");
                    cadastrar(nome, descricao);
                    break;
            }
        }
    }


    private void cadastrar(String nome, String descricao) {
        Categoria categoriaClass = new Categoria(0L, nome, descricao);
        CategoriaDao cadastrarCategoria = new CategoriaDao();
        cadastrarCategoria.adicionar(categoriaClass, this.categoria.getMensagemError());
    }
}
