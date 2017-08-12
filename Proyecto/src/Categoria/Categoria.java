/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import java.util.Objects;

/**
 *
 * @author Julio Alvia
 */
public class Categoria {

    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Categoria) {
            Categoria p = (Categoria) o;
            return this.nombre.equals(p.nombre);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

}
