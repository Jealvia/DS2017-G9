/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.Categoria;
import Modelo.MarcadorModelado;
import busqueda.OrganizerBusqueda;
import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Point2D;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



/**
 * Clase en la que se generan el Pane de la imagen de fondo y todo lo que contiene 
 * @author Jonathan Quintana
 * 
 */

public class ImageFondo {
    //Campos de la clase
    private static final String image_path = "DataAccess/mapa.png";
    private Rectangle rec;
    private ArrayList<MarcadorVista> listaMarcadoresVista;
    private ArrayList<MarcadorModelado> listaMarcadores;
    private Pane pane;
    Stage primaryStage;
    private HBox barraB;
    
    /**
     * Constructor para ImageFondo 
     * @param root el parametro root es un ScrollPane sobre el cual pone la imagen de fondo y los marcadores
     * @param listaMarcadormodelo el parametro listaMarcadormodelo es una lista de listaMarcadormodelo
     * @param primaryStage el parametro primaryStage es el stage principal que se utiliza para mostrar los popup con la informacion de los marcadores
     */    
    public ImageFondo(ScrollPane root, ArrayList<MarcadorModelado> listaMarcadormodelo, Stage primaryStage) {

        this.listaMarcadoresVista = new ArrayList<MarcadorVista>();
        this.listaMarcadores = listaMarcadormodelo;
        this.primaryStage = primaryStage;

        Image img = new Image(image_path);

        ImagePattern imagePattern = new ImagePattern(img);

        rec = new Rectangle(2284, 1352);
        rec.setFill(imagePattern);

        pane = new Pane();
        pane.getChildren().add(rec);
        cargarMarcadores();
        EliminarMarcador.setListaMarcadorModelado(listaMarcadormodelo);
        EliminarMarcador.setListaMarcadorVista(listaMarcadoresVista);
        OrganizerBusqueda a = new OrganizerBusqueda(listaMarcadoresVista);
        barraB = a.getRoot();
        
        root.setContent(pane);
        
        setPosition(0, 0);
        rec.setOnMouseClicked((MouseEvent me) -> {
            if (me.getClickCount() == 2) {
                Point2D p = new Point2D(me.getX() - 35, me.getY() - 70);
                MarcadorVentanaEdicion m = new MarcadorVentanaEdicion(pane, p, listaMarcadoresVista, listaMarcadores, primaryStage);

            }
        });
    }//Cierre constructor

    
    /**
     * Metodo que devuelve la barra de busqueda que va en la parte superior del root principal
     * @return Barra de busqueda
     */
    public HBox getBarraB() {
        return barraB;
    }
    
    /***
     * Metodo que posciciona la imagen de fondo 
     * @param x poscicion en x de la imagen
     * @param y poscicion en y de la imagen
     */    
    public void setPosition(double x, double y){
        rec.setTranslateX(x);
        rec.setTranslateY(y);
    }//Cierre del metodo
    /**
     * Metodo que dada la lista de MarcadorModelo carga los marcadores sobre la imagen de fondo
     */
    public void cargarMarcadores(){
        if(listaMarcadores==null){
            return;
        }else if (listaMarcadores.isEmpty()){
            return ;
        }
        for(MarcadorModelado a: listaMarcadores){
            ArrayList<File> imagenes=new ArrayList<File>();
            for(String b:a.getImagePaths()){
                imagenes.add(new File(b));
            }
            listaMarcadoresVista.add(new MarcadorVista(a,a.getCategoria(),pane,new Point2D(a.getPosX(),a.getPosY()) ,imagenes, this.primaryStage));
            
        }
    }//Cierre del metodo
  
}