/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
//CAMBIA
//2

import Categoria.Categoria;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Julio Alvia
 */
public class Platos<E> {

    private String nombre, descripcion, tipo, servido, ingredientes;
    Categoria categoria;
    private Restaurante restaurante;

    public Platos(String nombre, String descripcion, Categoria categoria, String tipo, String servido, Restaurante restaurante, String ingredientes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipo = tipo;
        this.servido = servido;
        this.restaurante = restaurante;
        this.ingredientes = ingredientes;
    }
    public Platos() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getServido() {
        return servido;
    }

    public void setServido(String servido) {
        this.servido = servido;
    }

    public Restaurante getObjRestaurante() {
        return restaurante;
    }

    public void setNombreRestaurante(Restaurante nombreRestaurante) {
        this.restaurante = nombreRestaurante;
    }

    public ArrayList<Platos> listarPlatos(HashMap<String, Platos> listPlatos, String categoria) {
        ArrayList<Platos> lista = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if (entry.getValue().getCategoria().getNombre().equals(categoria)) {
                lista.addAll((Collection<? extends Platos>) entry.getValue());
            }
        }
        return lista;
    }

    //lista de platos que solo pertenecen a un restaurante
    public ArrayList<E> listarPlatosAsistente(HashMap<String, Platos> listPlatos, String restaurante) {
        ArrayList<E> lista = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if (entry.getValue().getObjRestaurante().getNombre().equals(restaurante)) {
                lista.addAll((Collection<? extends E>) entry.getValue());
            }
        }
        return lista;
    }
}
