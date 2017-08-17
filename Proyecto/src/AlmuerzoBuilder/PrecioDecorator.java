/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmuerzoBuilder;

/**
 *
 * @author jimmy
 */
public  class PrecioDecorator implements IPrecio{

   private IPrecio iDecorator;
    
   public PrecioDecorator(IPrecio newDecorator){
       this.iDecorator = newDecorator; 
   }

    public IPrecio getiDecorator() {
        return iDecorator;
    }

    public void setiDecorator(IPrecio iDecorator) {
        this.iDecorator = iDecorator;
    }

    @Override
    public double getPrecio() {
        return iDecorator.getPrecio();
    }
    
    
    
}
