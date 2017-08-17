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
public  class PrecioDecorator implements IPrecio{
    
    private IPrecio iPrecio;
    
    
    public PrecioDecorator(IPrecio newPrecio){
        
        this.iPrecio = newPrecio;
        
    }

    public IPrecio getiPrecio() {
        return iPrecio;
    }

    public void setiPrecio(IPrecio iPrecio) {
        this.iPrecio = iPrecio;
    }

    @Override
    public double agregarPrecio() {
        return iPrecio.agregarPrecio();
    }

    @Override
    public String agregarDescripcion() {
        return iPrecio.agregarDescripcion();
    }

}

  
    
    

   
    
    

