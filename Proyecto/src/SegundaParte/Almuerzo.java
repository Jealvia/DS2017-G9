/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte;
import java.util.LinkedList;

/**
 *
 * @author FAUSTO LOPEZ
 */
public class Almuerzo {
    public Segundo segundo;
    public Sopa sopa;
    public LinkedList<Platos> extras;
    public double precio;

    public Almuerzo() {
    }
       
   
    public Sopa getSopa() {
        return sopa;
    }

    public LinkedList<Platos> getExtras() {
        return extras;
    }

    public void setExtras(LinkedList<Platos> extras) {
        this.extras = extras;
    }

    public void setSopa(Sopa sopa) {
        this.sopa = sopa;
    }

    public Segundo getSegundo() {
        return segundo;
    }

    public void setSegundo(Segundo segundo) {
        this.segundo = segundo;
    }
   
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
