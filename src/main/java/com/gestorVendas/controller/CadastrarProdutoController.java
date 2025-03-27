package com.gestorVendas.controller;

import com.gestorVendas.dao.CategoriaDao;
import com.gestorVendas.dao.ProdutoDao;
import com.gestorVendas.model.Categoria;
import com.gestorVendas.model.Produto;
import com.gestorVendas.model.Usuario;
import com.gestorVendas.service.Sessao;
import com.gestorVendas.util.ConexaoMysql;
import com.gestorVendas.view.FormularioCadastroDeCategoria;
import com.gestorVendas.view.FormularioCadastroProduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CadastrarProdutoController implements ActionListener {

    private final FormularioCadastroProduto cadastroProduto;

    public CadastrarProdutoController (FormularioCadastroProduto produto) {
        this.cadastroProduto = produto;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = this.cadastroProduto.getNome().getText();
        String descricao = this.cadastroProduto.getDescricao().getText();
        String precoString = this.cadastroProduto.getPreco().getText();
        BigDecimal preco = BigDecimal.valueOf(15.00);
        if (precoString != null && !precoString.trim().isEmpty()) {
            try {
                preco = new BigDecimal(precoString.trim());
                System.out.println("Preço válido: " + preco);
            } catch (NumberFormatException d) {
                System.out.println("O valor inserido não é um número válido: " + precoString);
                // Aqui você pode notificar o usuário ou definir um valor padrão
            }
        } else {
            System.out.println("O campo de preço está vazio ou nulo.");
            // Defina uma ação, como exibir um erro ou definir um valor padrão
        }

        Integer quantidade = Integer.parseInt(this.cadastroProduto.getQuantitidade().getText());
        String categoria = this.cadastroProduto.getCategoria().getSelectedItem().toString();
        String acao = e.getActionCommand().toLowerCase();

        if(nome.equals("")){
            //this.cadastroProduto.getMensagemError().setText("Preencha o campo nome!");
            System.out.println("Preencha campo nome!");
        }else {
            switch (acao) {
                case "cadastrar":
                    System.out.println("Realizando cadastro de categoria");
                    cadastrar(nome, descricao, preco, quantidade, categoria);
                    break;
            }
        }
    }


    private void cadastrar(String nome, String descricao, BigDecimal preco, Integer quantidade, String categoria) {
        Categoria categoriaTemp = buscarPelaCategoria(categoria);
        Usuario usuarioLogado = Sessao.getUsuarioLogado();
        Produto produtoClass = new Produto(0L, nome, descricao, preco, quantidade, categoriaTemp, usuarioLogado, LocalDateTime.MIN);
        ProdutoDao cadastrarProduto = new ProdutoDao();
        cadastrarProduto.adicionar(produtoClass, this.cadastroProduto.getErrorMensagem());
    }

    public Categoria buscarPelaCategoria(String nome){
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

        return null;
    }

    private Categoria getCategoria(ResultSet result) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(result.getLong("id"));
        categoria.setNome(result.getString("nome"));
        categoria.setDescricao(result.getString("descricao"));

        return categoria;
    }
}
