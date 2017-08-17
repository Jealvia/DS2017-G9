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
public class Ejecutivo extends Almuerzo{

    @Override
    public double getPrecio() {
        return 3.0;
    }

    @Override
    public String getDescripcion() {
        return "Almuerzo ejecutivo";
    }
    
    
}
