/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmuerzoBuilder;

import SegundaParte.Almuerzo;


/**
 *
 * @author FAUSTO LOPEZ
 */
public abstract class LunchBuilder {
    
    protected double precio; 
    
    public double getLunch(){
        return precio;
    }
    
    public abstract void buildPrice();
    
    
    
}
