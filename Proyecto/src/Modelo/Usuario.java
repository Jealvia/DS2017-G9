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

    public Usuario(String nombre, String id, String contraseña, String rol) {
        this.nombre = nombre;
        this.id = id;
        this.contraseña = contraseña;
        this.rol = rol;
    }
    
}
