/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.PaneOrganizaAsistente.root2;
import static Modelo.PaneOrganizaCliente.root1;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneOrganizaAdministrador {
    public static BorderPane root3;
    private Image imgLoadFondo3;
    private ImageView imgFondo3;

    public PaneOrganizaAdministrador(Stage primaryStage) {
        imgLoadFondo3=new Image("/imagenes/fondo3.jpg");
        imgFondo3=new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(500);
        imgFondo3.setFitWidth(800);
        root3=new BorderPane();
        root3.getChildren().add(imgFondo3);
    }
    
    // metodo que me obtiene el root1
    BorderPane getRoot(){
        return root3;
    }
}
