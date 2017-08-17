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
public abstract class PrecioBuilder {
    
    protected AlmuerzoPrecio precio;
    
    public AlmuerzoPrecio getPrecio (){
        return precio;
    }
    
    public abstract void  definirDescripcion();
    public abstract void  definirPrecio();
    
    
}
