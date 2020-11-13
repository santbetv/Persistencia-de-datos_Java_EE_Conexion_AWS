/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.ejecutador;

import com.developer.conexion.Conexion;
import com.developer.service.ServiceFlight;
import java.sql.Connection;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Ejecutar proyecto 
 *
 * @author Santiago Betancur Vilegas
 * @email santiago-betancur@hotmail.com
 */
public class EjecutarProyecto {

    private static final Logger log = Logger.getLogger(EjecutarProyecto.class);
    private static ServiceFlight serviceFlight = new ServiceFlight();

    public static void main(String[] args) {

        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.get_connection()) {

//            serviceFlight.crearFligthDB();
//            log.info("flight guardado");
            serviceFlight.leerFligthDB();
            log.info("flight listado");

//            log.debug("Hello World!");
//            log.info("Info Message Logged !!!");
//            log.error("Error Message Logged !!!", new NullPointerException("NullError"));
        } catch (Exception ex) {
            log.error("Error en proceso de conexión: -->" + ex);
        }
    }

}
