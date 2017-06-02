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
public enum Tipo {
    
    APERITIVO("Aperitivo"),
    POSTRE("Postre"),
    PLATO_FUERTE("Plato fuerte");
    
    private final String tipo;
    
    private Tipo(String tipo){
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    
}
