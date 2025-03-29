package com.gestorVendas.componentes;

import com.gestorVendas.dao.AutenficacoDao;
import com.gestorVendas.view.ClienteDao;
import com.gestorVendas.view.FormularioCadastroProduto;
import com.gestorVendas.view.PainelFuncCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConexaoPainelEBotaoCadastrarProduto implements ActionListener {
    private final PainelDeComandoProduto cadastrar;

    public ConexaoPainelEBotaoCadastrarProduto (PainelDeComandoProduto cadastrar) {
        this.cadastrar = cadastrar;
    }

    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        switch(acao){
            case "cadastrarproduto": cadastrar(); break;
        }
    }


    private void cadastrar() {
        FormularioCadastroProduto form = new FormularioCadastroProduto();
        form.setVisible(true);
    }

}
