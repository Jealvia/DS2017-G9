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
    
    private static String numeroMatricula="201709654";
    private static String contraseña="a";
    private static double saldo=2.50;

    public static String getNumeroMatricula() {
        return numeroMatricula;
    }

    public static void setNumeroMatricula(String numeroMatricula) {
        Carnet.numeroMatricula = numeroMatricula;
    }

    public static String getContraseña() {
        return contraseña;
    }

    public static void setContraseña(String contraseña) {
        Carnet.contraseña = contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        Carnet.saldo = saldo;
    }
    
    
    
    
}
