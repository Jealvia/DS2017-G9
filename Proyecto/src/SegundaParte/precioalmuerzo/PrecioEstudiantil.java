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
public class PrecioEstudiantil extends PrecioBuilder{

    @Override
    public void definirDescripcion() {
        precio = new AlmuerzoPrecio();
        precio.descripcion = "Almuerzo Estudiantil";
    }

    @Override
    public void definirPrecio() {
        precio.precio = 2.0;
    }
    
}
