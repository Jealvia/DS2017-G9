/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

import Modelo.Platos;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Julio Alvia
 */
public class Busqueda {
    private BorderPane root;
    private TextField text_nombre,text_descripcion;
    private Label busqueda_nombre,busqueda_descripcion,busqueda;
    private Button buscar_nombre,buscar_descipcion;
    private HBox organizar,organizar1;
    private VBox centro;
    
    
    public Busqueda(){
        
    
    }
    
    public void Organizador(HashMap<String, Platos> listaplatos){
        busqueda=new Label("BUSQUEDA");
        buscar_nombre=new Button("Buscar");
        buscar_descipcion=new Button("Buscar");
        busqueda_nombre=new Label("Nombre");
        busqueda_descripcion=new Label("Descripción");
        text_nombre=new TextField();
        text_descripcion=new TextField();
        organizar=new HBox(busqueda_nombre,text_nombre,buscar_nombre);
        organizar1=new HBox(busqueda_descripcion,text_descripcion,buscar_descipcion);
        centro=new VBox(organizar,organizar1);
        root=new BorderPane();
        root.setTop(busqueda);
        root.setCenter(centro);
        
    
    
    buscar_nombre.setOnAction((ActionEvent e) -> {
        
    
    
    });
    
    buscar_descipcion.setOnAction((ActionEvent e) -> {
        
    
    
    });
    }
}
