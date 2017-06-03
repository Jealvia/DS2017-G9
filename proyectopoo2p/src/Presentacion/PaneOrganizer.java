/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author Jonathan Quintana
 */

import Modelo.MarcadorModelado;
import java.util.ArrayList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PaneOrganizer {
    //Campos de la clase
    private BorderPane _root;
    private ScrollPane  fondoPane;
    
    /**
     * Constructor del PaneOrganizer
     * @param listaMarcadorModelo lista de MarcadoresMarcadores modelo cargados desde el archivo xml 
     * @param primaryStage stage principal que se usa para mostrar los popups con la informacion del marcador modelo
     */
    public PaneOrganizer(ArrayList<MarcadorModelado> listaMarcadorModelo,Stage primaryStage){
        
        _root = new BorderPane();
        fondoPane = new ScrollPane();
        fondoPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        fondoPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
     
        ImageFondo img = new ImageFondo(fondoPane,listaMarcadorModelo,primaryStage);
        _root.setTop(img.getBarraB());
        _root.setCenter(fondoPane);
        
        
    }
    /**
     * 
     * Metodo que devuelve el root que va en el scene 
     * @return el root que va en el scene
     */
    public BorderPane getRoot() {
        return _root;
    }

    
    
}
