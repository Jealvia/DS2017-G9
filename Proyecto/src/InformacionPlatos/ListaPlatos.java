/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformacionPlatos;

import Modelo.Platos;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    VBox vbox;
    HBox hbox;
    private Stage primaryStage;
    BorderPane contenedor;
    
    public ListaPlatos(ArrayList<Platos> lista,Stage primaryStage) {
        VBox vbox=new VBox();
        for (Platos m : lista) {
            HBox hbox=new HBox();
            Label nombre = new Label("Nombre: "+m.getNombre()+"\n"+"Restaurante: "+m.getNombreRestaurante().getNombre());
            hbox.getChildren().addAll(nombre);
            vbox.getChildren().add(hbox);
        }
        BorderPane contenedor=new BorderPane();
        contenedor.setCenter(vbox);
        Scene escena=new Scene(contenedor);
        primaryStage.setScene(escena);
        primaryStage.show();
        hbox.setOnMouseClicked((MouseEvent me)->{
            //aqui se debe enlazar tu ventana Jimmy
        });
    }

    public BorderPane getContenedor() {
        return contenedor;
    }

    public void setContenedor(BorderPane contenedor) {
        this.contenedor = contenedor;
    }
    
    
    
    
    
    
}
