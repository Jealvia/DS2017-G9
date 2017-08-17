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
public class BebidaDecorator extends PrecioDecorator{

    public BebidaDecorator(IPrecio newPrecio) {
        super(newPrecio);
    }

    @Override
    public double agregarPrecio() {
       System.out.println("Bebida Decorator"); 
        return getiPrecio().agregarPrecio() + 0.5;
    }

    @Override
    public String agregarDescripcion() {
        System.out.println("Descripcion Bebida Decorator");
        return getiPrecio().agregarDescripcion() + " más Bebida";
    }   
    
    
}
