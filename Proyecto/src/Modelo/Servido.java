/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Julio Alvia
 */
public enum Servido {
    
    FRIO("Frio"),
    CALIENTE("Caliente");
    
    private final String servido;
    
    private Servido(String servido){
        this.servido=servido;
    }
    
}
