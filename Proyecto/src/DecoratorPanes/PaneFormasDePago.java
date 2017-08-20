/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import SegundaParte.Platos;
import java.util.ArrayList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneFormasDePago {

    private Label LabeltarjetaCredito;
    private Label LabelCarnetInteligente;
    private Label labelTitulo;
    private Label LabelNumero;
    private Label LabelCVC;
    private Label labelFechaExpiracion;
    private Label LabelUsuario;
    private Label LabelContraseña;
    private Button pagarPorTarjeta;
    private Button pagarPorCarnet;
    public static BorderPane root5;
    private Image imgLoadFondo3;
    private ImageView imgFondo3;
    private TextField txtUsuario;
    private PasswordField ingreso_Contraseña;
    private TextField txtCVC;
    private TextField txtNumero;
    private TextField txtFechaExpiracion;
    private VBox PaneObjetos1;
    private VBox PaneObjetos;
    private VBox PaneObjetos2;

    public PaneFormasDePago(Stage primaryStage) {
        primaryStage.setTitle("FORMAS DE PAGO");
        primaryStage.setResizable(false);
        root5 = new BorderPane();
        LabeltarjetaCredito = new Label("Tarjeta de Credito");
        LabelCarnetInteligente = new Label("Carnet Inteligente");
        labelTitulo = new Label("******PAGOS******");
        LabelNumero = new Label("Numero:");
        LabelCVC = new Label("CVC:");
        labelFechaExpiracion = new Label("Fecha de expiracion: ");
        LabelUsuario=new Label("Usuario:" );
        LabelContraseña=new Label("Contraseña: ");
        txtNumero = new TextField();
        txtCVC = new TextField();
        txtFechaExpiracion = new TextField();
        txtUsuario = new TextField();
        ingreso_Contraseña = new PasswordField();
        ingreso_Contraseña.setPromptText("Your password");
        imgLoadFondo3 = new Image("/imagenes/fondo9.jpg");
        imgFondo3 = new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(520);
        imgFondo3.setFitWidth(500);
        pagarPorTarjeta = new Button("Pagar");
        pagarPorCarnet = new Button("Pagar");
        PaneObjetos1 = new VBox(1, LabeltarjetaCredito,LabelNumero,txtNumero,LabelCVC,txtCVC,labelFechaExpiracion,txtFechaExpiracion,pagarPorTarjeta);
        PaneObjetos2=new VBox(1,LabelCarnetInteligente,LabelUsuario,txtUsuario,LabelContraseña,ingreso_Contraseña,pagarPorCarnet);
        root5.getChildren().addAll(imgFondo3);
        
       
        
    }

    // metodo que me obtiene el root1
    public BorderPane getRoot() {
        return root5;
    }
    public void diseñoVentanaFormasDePago(){
        
        PaneObjetos1.setAlignment(Pos.CENTER_LEFT);
        PaneObjetos1.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: yellow;");
        
        PaneObjetos2.setAlignment(Pos.CENTER_LEFT);
        PaneObjetos2.setStyle("-fx-padding: 10;"
        + "-fx-border-style: solid inside;"
        + "-fx-border-width: 8;"
        + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;"
        + "-fx-border-color: blue;");
        
        PaneObjetos = new VBox(50, labelTitulo, PaneObjetos2,PaneObjetos1);
        PaneObjetos.setAlignment(Pos.TOP_CENTER);
       
        root5.setCenter(PaneObjetos);
    }
    public void eventoBotonPagarPorTarjeta() {
        pagarPorTarjeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //AQUI SE MOSTRARA UN MENSAJE DE QUE SE A REALIZADO LA COMPRA PARA ESTO FALTA
                //Una vez aprobado y procesado el pago,
                //Se le mostrará al usuario el número de orden
            }
        });
    }

    public void eventoBotonPagarPorCarnet() {
        pagarPorTarjeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //AQUI SE MOSTRARA UN MENSAJE DE QUE SE A REALIZADO LA COMPRA PARA ESTO FALTA
                //Una vez aprobado y procesado el pago,
                //Se le mostrará al usuario el número de orden
            }
        });
    }

    public void pantallaFormasDePago(Stage primaryStage) {
        PaneFormasDePago root = new PaneFormasDePago(primaryStage);
        Scene scene = new Scene(root.getRoot(), 500, 520);
        primaryStage.setScene(scene);
        diseñoVentanaFormasDePago();
        primaryStage.show();
    }
}
