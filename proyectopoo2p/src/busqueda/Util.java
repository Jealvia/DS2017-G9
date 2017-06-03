/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

import Modelo.Categoria;
import Modelo.MarcadorModelado;
import Presentacion.MarcadorVista;
import java.util.ArrayList;

/**
 * Clase que define los metodos de busqueda, mostrar y ocultar
 * @author CEEMP02
 */
public class Util {
    
    public Util(){
        
    }
    
    /**
     * Metodo de busqueda que devuelve una lista de MarcadorVista
     * @param tmp lista de todos los marcadores
     * @param cat categoria a buscar
     * @return lista de MarcadorVista
     */
    
    public ArrayList<MarcadorVista> Busqueda(ArrayList<MarcadorVista> tmp,Categoria cat){
        //for (Estudiante e: linkedEstudiantes){
        //OcultarTodo(tmp);
        ArrayList<MarcadorVista> tmp2=new ArrayList<MarcadorVista>();
        for(MarcadorVista e: tmp){
           
            MarcadorModelado tmp1 = e.getMarcador();
            if(tmp1.getCategoria() != cat){
                e.getRectangulo().setVisible(false);
            }else {
                tmp2.add(e);
            }
        }
        return tmp2;
        
    }
    /**
     * Medoto que muestra todos los marcadores
     * @param tmp lista de marcadores
     */
    public void MostrarTodo(ArrayList<MarcadorVista> tmp){
        for(MarcadorVista e: tmp){
            e.getRectangulo().setVisible(true);
            
        }
    }
    /**
     * Metodo que oculta todos los marcadores
     * @param tmp lista de marcadores
     */
    public void OcultarTodo(ArrayList<MarcadorVista> tmp){
        for(MarcadorVista e: tmp){
            e.getRectangulo().setVisible(false);
            
        }
    }
}
