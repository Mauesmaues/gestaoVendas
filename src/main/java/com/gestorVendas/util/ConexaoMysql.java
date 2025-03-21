package com.gestorVendas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql implements Conexao {
    private final String url = "jdbc:mysql://localhost:3306/gestorVendas";
    private final String usuario = "root";
    private final String senha = "814739";
    private Connection conexao;

    @Override
    public Connection conectar() throws SQLException {

    if (conexao == null) {
        conexao = DriverManager.getConnection(url, usuario, senha);
    }
    return conexao;
    }
}
