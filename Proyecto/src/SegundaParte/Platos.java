/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte;

import java.io.File;

/**
 *
 *
 *
 * @author Julio Alvia
 *
 */
public class Platos {

    private String nombre;
    private String descripcion;
    private String ingredientes;
    private String tipo;
    private String servido;
    private Categoria categoria;
    private File[] imagen;
    
    public Platos(String nombre, String descripcion, String ingredientes, String tipo, String servido, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
        this.servido = servido;
        this.categoria = categoria;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String isServido() {
        return servido;
    }

    public void setServido(String servido) {
        this.servido = servido;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
}
