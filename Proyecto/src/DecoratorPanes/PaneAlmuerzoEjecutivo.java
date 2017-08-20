package DecoratorPanes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import SegundaParte.Platos;
import java.util.ArrayList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneAlmuerzoEjecutivo {

    private Label titulo;
    private Label categoria;
    private Label segundo;
    private Label sopa;
    private Label postre;
    private Label bebida;
    private Button aceptar;
    public static BorderPane root3;
    private Image imgLoadFondo3;
    private ImageView imgFondo3;
    private ChoiceBox segundos;
    private ChoiceBox sopas;
    private ChoiceBox postres;
    private ChoiceBox bebidas;
    private HBox PanePlatosChoiceBox;
    private VBox PaneObjetos;
    private VBox PaneBotonChoiceBox;
    private HBox PanePlatosLabels;
    private Stage primaryStage;
    private ArrayList<Platos> listaPlatos;
    public PaneAlmuerzoEjecutivo(Stage primaryStage, ArrayList<Platos> listaPlatos) {
        this.primaryStage=primaryStage;
        this.listaPlatos=listaPlatos;
        primaryStage.setTitle("COMPRA ONLINE");
        primaryStage.setResizable(false);
        root3 = new BorderPane();
        titulo = new Label("COMPRA ONLINE");
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 15);
        titulo.setFont(theFont);
        Font theFont1 = Font.font("Helvetica", FontWeight.EXTRA_BOLD, 12);
        categoria = new Label("Ejecutivo");
        postre = new Label("Postres");
        bebida = new Label("Bebidas");
        segundo = new Label("Segundos");
        sopa = new Label("Sopas");
        segundo.setFont(theFont1);
        sopa.setFont(theFont1);
        postre.setFont(theFont1);
        bebida.setFont(theFont1);
        imgLoadFondo3 = new Image("/imagenes/fondo10.jpg");
        imgFondo3 = new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(600);
        imgFondo3.setFitWidth(1100);
        segundos = new ChoiceBox();
        segundos.setPrefWidth(5000);
        sopas = new ChoiceBox();
        sopas.setPrefWidth(5000);
        postres = new ChoiceBox();
        postres.setPrefWidth(5000);
        bebidas = new ChoiceBox();
        bebidas.setPrefWidth(5000);
        aceptar = new Button("Aceptar");
        aceptar.setAlignment(Pos.TOP_CENTER);
        llenarChoiceBox(listaPlatos);
        PanePlatosChoiceBox = new HBox(100, segundos, sopas, postres, bebidas);
        PanePlatosChoiceBox.setAlignment(Pos.CENTER);
        PaneBotonChoiceBox = new VBox(50, PanePlatosChoiceBox, aceptar);
        PaneBotonChoiceBox.setAlignment(Pos.CENTER);
        PanePlatosLabels=new HBox(235,segundo,sopa,postre,bebida);
        PanePlatosLabels.setAlignment(Pos.CENTER_LEFT);
        PaneObjetos = new VBox(1, titulo, categoria,PanePlatosLabels,PaneBotonChoiceBox);
        PaneObjetos.setAlignment(Pos.TOP_CENTER);
        PaneObjetos.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: yellow;");
        
       
        root3.getChildren().addAll(imgFondo3);
        root3.setCenter(PaneObjetos);
        eventoBotonAceptar();
    }

    // metodo que me obtiene el root1
    public BorderPane getRoot() {
        return root3;
    }

    public void llenarChoiceBox(ArrayList<Platos> listaPlatos) {
        for (int i = 0; i < listaPlatos.size(); i++) {
            switch (listaPlatos.get(i).getTipo()) {
                case "segundo":
                    segundos.getItems().add(listaPlatos.get(i).getNombre());
                    break;
                case "sopa":
                    sopas.getItems().add(listaPlatos.get(i).getNombre());
                    break;
                case "jugo":
                    bebidas.getItems().add(listaPlatos.get(i).getNombre());
                    break;
                default:
                    postres.getItems().add(listaPlatos.get(i).getNombre());
                    break;
            }
        }
    }

    public void eventoBotonAceptar() {
        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //AQUI SE PRESENTARA EL PANE ELEGIR HORA DE ALMUERZO
                PaneHoraDeRetiro horaRetiro=new PaneHoraDeRetiro(primaryStage);
                horaRetiro.listaPlatos(listaPlatos, primaryStage);
                horaRetiro.pantallaListaPlatos(primaryStage);
                
            }
        });
    }

    public void pantallaAlmuerzoEjecutivo(Stage primaryStage, ArrayList<Platos> listaPlatos) {
        PaneAlmuerzoEjecutivo root3 = new PaneAlmuerzoEjecutivo(primaryStage, listaPlatos);
        Scene scene = new Scene(root3.getRoot(), 1050, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
