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
public class PrecioAlmuerzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DirectorPrecio director = new DirectorPrecio(new PrecioEjecutivo());
        director.construirPrecio();
        IPrecio ejPrecio = new BebidaDecorator((director.getAlmuerzoPrecio()));
        ejPrecio.agregarPrecio();
        ejPrecio.agregarDescripcion();
        
        System.out.println(director.getAlmuerzoPrecio().toString());
               
        
        System.out.println();
    }
    
}
