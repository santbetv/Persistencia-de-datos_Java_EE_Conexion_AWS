/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Santiago Betancur Vilegas
 * @email santiago-betancur@hotmail.com
 */
public class Constantes {
    
    public static  String RUTA_BASE_DATOS = "";
    public static  String USUARIO = "";
    public static  String PASSWORD = "";

    static {

        try {
            Properties properties = new Properties();
            BasicConfigurator.configure();

            properties.load(new FileReader("./src/main/resources/META-INF/config.properties"));

            RUTA_BASE_DATOS = properties.get("RUTA_BASE_DATOS").toString();
            USUARIO = properties.get("USUARIO").toString();
            PASSWORD = properties.get("PASSWORD").toString();
            //System.out.println(properties.get("RUTA_RECURSOS"));

        } catch (IOException ex) {
            Logger.getLogger(Constantes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
