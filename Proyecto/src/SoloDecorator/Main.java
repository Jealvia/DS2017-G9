/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoloDecorator;

/**
 *
 * @author FAUSTO LOPEZ
 */
public class Main {
    
    public static void main(String[] args) {
        IPrecio almuerzo = new Ejecutivo();
        almuerzo = new BebidaDecorator(almuerzo) ;
        almuerzo = new PostreDecorator(almuerzo);
        System.out.println(almuerzo.getDescripcion() + ", Precio "+ almuerzo.getPrecio());

        IPrecio almuerzo2 = new Ejecutivo();
        almuerzo2 = new BebidaDecorator(almuerzo2) ;
        
        System.out.println(almuerzo2.getDescripcion() + ", Precio "+ almuerzo2.getPrecio());
        
        IPrecio almuerzo3 = new Ejecutivo();
        almuerzo3 = new PostreDecorator(almuerzo3) ;
        
        System.out.println(almuerzo3.getDescripcion() + ", Precio "+ almuerzo3.getPrecio());
        
        IPrecio almuerzo4 = new Estudiantil();
               
        System.out.println(almuerzo4.getDescripcion() + ", Precio "+ almuerzo4.getPrecio());
    }
    
}
