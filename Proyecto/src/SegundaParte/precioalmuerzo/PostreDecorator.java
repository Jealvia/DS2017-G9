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
public class PostreDecorator extends PrecioDecorator{

    public PostreDecorator(IPrecio newPrecio) {
        super(newPrecio);
    }

    @Override
    public double agregarPrecio() {
        System.out.println("Postre Decorator");
        return getiPrecio().agregarPrecio() + 0.75;
    }

    @Override
    public String agregarDescripcion() {
        System.out.println("Descripcion Postre Decorator");
        return getiPrecio().agregarDescripcion() + "más Postre";
    }
    
    
}