/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.dao;

import com.developer.modelo.Flight;

/**
 * 
 * Se Utiliza la
 * Clase abstract cuando es una herencia siendo esta la clase padre
 * agrupando comportamiento en comun de varias clases con sus metodos comunes.
 * 
 * Se Utiliza la
 * interface cuando tiene comportamiento diferencial
 * de varias clases y sus metodos diferentes con atributos constantes, metodos obligatorios.
 *
 * @author Santiago Betancur Vilegas
 * @email santiago-betancur@hotmail.com
 */
public interface  IGestionDAO {
    
    public  void crearFligthDB(Flight flight);
    
    public  void leerFligthDB();

}
