/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformacionPlatos;

import Modelo.Persistencia;
import Modelo.Platos;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Julio Alvia
 */
public class ListaPlatos {
    Label nombre;
    Rectangle rectangulo;
    static VBox vbox;
    HBox hbox;
    private Stage primaryStage;
    static BorderPane contenedor;
    static ArrayList<String> list;
     //PARA PRESENTAR LISTA DE OPCIONES
    static ObservableList<String> tiposPlatos;
    static ListView<String> listaPlatos; 

    
    public  ListaPlatos(ArrayList<Platos> lista,Stage primaryStage) {
        vbox=new VBox();
        hbox=new HBox();
        list=new ArrayList<String>();
        
         //******************************************************************
        contenedor=new BorderPane();
        contenedor.setCenter(vbox);
       
//        Scene escena=new Scene(contenedor);
//        primaryStage.setScene(escena);
//        primaryStage.show();
//        hbox.setOnMouseClicked((MouseEvent me)->{
//            //aqui se debe enlazar tu ventana Jimmy
//            PaneInformacionPlatos.pantallaInformacionPlatos(primaryStage);
//        });
    }
    public static  void mostrarListaPltaos(ArrayList<Platos> lista,Stage primaryStage){
        for (Platos m : lista) {
            System.out.println("**"+m.getNombre());
//            Label nombre = new Label("Nombre: "+m.getNombre()+"\n"+"Restaurante: "+m.getNombreRestaurante().getNombre());
            list.add("Nombre: "+m.getNombre()+"\n"+"Restaurante: "+m.getNombreRestaurante().getNombre());
//            hbox.getChildren().addAll(nombre);
//            vbox.getChildren().add(nombre);
            vbox.setAlignment(Pos.CENTER);
        }
        //PARA PRESENTAR UNA LISTA DE OPCIONES
        ListaPlatos.tiposPlatos = FXCollections.observableArrayList(list); 
        listaPlatos = new ListView<String>(tiposPlatos);
        vbox.getChildren().add(listaPlatos);
        Scene escena=new Scene(getContenedor(),800,400);
        primaryStage.setScene(escena);
        listaPlatos.setOnMouseClicked((MouseEvent me)->{
            //aqui se debe enlazar tu ventana Jimmy
            PaneInformacionPlatos.pantallaInformacionPlatos(primaryStage);
        });
        primaryStage.show();
    }
    public static BorderPane getContenedor() {
        return contenedor;
    }

    public void setContenedor(BorderPane contenedor) {
        this.contenedor = contenedor;
    }
    
    
    
    
    
    
}
