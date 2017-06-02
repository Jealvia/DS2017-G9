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
public enum Categoria {
    
    ESTUDIANTIL("estudiantil"),
    EJECUTIVO("ejecutivo");
    
    private final String categoria;
    
    private Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    
}
