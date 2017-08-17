/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmuerzoBuilder;


/**
 *
 * @author FAUSTO LOPEZ
 */
public class LunchDirector {
    
    private LunchBuilder builder;
    
    public LunchDirector(LunchBuilder builder){
        
        this.builder = builder;
        
    }
    
    public void buildAlmuerzo(){
        
        
        builder.buildPrice();
        
    }
    
    public double getLunch(){
        
        return builder.getLunch();
        
    }
    
}
