/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jimmy
 */
public class Asistente extends Usuario{
    Restaurante rest;

  
    public Restaurante getRest() {
        return rest;
    }
    public void setRest(Restaurante rest) {
        this.rest = rest;
    }
    public Asistente(String nombre, String id, String contraseña, String rol,Restaurante rest) {
        super(nombre, id, contraseña, rol);
        this.rest=rest;
    }
    
}
