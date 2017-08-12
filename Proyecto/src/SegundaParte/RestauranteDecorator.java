/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package SegundaParte;
 
/**
 *
 * @author Julio Alvia
 */
 
public abstract class RestauranteDecorator implements IRestaurante {
 
    private IRestaurante iRestaurante;
 
    public RestauranteDecorator(IRestaurante iRestaurante){
        setiRestaurante(iRestaurante);
    }

    public IRestaurante getiRestaurante() {
        return iRestaurante;
    }

    public void setiRestaurante(IRestaurante iRestaurante) {
        this.iRestaurante = iRestaurante;
    }
    
 
    
 
}
 