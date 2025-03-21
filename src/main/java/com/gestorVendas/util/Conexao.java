package com.gestorVendas.util;

import java.sql.Connection;
import java.sql.SQLException;

public interface Conexao {
    public Connection conectar() throws SQLException;
}
