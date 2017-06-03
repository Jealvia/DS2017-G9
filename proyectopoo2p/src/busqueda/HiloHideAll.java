/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

import Presentacion.MarcadorVista;
import java.util.ArrayList;

/**
 * En esta clase se define el ocultar todoslos marcadores usando hilos
 * @author CEEMP02
 */
public class HiloHideAll implements Runnable {
    private ArrayList<MarcadorVista> lista;
    /**
     * Constructor de HiloHideAll
     * @param lista lista de marcadores 
     */
    public HiloHideAll(ArrayList<MarcadorVista> lista){
        this.lista = lista;
    }

    @Override
    public void run() {
        Util utl = new Util();
        utl.OcultarTodo(lista);
    }
    
}
