/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.PaneOrganizaCliente.root1;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneOrganizaAsistente {
    public static BorderPane root2;
    private Image imgLoadFondo2;
    private ImageView imgFondo2;

    public PaneOrganizaAsistente(Stage primaryStage) {
        imgLoadFondo2=new Image("/imagenes/fondo2.jpg");
        imgFondo2=new ImageView(imgLoadFondo2);
        imgFondo2.setFitHeight(500);
        imgFondo2.setFitWidth(800);
        root2=new BorderPane();
        root2.getChildren().add(imgFondo2);
    }
      // metodo que me obtiene el root1
    BorderPane getRoot(){
        return root2;
    }
    
}
