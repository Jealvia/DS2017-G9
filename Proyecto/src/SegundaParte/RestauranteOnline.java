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
public class RestauranteOnline extends RestauranteDecorator {

    public RestauranteOnline(IRestaurante iRestaurante) {
        super(iRestaurante);
    }

    @Override
    public void agregarDetalles() {
        //Se le agregan detalles adicionales en caso de que se requiera lo que sea
    }

    @Override
    public boolean setOnline() {
        return true;
    }
    
}
