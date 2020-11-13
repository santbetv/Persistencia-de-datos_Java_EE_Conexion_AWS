/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.dao;

import com.developer.modelo.Flight;

/**
 * Clase abstract utilizar siempre en la herenciacomo clase padre
 * agrupando comportamiento en comun de varias clases con sus metodos comunes.
 *
 * @author Santiago Betancur Vilegas
 * @email santiago-betancur@hotmail.com
 */
public interface  IGestionDAO {
    
    public  void crearFligthDB(Flight flight);
    
    public  void leerFligthDB();

}
