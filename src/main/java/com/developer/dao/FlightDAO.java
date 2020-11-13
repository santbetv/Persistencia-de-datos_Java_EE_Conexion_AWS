/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.dao;

import com.developer.conexion.Conexion;
import com.developer.modelo.Flight;
import com.developer.util.Utilidad;
import java.sql.Connection;
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
public class FlightDAO implements IGestionDAO {

    private static Logger log = Logger.getLogger(FlightDAO.class);

    @Override
    public void crearFligthDB(Flight flight) {
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        Connection cnxx = db_connect.get_connection();
        try (Connection cnx = cnxx) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO flight ( departure_date,departure_station,arrival_station,flight_number,price,currency) "
                        + "VALUES (?,?,?,?,?,?)");
                ps = cnx.prepareStatement(sql.toString());
                ps.setDate(1, Utilidad.convert(flight.getDeparture_date()));
                ps.setString(2, flight.getDeparture_station());
                ps.setString(3, flight.getArrival_station());
                ps.setString(4, flight.getFlight_number());
                ps.setDouble(5, flight.getPrice());
                ps.setString(6, flight.getCurrency());
                ps.executeUpdate();
                log.info("flight guardado");
            } catch (SQLException e) {
                log.error("Error en proceso de consulta: -->" + e);
            }
        } catch (SQLException ex) {
            log.error("Error en proceso de conexión: -->" + ex);
        } finally {
            Conexion.cerrarPreparedStatement(ps);
            db_connect.cerrar(cnxx);
        }
    }

    @Override
    public void leerFligthDB() {
        Conexion db_connect = new Conexion();
        Connection cnxx = db_connect.get_connection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try (Connection cnx = cnxx) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT * FROM flight");
                ps = cnx.prepareStatement(sql.toString());
                resultSet = ps.executeQuery();
                //Se validan los registros
                while (resultSet.next()) {

                    System.out.println("Departure Station: " + resultSet.getString("departure_station"));
                    System.out.println("Arrival Station: " + resultSet.getString("arrival_station"));
                    System.out.println("Date departure Station: " + resultSet.getDate("departure_date"));

                }

            } catch (SQLException ex) {
                log.error("Error en proceso de conexión: -->" + ex);
            }
        } catch (SQLException ex) {
            log.error("Error en proceso de conexión: -->" + ex);
        } finally {
            Conexion.cerrarPreparedStatement(ps);
            Conexion.cerrarResultSet(resultSet);
            db_connect.cerrar(cnxx);
        }

    }
}
