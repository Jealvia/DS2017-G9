/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import SegundaParte.Platos;
import java.awt.TextArea;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneFormasDePago {
    private Label LabeltarjetaCredito;
    private Label LabelCarnetInteligente;
    private Label labelTitulo;
    private Button pagarPorTarjeta;
    private Button pagarPorCarnet;
    public static BorderPane root5;
    private Image imgLoadFondo3;
    private ImageView imgFondo3;
    private TextArea txtUsuario;
    private PasswordField ingreso_Contraseña;
    private TextArea txtCVC;
    private TextArea txtNumero;
    private TextArea txtFechaExpiracion;
    private HBox PaneObjetos1;
    private VBox PaneObjetos;
    private HBox PaneObjetos2;
  
    public PaneFormasDePago(Stage primaryStage,ArrayList<Platos> listaPlatos) {
        primaryStage.setTitle("FORMAS DE PAGO");
        primaryStage.setResizable(false);
        root5 = new BorderPane();
        LabeltarjetaCredito=new Label("Tarjeta de Credito");
        LabelCarnetInteligente=new Label("Carnet Inteligente");
        labelTitulo=new Label("PAGO");
        txtNumero=new TextArea();
        txtCVC=new TextArea();
        txtFechaExpiracion=new TextArea();
        txtUsuario=new TextArea();
        ingreso_Contraseña= new PasswordField();
        ingreso_Contraseña.setPromptText("Your password");
        imgLoadFondo3 = new Image("/imagenes/fondo10.jpg");
        imgFondo3 = new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(600);
        imgFondo3.setFitWidth(1100);
        pagarPorTarjeta=new Button("Pagar con tarjeta");
        pagarPorCarnet=new Button("Pagar con Carnet ");
        PaneObjetos1=new HBox(200,LabeltarjetaCredito,LabelCarnetInteligente);
        PaneObjetos1.setAlignment(Pos.CENTER);
        PaneObjetos2=new HBox(100,PaneObjetos);
        PaneObjetos2.setAlignment(Pos.CENTER);
        PaneObjetos=new VBox(50,labelTitulo,PaneObjetos1);
        PaneObjetos.setAlignment(Pos.TOP_CENTER);
        PaneObjetos.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: yellow;");
        root5.getChildren().addAll(imgFondo3);
        root5.setCenter(PaneObjetos);
    }

    // metodo que me obtiene el root1
    public BorderPane getRoot() {
        return root5;
    }
    public void eventoBotonPagarPorTarjeta(){
        pagarPorTarjeta.setOnAction(new EventHandler<ActionEvent>(){   
            @Override
            public void handle(ActionEvent event) {
                //AQUI SE PRESENTA EL PANE FORMAS DE PAGO
//                LunchDirector  director= new LunchDirector(new EjecutivoBuilder()); 
//                director.buildAlmuerzo();
//                if (postres.getValue() != null){
//                    IPrecio precio = new PostrePrecio(director.getLunch());
//                    precio = new PostrePrecio(precio);
//                }else if(bebidas.getValue()!=null){
//                    
//                }
            }
        });
    }
    public  void pantallaAlmuerzoEjecutivo(Stage primaryStage,ArrayList<Platos> listaPlatos) {
        PaneAlmuerzoEjecutivo root3 = new PaneAlmuerzoEjecutivo(primaryStage,listaPlatos);
        Scene scene = new Scene(root3.getRoot(), 1100, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
