/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

import InformacionPlatos.ListaPlatos;
import Modelo.Platos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
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
public class Busqueda {

    private BorderPane root;
    private TextField text_nombre;
    private Label busqueda_nombre, busqueda;
    private Button buscar_nombre;
    private HBox organizar;
    private VBox centro;

    public Busqueda() {

    }

    public Busqueda(HashMap<String, Platos> listaplatos, Stage primaryStage) {
        busqueda = new Label("BUSQUEDA");
        buscar_nombre = new Button("Buscar");
        busqueda_nombre = new Label("Nombre");
        text_nombre = new TextField();
        organizar = new HBox(busqueda_nombre, text_nombre, buscar_nombre);
        centro = new VBox(organizar);
        root = new BorderPane();
        root.setTop(busqueda);
        root.setCenter(centro);

        Scene escena = new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.show();

        //Busca por nombre o descripcion y luego llama al metodo para mostrar la lista de platos para su 
        //posterior selección.
        buscar_nombre.setOnAction((ActionEvent e) -> {
            ArrayList<Platos> lista = new ArrayList<>();
            for (Map.Entry<String, Platos> entry : listaplatos.entrySet()) {
                if (entry.getValue().getNombre().contains(text_nombre.getText()) || entry.getValue().getDescripcion().contains(text_nombre.getText())) {
                    lista.add(entry.getValue());
                }
            }
            ListaPlatos platos = new ListaPlatos(lista, primaryStage);
        });

    }

}
