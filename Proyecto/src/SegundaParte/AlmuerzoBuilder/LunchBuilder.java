/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte.AlmuerzoBuilder;


/**
 *
 * @author FAUSTO LOPEZ
 */
public abstract class LunchBuilder {
    
    protected Almuerzo almuerzo; 
    
    public Almuerzo getLunch(){
        return almuerzo;
    }
    
    public abstract void buildLunch();
    
    public abstract void buildSegundo();
    public abstract void buildSopa();
    
    public abstract void buildPrice();
    
    public abstract void buildExtras();
    
}
