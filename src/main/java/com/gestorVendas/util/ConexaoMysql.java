package com.gestorVendas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql implements Conexao {
    private final String url = "jdbc:mysql://localhost:3306/gestao_venda";
    private final String usuario = "root";
    private final String senha = "814739";
    private Connection conexao;

    @Override
    public Connection conectar() throws SQLException {

        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, usuario, senha);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null; // Pode ser tratado de outra forma
        }
        return conexao;
    }

    public void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;  // Evita conexões não gerenciadas
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
