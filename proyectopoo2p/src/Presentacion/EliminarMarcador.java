/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.MarcadorModelado;
import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

/**
 * Esta clase define el manejador de evento de eliminar un marcador
 * @author AngelArturo
 */
public class EliminarMarcador implements EventHandler<ActionEvent>{
    //Campos de la clase
    private static ArrayList<MarcadorModelado> listaMarcadorModelado;
    private static ArrayList<MarcadorVista> listaMarcadorVista;
    private MarcadorVista mv;
    private Dialog d;
    
    /**
     * Constructor para eliminar marcador
     * @param marcadorVista El parametro marcadorVista contiene el marcador que se quiere eliminar
     * @param dialog El parametro dialog es la ventana de dialogo en la cual se llama al evento eliminar marcador
     */
    public EliminarMarcador(MarcadorVista marcadorVista,Dialog dialog) {        
        this.mv = marcadorVista;
        this.d=dialog;
    }//Cierre del constructor
    /**
     * Metodo que elimina el marcador selecionado de las listas de marcadores dentro de la aplicacion
     * contiene un  alert que se usa para confirmar la eliminacion
     */
       @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Eliminar Marcador");
        alert.setContentText("Esta seguro de eliminar el marcador");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            EliminarMarcador.listaMarcadorVista.remove(mv);
            EliminarMarcador.listaMarcadorModelado.remove(mv.getMarcador());
            mv.getRectangulo().setVisible(false);
            System.out.println(event.getSource());
            d.close();

        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }//Cierre del metodo
    /**
     * Metodo que guarda la lista de MarcadorModelado dentro de la clase EliminarMarcador
     * @param listaMarcadorModelado lista de MarcadorModelado
     */
    public static void setListaMarcadorModelado(ArrayList<MarcadorModelado> listaMarcadorModelado) {
        EliminarMarcador.listaMarcadorModelado = listaMarcadorModelado;
    }
    /**
     * Metodo que guarda la lista de MarcadorVista dentro de la clase EliminarMarcador
     * @param listaMarcadorVista lista de MarcadorMarcadorVista
     */
    public static void setListaMarcadorVista(ArrayList<MarcadorVista> listaMarcadorVista) {
        EliminarMarcador.listaMarcadorVista = listaMarcadorVista;
    }
}
