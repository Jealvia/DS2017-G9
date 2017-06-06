/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

import InformacionPlatos.ListaPlatos;
import Modelo.Platos;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Julio Alvia
 */
public class Busqueda {
    private BorderPane root;
    private TextField text_nombre;
    private Label busqueda_nombre,busqueda;
    private Button buscar_nombre;
    private HBox organizar;
    private VBox centro;
    private ScrollPane lmarcadores;
    private ListaPlatos platos;
    public Busqueda(){
        
    
    }
    
    public void OrganizadorBusqueda(HashMap<String, Platos> listaplatos,Stage primaryStage){
        busqueda=new Label("BUSQUEDA");
        buscar_nombre=new Button("Buscar");
        busqueda_nombre=new Label("Nombre");
        text_nombre=new TextField();
        organizar=new HBox(busqueda_nombre,text_nombre,buscar_nombre);
        centro=new VBox(organizar);
        root=new BorderPane();
        root.setTop(busqueda);
        root.setCenter(centro);
        
        Scene escena=new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.show();
    
    
    buscar_nombre.setOnAction((ActionEvent e) -> {
        ArrayList<Platos> lista = new ArrayList<>();
        for (Map.Entry<String, Platos> entry : listaplatos.entrySet()) {
            if (entry.getValue().getNombre().contains(text_nombre.getText()) || entry.getValue().getDescripcion().contains(text_nombre.getText()) ) {
                lista.addAll((Collection<? extends Platos>) entry.getValue());
            }
        }
        ListaPlatos platos=new ListaPlatos(lista,primaryStage);
    });
    
    }
}
