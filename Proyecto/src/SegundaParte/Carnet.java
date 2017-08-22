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
public class Carnet {
    
    private final String numeroMatricula="201709654";
    private final String contraseña="a";
    private static double monto = 8.50;
    private  double saldo;

    public Carnet() {
    }

    
     public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public static double getMonto() {
        return monto;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
   
    
    
    
    
    
    
}
