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
public class PagoTarjetaCredito implements IPago{
    
    private TarjetaCredito tarjeta;

    @Override
    public boolean realizarPago(double pago) {
        if(this.tarjeta.getSaldo()<pago){
            return true;
        }else{
            return false;
        }
    }
    
}
