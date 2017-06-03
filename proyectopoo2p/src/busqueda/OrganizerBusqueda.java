/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

import Modelo.Categoria;
import Presentacion.MarcadorVista;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Esta clase define la barra de busqueda segun su categoria
 * @author ESTUDIANTE
 */

public class OrganizerBusqueda {
    //Campos de la clase
    private HBox root;    
    private Label lbCat;
    private Button btnbusqueda, showAll,hideAll;
    private ChoiceBox<Categoria> catego; 
    private ArrayList<MarcadorVista> listamarcadores;
    private Categoria cat;
    private String str;
    private Thread t1,t2,t3;
    private boolean bandera;
    private BorderPane root2;
    private Label marcadores;
    private ScrollPane lmarcadores;
    /**
     * Constructor de OrganizerBusqueda
     * @param tmp lista de maracadores sobre la cual se va a buscar
     */
    public OrganizerBusqueda(ArrayList<MarcadorVista> tmp){
        PaneOrganizer(tmp);
        
    }
    /**
     * Metodo que ubica los elementos de la barra de busqueda 
     * @param tmp lista de maracadores sobre la cual se va a buscar
     */
    public void PaneOrganizer(ArrayList<MarcadorVista> tmp){
        
        this.listamarcadores=tmp;
        //this.cat = cat;
        root = new HBox();
        lbCat = new Label("Seleccione la categoria: ");
        btnbusqueda = new Button("Buscar");
        showAll = new Button("Mostrar todo");
        hideAll = new Button("Ocultar todo");
        catego = new ChoiceBox<>();
        catego.setItems(FXCollections.observableArrayList(Categoria.values()));
        root.getChildren().addAll(lbCat,catego,btnbusqueda,showAll,hideAll);
        root.setSpacing(20);
        
        root2= new BorderPane();
        marcadores= new Label("Lista de marcadores");
        lmarcadores = new ScrollPane();
        root2.setTop(marcadores);
        root2.setCenter(lmarcadores);
        root2.setVisible(false);
                
        manejadorBusqueda();
        mostrarTodo();
        ocultarTodo();
        
        
    }
    /**
     * Metodo que ubica la accion de busqueda 
     * tambien crea una ventana de dialogo con la informacion de los marcadores encontrados
     */
    public void manejadorBusqueda(){
        btnbusqueda.setOnAction(e ->{
         Util utl = new Util();
         utl.MostrarTodo(listamarcadores);
         this.cat = catego.getSelectionModel().getSelectedItem();
         HiloBuscar h1 = new HiloBuscar(listamarcadores,cat,lmarcadores);
         Thread t1 = new Thread(h1);
         t1.start();
         root2.setVisible(true);
         Dialog d= new Dialog();
         d.getDialogPane().setContent(root2);
         d.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
         d.getDialogPane().setMinHeight(500);
         d.getDialogPane().setMinWidth(250);
         d.setWidth(500);
         d.setHeight(500);
         d.showAndWait();
        });
    }//Cierre del metodo
    /**
     * Metodo que ubica la accion de mostrar todo
     */
    public void mostrarTodo(){
        showAll.setOnAction(e ->{
        HiloShowAll h2 = new HiloShowAll(listamarcadores);
        t2 = new Thread(h2);
        t2.start();
        });
    }//Cierre del metodo
    /**
     * Metodo que ubica la accion de ocultar todo
     */
    public void ocultarTodo(){
        hideAll.setOnAction(e ->{
        HiloHideAll h3 = new HiloHideAll(listamarcadores);
        t3 = new Thread(h3);
        t3.start();
        });
    }
    /**
     * Metodo que devuelve el HBox de la barra de busqueda
     * @return el HBox de la barra de busqueda
     */
    public HBox getRoot() {
        return root;
    }
   
 }
    

