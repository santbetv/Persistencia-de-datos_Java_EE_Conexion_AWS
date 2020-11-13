/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.service;

import com.developer.dao.FlightDAO;
import com.developer.modelo.Flight;
import com.developer.util.Utilidad;

/**
 *
 * @author Santiago Betancur Vilegas
 * @email santiago-betancur@hotmail.com
 */
public class ServiceFlight {

    FlightDAO filDAO = new FlightDAO();

    public void crearFligthDB() {

        Flight flight = new Flight();
        flight.setArrival_station("BOG");
        flight.setFlight_number("3615");
        flight.setPrice(522555.23);
        flight.setDeparture_station("CLI");
        flight.setCurrency("COP");
        flight.setDeparture_date(Utilidad.ParseFecha("2020-12-28"));
        filDAO.crearFligthDB(flight);

    }

    public void leerFligthDB() {

        filDAO.leerFligthDB();

    }

}
