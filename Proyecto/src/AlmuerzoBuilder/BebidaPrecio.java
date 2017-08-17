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
public class BebidaPrecio extends PrecioDecorator{
    
    public BebidaPrecio(IPrecio newDecorator) {
        super(newDecorator);
    }

    @Override
    public double getPrecio() {
        return getiDecorator().getPrecio()+0.50;
    }
    
}
