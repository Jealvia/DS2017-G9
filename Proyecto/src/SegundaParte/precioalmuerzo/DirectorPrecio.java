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
public class DirectorPrecio {
    
    private PrecioBuilder builder;
    public DirectorPrecio(PrecioBuilder builder){
        this.builder = builder;
    }
    
    public void construirPrecio(){
        
        builder.definirDescripcion();
        builder.definirPrecio();
        
    }
    
    public AlmuerzoPrecio getAlmuerzoPrecio(){
        return builder.getPrecio();
    }
    
}
