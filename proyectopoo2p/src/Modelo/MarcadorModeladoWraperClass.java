/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Presentacion.MarcadorVista;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Aqui se define la clase Wraper de MarcadorModeelado
 * @author Julio Alvia
 */

@XmlRootElement (name = "Marcadores")
public class MarcadorModeladoWraperClass {
    //Campos de la clase
    private List<MarcadorModelado> listaMarcador;
    /**
     * Metodo que devuelve la lista de marcadorModelado     *
     * @return La lista de MarcadorModelado
     */
    @XmlElement(name = "marcador")
    public List<MarcadorModelado> getListaMarcador() {
        return listaMarcador;
    }
    /**
     * Metodo que guarda la lista de marcadorModelado     *
     * @param listaMarcador Lista de MarcadorModelado
     */
    public void setListaMarcador(List<MarcadorModelado> listaMarcador) {
        this.listaMarcador = listaMarcador;
    }
}