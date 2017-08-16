/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte;

import java.util.Date;

/**
 *
 * @author Julio Alvia
 */
public class TarjetaCredito {

    private String numeros;
    private String CVC;
    private Date fechaExpiracion;
    public static double saldo=99999;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        TarjetaCredito.saldo = saldo;
    }
    
    
}
