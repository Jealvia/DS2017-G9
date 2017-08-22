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

    private final String numeros="1234";
    private final String CVC="1234";
    private final String fechaExpiracion="04/20";
    public final double saldo=99999;

    public TarjetaCredito() {
    }

    public String getNumeros() {
        return numeros;
    }

    public String getCVC() {
        return CVC;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public double getSaldo() {
        return saldo;
    }

    
    
    
}
