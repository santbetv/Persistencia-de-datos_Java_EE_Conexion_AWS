/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.conexion;

import com.developer.util.Constantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * 
 *
 * @author Santiago Betancur Vilegas
 * @email santiago-betancur@hotmail.com
 */
public class Conexion {

    
    private static final Logger log = Logger.getLogger(Conexion.class);
    
    public Connection get_connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constantes.RUTA_BASE_DATOS, Constantes.USUARIO, Constantes.PASSWORD);

        } catch (SQLException ex) {
             log.error("Error en proceso de conexión: -->" + ex);
        }
        return connection;
    }

    public static synchronized void cerrarResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqle) {
                 log.error("Error en proceso en el cierre de ResultSet: -->" + sqle);
                sqle.printStackTrace();
            }
        }
    }

    public static synchronized void cerrarPreparedStatement(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqle) {
                 log.error("Error en proceso en el cierre de Statement: -->" + sqle);
                sqle.printStackTrace();
            }
        }
    }

    /**
     * Cierra la conexión con la base de datos.
     *
     * @return retorna true si no se produce ninguna excepci�n durante la
     * operación.
     */
    public boolean cerrar(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
            return true;
        } catch (SQLException sqle) {
            log.error("Error cerrando Connection: " + Constantes.RUTA_BASE_DATOS);
            log.error(sqle.getMessage());
            return false;
        }
    }

}
