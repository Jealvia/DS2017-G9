/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgregarPlatillo;

import MenuBarAsistente.PaneOrganizaAsistente;
import MenuBarCliente.PaneOrganizeCliente;
import Modelo.Persistencia;
import Modelo.Platos;
import Modelo.Restaurante;
import Modelo.Usuario;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
public class PaneAgregarPlatillo {
    public static BorderPane root4;
    private Image imgLoadFondo4;
    private ImageView imgFondo4;
    private Image imgLoadPlatos4;
    private ImageView imgPlatos4;
    private Label NombreLabel;
    private  Label CategoriaLabel;
    private Label IngredienteLabel;
    private Label DescripcionLabel;
    private Label TipoLabel;
    private Label ServidoLabel;
    private    TextField NombreText;
    private TextField CategoriaText;
    private TextField IngredientesText;
    private TextField DescripcionText;
    private  TextField TipoText;
    private TextField ServidoText;
    private Button RetornarButton;
    private  Button SalirButton;
    private Button ModificarButton;
    private Button AgregarButton;
    public PaneAgregarPlatillo(Stage primaryStage) {
        imgLoadFondo4=new Image("/imagenes/fondo5.jpg");
        imgFondo4=new ImageView(imgLoadFondo4);

        imgFondo4.setFitHeight(700);
        imgFondo4.setFitWidth(500);
    
        
        this.NombreText=new TextField();
        this.CategoriaText=new TextField();
        this.IngredientesText=new TextField();
        this.DescripcionText=new TextField();
        this.TipoText=new TextField();
        this.ServidoText=new TextField();
        
        this.RetornarButton=new Button("Retornar");
        this.SalirButton=new Button("Salir");
        this.ModificarButton=new Button("Modificar");
        this.AgregarButton=new Button("Agregar");
       
        this.NombreLabel=new Label("Nombre: ");
        this.CategoriaLabel=new Label("Categoria: ");
        this.IngredienteLabel=new Label("Ingredientes: ");
        this.DescripcionLabel=new Label("Descripcion: ");
        this.TipoLabel=new Label("Tipo: ");
        this.ServidoLabel=new Label("Servido: ");
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 15);
        
        CategoriaLabel.setTextFill(Color.rgb(21, 117, 84));
        IngredienteLabel.setTextFill(Color.rgb(21, 117, 84));
        DescripcionLabel.setTextFill(Color.rgb(21, 117, 84));
        NombreLabel.setTextFill(Color.rgb(21, 117, 84));
        TipoLabel.setTextFill(Color.rgb(21, 117, 84));
        ServidoLabel.setTextFill(Color.rgb(21, 117, 84));
        
        NombreLabel.setFont(theFont);
        CategoriaLabel.setFont(theFont);
        IngredienteLabel.setFont(theFont);
        DescripcionLabel.setFont(theFont);
        TipoLabel.setFont(theFont);
        ServidoLabel.setFont(theFont);
        
        this.root4=new BorderPane();
        this.root4.getChildren().add(imgFondo4);
        
        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("AGREGAR PLATILLO");
        primaryStage.setResizable(false); 
    }

    public static BorderPane getRoot(){
        return root4;
    }
    public void DiseñoVentanaAgregarPlatos(Stage primaryStage,Restaurante restaurante,String id){
        HashMap<String,Platos> categoriaPlato=new HashMap<String,Platos> ();
        HBox PaneHorizontalBotones=new HBox(100,AgregarButton,RetornarButton,SalirButton);
        PaneHorizontalBotones.setAlignment(Pos.CENTER);
        SalirButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("SALIO DEL SISTEMA");
                primaryStage.close();
                System.exit(0);//importante para poder salir del Output
            }
        });
        RetornarButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            PaneOrganizaAsistente root1 =new PaneOrganizaAsistente();
            root1.pantallaAsistente(primaryStage,restaurante.getNombre(),id);
     
            }          
                
            
        });
        AgregarButton.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                Platos pt=new Platos(NombreText.getText(),DescripcionText.getText(), CategoriaText.getText().toLowerCase(), TipoText.getText(), ServidoText.getText(),restaurante,IngredientesText.getText());
                categoriaPlato.put(CategoriaText.getText(), pt);
                Persistencia.writePlatos(categoriaPlato);
            }
        });
        VBox PaneOjetos=new VBox(5,NombreLabel,NombreText,CategoriaLabel,CategoriaText
        ,IngredienteLabel,IngredientesText,TipoLabel,TipoText,ServidoLabel,ServidoText,DescripcionLabel,DescripcionText,PaneHorizontalBotones);
        PaneOjetos.setAlignment(Pos.CENTER_LEFT);
        PaneOjetos.setStyle("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: Orange;");       
        root4.setCenter(PaneOjetos);
    }
    public  void pantallaAgregarPlatosAsistente(Stage primaryStage,Restaurante restaurante,String id){
        PaneAgregarPlatillo root4=new PaneAgregarPlatillo(primaryStage);       
        Scene scene=new Scene(root4.getRoot(),500,700);
        primaryStage.setScene(scene);
        root4.DiseñoVentanaAgregarPlatos(primaryStage,restaurante,id);
        primaryStage.show();
    }
  
}