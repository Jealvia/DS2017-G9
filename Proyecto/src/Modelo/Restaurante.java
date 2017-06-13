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
public class Restaurante {

    private String nombre, descripcion, telefono;

    public Restaurante(String nombre) {
        this.nombre = nombre;
    }

    public Restaurante() {

    }

    public Restaurante(String nombre, String descripcion, String telefono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
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
        this.nombre = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
