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
public class Pago {
    
    private IPago iPago;

    public Pago(IPago iPago) {
        this.iPago = iPago;
    }

    public boolean ejecutarPago(double pago){
        return this.iPago.realizarPago(pago);
    }
    
}
