/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte.AlmuerzoBuilder;

import SegundaParte.Almuerzo;
import SegundaParte.Bebida;
import SegundaParte.Postre;
import SegundaParte.Segundo;
import SegundaParte.Sopa;

/**
 *
 * @author FAUSTO LOPEZ
 */
public class EjecutivoBuilder extends LunchBuilder{

    @Override
    public void buildLunch() {
        almuerzo = new Almuerzo();
    }


    @Override
    public void buildPrice() {
        almuerzo.precio = 3;
    }

    @Override
    public void buildSegundo() {
        almuerzo.segundo = new Segundo();
    }

    @Override
    public void buildSopa() {
        almuerzo.segundo = new Sopa();
    }

    @Override
    public void buildExtras() {
        almuerzo.extras.add(new Bebida());
        almuerzo.extras.add(new Postre());
    }
    
}
