/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneOrganizaCliente {
    
    public static BorderPane root1;
    private Image imgLoadFondo1;
    private ImageView imgFondo1;

    public PaneOrganizaCliente(Stage primaryStage) {
        imgLoadFondo1=new Image("/imagenes/fondo1.jpg");
        imgFondo1=new ImageView(imgLoadFondo1);
        imgFondo1.setFitHeight(500);
        imgFondo1.setFitWidth(800);
        root1=new BorderPane();
        root1.getChildren().add(imgFondo1);
    }
    // metodo que me obtiene el root1
    BorderPane getRoot(){
        return root1;
    }
    
    
}
