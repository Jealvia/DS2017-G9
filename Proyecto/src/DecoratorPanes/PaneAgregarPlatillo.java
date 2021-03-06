/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;
//cambia
//2

import Modelo.Persistencia;
import SegundaParte.Categoria;
import SegundaParte.Platos;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneAgregarPlatillo extends PaneInterfaceBase {

    public static BorderPane root4;
    private Image imgLoadFondo4;
    private ImageView imgFondo4;
    private Image imgLoadPlatos4;
    private ImageView imgPlatos4;
    public Label NombreLabel;
    public Label CategoriaLabel;
    public Label IngredienteLabel;
    public Label DescripcionLabel;
    public Label TipoLabel;
    public Label ServidoLabel;
    public static TextField NombreText;
    public static TextField CategoriaText;
    public static TextField IngredientesText;
    public static TextField DescripcionText;
    public static TextField TipoText;
    public static TextField ServidoText;
    public Button RetornarButton;
    public Button SalirButton;
    public Button ModificarButton;
    public Button AgregarButton;

    public PaneAgregarPlatillo(Stage primaryStage) {
        imgLoadFondo4 = new Image("/imagenes/fondo5.jpg");
        imgFondo4 = new ImageView(imgLoadFondo4);

        imgFondo4.setFitHeight(700);
        imgFondo4.setFitWidth(500);

        this.NombreText = new TextField();
        this.CategoriaText = new TextField();
        this.IngredientesText = new TextField();
        this.DescripcionText = new TextField();
        this.TipoText = new TextField();
        this.ServidoText = new TextField();

        this.RetornarButton = new Button("Retornar");
        this.SalirButton = new Button("Salir");
        this.ModificarButton = new Button("Modificar");
        this.AgregarButton = new Button("Agregar");

        this.NombreLabel = new Label("Nombre: ");
        this.CategoriaLabel = new Label("Categoria: ");
        this.IngredienteLabel = new Label("Ingredientes: ");
        this.DescripcionLabel = new Label("Descripcion: ");
        this.TipoLabel = new Label("Tipo: ");
        this.ServidoLabel = new Label("Servido: ");
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

        this.root4 = new BorderPane();
        this.root4.getChildren().add(imgFondo4);

        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("AGREGAR PLATILLO");
        primaryStage.setResizable(false);
    }

    public static BorderPane getRoot() {
        return root4;
    }

    public void DiseñoVentanaAgregarPlatos(Stage primaryStage, String restaurante) {
        ArrayList<Platos> listaPlatos = new ArrayList<>();
        HBox PaneHorizontalBotones = new HBox(100, AgregarButton, RetornarButton, SalirButton);
        PaneHorizontalBotones.setAlignment(Pos.CENTER);
        SalirButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                System.exit(0);//importante para poder salir del Output
            }
        });
        RetornarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PaneOrganizeAsistente root = new PaneOrganizeAsistente();
                root.pantallaAsistente(primaryStage, restaurante);
            }
        });
        AgregarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Categoria categoria = new Categoria(CategoriaText.getText().toLowerCase());
                Platos pt = new Platos(NombreText.getText(), DescripcionText.getText(), IngredientesText.getText(), TipoText.getText(), ServidoText.getText(), categoria, restaurante);
                listaPlatos.add(pt);
                Persistencia.writePlatos(listaPlatos);
            }
        });
        VBox PaneOjetos = new VBox(5, NombreLabel, NombreText, CategoriaLabel, CategoriaText,
                IngredienteLabel, IngredientesText, TipoLabel, TipoText, ServidoLabel, ServidoText, DescripcionLabel, DescripcionText, PaneHorizontalBotones);
        PaneOjetos.setAlignment(Pos.CENTER_LEFT);
        PaneOjetos.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: Orange;");
        root4.setCenter(PaneOjetos);
    }

    @Override
    public void ConstruirPane(Stage primaryStage, ArrayList<Object> lista) {
        PaneAgregarPlatillo root4 = new PaneAgregarPlatillo(primaryStage);
        Scene scene = new Scene(root4.getRoot(), 500, 700);
        primaryStage.setScene(scene);
        root4.DiseñoVentanaAgregarPlatos(primaryStage, (String) lista.get(0));
        primaryStage.show();
    }

}
