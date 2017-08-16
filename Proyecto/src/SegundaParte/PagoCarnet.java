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
public class PagoCarnet implements IPago{

    private Carnet carnet;
    
    @Override
    public boolean realizarPago(double pago) {
        if(carnet.getSaldo()<pago){
            return true;
        }else{
            return false;
        }
    }
    
}
