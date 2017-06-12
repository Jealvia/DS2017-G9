/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModificarPlatos;


import Categoria.Categoria;

import InicioDeSesión.PaneInicioSesion;
import MenuBarAsistente.PaneOrganizaAsistente;

import MenuBarCliente.PaneOrganizeCliente;
import Modelo.Persistencia;
import Modelo.Platos;
import Modelo.Restaurante;
import java.util.HashMap;
import java.util.Iterator;
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
public class PaneModificarPlatos {

    public static BorderPane root4;
    private Image imgLoadFondo4;
    private ImageView imgFondo4;
    private Image imgLoadPlatos4;
    private ImageView imgPlatos4;
    public Label NombreLabel;
    public Label RestauranteLabel;
    public Label CategoriaLabel;
    public Label IngredienteLabel;
    public Label DescripcionLabel;
    public Label TipoLabel;
    public Label ServidoLabel;
    public static TextField NombreText;
    public static TextField RestauranteText;
    public static TextField CategoriaText;
    public static TextField IngredientesText;
    public static TextField DescripcionText;
    public static TextField TipoText;
    public static TextField ServidoText;
    public Button RetornarButton;
    public Button SalirButton;
    public Button ModificarButton;

    public PaneModificarPlatos() {
    }

    public PaneModificarPlatos(Stage primaryStage) {
        imgLoadFondo4 = new Image("/imagenes/fondo4.jpg");
        imgFondo4 = new ImageView(imgLoadFondo4);

        imgFondo4.setFitHeight(800);
        imgFondo4.setFitWidth(800);
        imgLoadPlatos4 = new Image("/imagenes/pt1.jpg");
        imgPlatos4 = new ImageView(imgLoadPlatos4);
        imgPlatos4.setFitHeight(200);
        imgPlatos4.setFitWidth(200);

        this.NombreText = new TextField();
        this.RestauranteText = new TextField();
        this.CategoriaText = new TextField();
        this.IngredientesText = new TextField();
        this.DescripcionText = new TextField();
        this.TipoText=new TextField();
        this.ServidoText=new TextField();

        this.RetornarButton = new Button("Retornar");
        this.SalirButton = new Button("Salir");
        this.ModificarButton = new Button("Modificar");

        this.NombreLabel = new Label("Nombre: ");
        this.RestauranteLabel = new Label("Restaurante: ");
        this.CategoriaLabel = new Label("Categoria: ");
        this.IngredienteLabel = new Label("Ingredientes: ");
        this.DescripcionLabel = new Label("Descripcion: ");
        this.TipoLabel=new Label("Descripcion: ");
        this.ServidoLabel=new Label("Descripcion: ");
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 15);

        RestauranteLabel.setTextFill(Color.rgb(21, 117, 84));
        CategoriaLabel.setTextFill(Color.rgb(21, 117, 84));
        IngredienteLabel.setTextFill(Color.rgb(21, 117, 84));
        DescripcionLabel.setTextFill(Color.rgb(21, 117, 84));
        NombreLabel.setTextFill(Color.rgb(21, 117, 84));
        TipoLabel.setTextFill(Color.rgb(21, 117, 84));
        ServidoLabel.setTextFill(Color.rgb(21, 117, 84));

        NombreLabel.setFont(theFont);
        RestauranteLabel.setFont(theFont);
        CategoriaLabel.setFont(theFont);
        IngredienteLabel.setFont(theFont);
        DescripcionLabel.setFont(theFont);
        TipoLabel.setFont(theFont);
        ServidoLabel.setFont(theFont);

        this.root4 = new BorderPane();
        this.root4.getChildren().add(imgFondo4);

        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("Modificar Platos");
        primaryStage.setResizable(false);
    }

    public static BorderPane getRoot() {
        return root4;
    }

    public void DiseñoVentanaPlatos(Stage primaryStage, HashMap<Integer, Platos> numPlt, Integer opcion, Restaurante restaurante) {
        HashMap<String, Platos> categoriaPlato = new HashMap<String, Platos>();
        HBox PaneHorizontal = new HBox(20, imgPlatos4, RetornarButton);
        HBox PaneHorizontalBotones = new HBox(300, ModificarButton, RetornarButton, SalirButton);
        PaneHorizontal.setAlignment(Pos.CENTER);
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
                PaneOrganizaAsistente root = new PaneOrganizaAsistente();
                root.pantallaAsistente(primaryStage,restaurante.getNombre());
            }
        });
        
        Iterator it = numPlt.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            if (key == opcion) {
                System.out.println("Clave: " + key + " -> Valor: " + numPlt.get(opcion).getNombre());
                NombreText.setText(numPlt.get(opcion).getNombre());
                IngredientesText.setText(numPlt.get(opcion).getIngredientes());
                RestauranteText.setText(numPlt.get(opcion).getObjRestaurante().getNombre());
                DescripcionText.setText(numPlt.get(opcion).getDescripcion());
                CategoriaText.setText(numPlt.get(opcion).getCategoria().getNombre());
                TipoText.setText(numPlt.get(opcion).getTipo());
                ServidoText.setText(numPlt.get(opcion).getServido());
                imgPlatos4.setImage(new Image("/imagenes/pt" + key + ".jpg"));
                //Para que se pueda editar la informacion en los textfielts
                NombreText.setEditable(true);
                IngredientesText.setEditable(true);
                RestauranteText.setEditable(true);
                DescripcionText.setEditable(true);
                CategoriaText.setEditable(true);
                TipoText.setEditable(true);
                ServidoText.setEditable(true);
                

                ModificarButton.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        Categoria categoria = new Categoria(CategoriaText.getText().toLowerCase());

                        Platos pt = new Platos(NombreText.getText(), DescripcionText.getText(), categoria, TipoText.getText(), ServidoText.getText(), restaurante, IngredientesText.getText());

                        categoriaPlato.put(NombreText.getText(), pt);
                        Persistencia.writePlatos(categoriaPlato);
                    }
                });
            }
        }
        VBox PaneOjetos = new VBox(5, NombreLabel, NombreText, RestauranteLabel, RestauranteText, CategoriaLabel, CategoriaText,
                 IngredienteLabel, IngredientesText, TipoLabel, TipoText, ServidoLabel, ServidoText, DescripcionLabel, PaneHorizontal, DescripcionText, PaneHorizontalBotones);
        PaneOjetos.setAlignment(Pos.CENTER_LEFT);
        PaneOjetos.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: Orange;");
        root4.setCenter(PaneOjetos);
    }

    public static void pantallaModificarPlatos(Stage primaryStage, HashMap<Integer, Platos> numPlt, Integer opcion, Restaurante restaurante) {
        PaneModificarPlatos root4 = new PaneModificarPlatos(primaryStage);
        Scene scene = new Scene(root4.getRoot(), 500, 600);
        primaryStage.setScene(scene);
        root4.DiseñoVentanaPlatos(primaryStage, numPlt, opcion, restaurante);
        primaryStage.show();
    }

}
