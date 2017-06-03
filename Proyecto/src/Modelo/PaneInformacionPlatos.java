/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.PaneInicioSesion.MensajeLabel;
import static Modelo.PaneInicioSesion.rootPrincipal;
import static Modelo.PaneOrganizaCliente.root1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneInformacionPlatos {
    public static BorderPane root4;
    private Image imgLoadFondo4;
    private ImageView imgFondo4;
    private Image imgLoadPlatos4;
    private ImageView imgPlatos4;
    public static Label RestauranteLabel;
    public static Label CategoriaLabel;
    public static Label IngredienteLabel;
    public static Label DescripcionLabel;
    public static TextField RestauranteText;
    public static TextField CategoriaText;
    public static TextField IngredientesText;
    public static TextField DescripcionText;
    public static Button siguienteIMGButton;
    public static Button anteriorIMGButton;

    public PaneInformacionPlatos(Stage primaryStage) {
        imgLoadFondo4=new Image("/imagenes/fondo4.jpg");
        imgFondo4=new ImageView(imgLoadFondo4);
//        this.imgLoadLogin=new Image("/imagenes/login.png");
//        this.imgLogin=new ImageView(imgLoadLogin);
        imgFondo4.setFitHeight(500);
        imgFondo4.setFitWidth(800);
        imgLoadPlatos4=new Image("/imagenes/fondo2.jpg");
        imgPlatos4=new ImageView(imgLoadPlatos4);
        imgPlatos4.setFitHeight(100);
        imgPlatos4.setFitWidth(100);
        
        this.siguienteIMGButton=new Button(">");
        this.anteriorIMGButton=new Button("<");
        
        this.RestauranteText=new TextField();
        this.CategoriaText=new TextField();
        this.IngredientesText=new TextField();
        this.DescripcionText=new TextField();
        
        this.RestauranteLabel=new Label("Restaurante: ");
        this.CategoriaLabel=new Label("Categoria: ");
        this.IngredienteLabel=new Label("Ingredientes: ");
        this.DescripcionLabel=new Label("Descripcion: ");
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 15);
        
        RestauranteLabel.setTextFill(Color.rgb(21, 117, 84));
        CategoriaLabel.setTextFill(Color.rgb(21, 117, 84));
        IngredienteLabel.setTextFill(Color.rgb(21, 117, 84));
        DescripcionLabel.setTextFill(Color.rgb(21, 117, 84));
        
        RestauranteLabel.setFont(theFont);
        CategoriaLabel.setFont(theFont);
        IngredienteLabel.setFont(theFont);
        DescripcionLabel.setFont(theFont);
        
        this.root4=new BorderPane();
        this.root4.getChildren().add(imgFondo4);
        
        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("Informacion Platos");
        primaryStage.setResizable(false);
        
    }
    public static BorderPane getRoot(){
        return root4;
    }
    public void MenuObjetos(Stage primaryStage){
        siguienteIMGButton.setOnAction(new EventHandler <ActionEvent>(){
            public void handle(ActionEvent event) 
            {
                System.out.println("SALIO DEL SISTEMA");
                imgLoadPlatos4=new Image("/imagenes/pt1.jpg");
                imgPlatos4=new ImageView(imgLoadPlatos4);
            }
        });
        HBox PaneHorizontal=new HBox(10,anteriorIMGButton,imgPlatos4,siguienteIMGButton);
        PaneHorizontal.setAlignment(Pos.CENTER);
        VBox PaneOjetos=new VBox(5,RestauranteLabel,RestauranteText,CategoriaLabel,CategoriaText
        ,IngredienteLabel,IngredientesText,DescripcionLabel,DescripcionText,PaneHorizontal);
        PaneOjetos.setAlignment(Pos.CENTER_LEFT);
        root4.setStyle("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: Orange;"); 
        
        root4.setCenter(PaneOjetos);
    }
    
}
