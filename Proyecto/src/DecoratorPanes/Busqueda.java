/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import SegundaParte.Platos;
import SegundaParte.Restaurante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Julio Alvia
 */
public class Busqueda extends PaneInterfaceBase{
    private BorderPane root;
    private TextField text_nombre;
    private Label busqueda_nombre, busqueda;
    private Button buscar_nombre;
    private HBox organizar;
    private VBox centro;
    public Busqueda( Stage primaryStage,ArrayList<Platos> listaPlatos) {
        busqueda = new Label("BUSQUEDA");
        buscar_nombre = new Button("Buscar");
        busqueda_nombre = new Label("Nombre");
        text_nombre = new TextField();
        organizar = new HBox(busqueda_nombre, text_nombre, buscar_nombre);
        centro = new VBox(organizar);
        root = new BorderPane();
        root.setTop(busqueda);
        root.setCenter(centro);
        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("BUSQUEDAD DE PLATOS");
        primaryStage.setResizable(false);
        //Busca por nombre o descripcion y luego llama al metodo para mostrar la lista de platos para su 
        //posterior selección.
        buscar_nombre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ListaPlatos lp = new ListaPlatos();
                lp.listaPlatos(listaPlatos, primaryStage);
                lp.pantallaListaPlatos(primaryStage);
            }
        });
    }
    @Override
    public void ConstruirPane(Stage primaryStage, ArrayList<Object> lista) {
        Scene escena = new Scene(root, 800, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
  
 



   

  
    
}
