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
public abstract class AlmuerzoDecorator implements IPrecio{
    private IPrecio iPrecio;

    public AlmuerzoDecorator(IPrecio iPrecio) {
        this.iPrecio = iPrecio;
    }

    public IPrecio getiPrecio() {
        return iPrecio;
    }

    public void setiPrecio(IPrecio iPrecio) {
        this.iPrecio = iPrecio;
    }
    
        
}
