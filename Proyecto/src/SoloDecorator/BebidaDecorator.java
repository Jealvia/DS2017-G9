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
public class BebidaDecorator extends AlmuerzoDecorator{

    public BebidaDecorator(IPrecio iPrecio) {
        super(iPrecio);
    }

    @Override
    public double getPrecio() {
        return getiPrecio().getPrecio()+0.5;
    }

    @Override
    public String getDescripcion() {
        return getiPrecio().getDescripcion()+" más bebida";
    }
  
    
}
