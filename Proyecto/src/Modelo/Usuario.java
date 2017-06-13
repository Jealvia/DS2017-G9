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
public class Usuario {

    private String nombre, id, contraseña, rol;
    public Restaurante rest;

    public Usuario(String nombre, String id, String contraseña, String rol, Restaurante rest) {
        this.nombre = nombre;
        this.id = id;
        this.contraseña = contraseña;
        this.rol = rol;
        this.rest = rest;
    }

    public Usuario(String nombre, String id, String contraseña, String rol) {
        this.nombre = nombre;
        this.id = id;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Restaurante getRest() {
        return rest;
    }

    public void setRest(Restaurante rest) {
        this.rest = rest;
    }

    public String getNombreRestaurante() {
        return this.rest.getNombre();
    }
}
