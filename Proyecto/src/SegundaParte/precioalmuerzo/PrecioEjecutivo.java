/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte.precioalmuerzo;

/**
 *
 * @author FAUSTO LOPEZ
 */
public class PrecioEjecutivo extends PrecioBuilder{

    @Override
    public void definirDescripcion() {
        precio = new AlmuerzoPrecio();
        precio.descripcion = "Almuerzo Ejecuitvo";
    }

    @Override
    public void definirPrecio() {
        precio.precio = 3.0;
    }
    
}
