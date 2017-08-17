/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmuerzoBuilder;

import SegundaParte.Almuerzo;
import SegundaParte.Bebida;
import SegundaParte.Postre;
import SegundaParte.Segundo;
import SegundaParte.Sopa;

/**
 *
 * @author FAUSTO LOPEZ
 */
public class EjecutivoBuilder extends LunchBuilder {

    @Override
    public void buildPrice() {
        precio = 3.0;
    }


    
}
