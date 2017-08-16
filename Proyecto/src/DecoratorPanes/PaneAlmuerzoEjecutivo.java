package DecoratorPanes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import static MenuBarAsistente.PaneOrganizaAsistente.root2;
import static DecoratorPanes.PaneInformacionPlatos.CategoriaText;
import static DecoratorPanes.PaneInformacionPlatos.DescripcionText;
import static DecoratorPanes.PaneInformacionPlatos.IngredientesText;
import static DecoratorPanes.PaneInformacionPlatos.NombreText;
import static DecoratorPanes.PaneInformacionPlatos.RestauranteText;
import static DecoratorPanes.PaneInformacionPlatos.root4;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    public PaneAlmuerzoEjecutivo(Stage primaryStage) {
        primaryStage.setTitle("COMPRA ONLINE");
        primaryStage.setResizable(true);
        root3 = new BorderPane();
        titulo=new Label("COMPRA ONLINE");
        categoria=new Label("Ejecutivo");
        postre=new Label("Postre");
        bebida=new Label("Bebida");
        imgLoadFondo3 = new Image("/imagenes/fondo10.jpg");
        imgFondo3 = new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(600);
        imgFondo3.setFitWidth(800);
        segundos= new ChoiceBox();
        sopas= new ChoiceBox();
        postres= new ChoiceBox();
        bebidas= new ChoiceBox();
        aceptar=new Button("Aceptar");
       aceptar.setAlignment(Pos.TOP_CENTER);
        PanePlatosChoiceBox=new HBox(100,segundos,sopas,postres,bebidas);
        PanePlatosChoiceBox.setAlignment(Pos.CENTER);
        PaneBotonChoiceBox=new VBox(350,PanePlatosChoiceBox,aceptar);
        PaneBotonChoiceBox.setAlignment(Pos.CENTER);
        PaneObjetos=new VBox(50,titulo,categoria,PaneBotonChoiceBox);
        
        PaneObjetos.setAlignment(Pos.TOP_CENTER);
        PaneObjetos.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: Brown;");
        root3.getChildren().addAll(imgFondo3);
        root3.setCenter(PaneObjetos);
    }

    // metodo que me obtiene el root1
    public BorderPane getRoot() {
        return root3;
    }

    public  void pantallaAdministrador(Stage primaryStage) {
        PaneAlmuerzoEjecutivo root3 = new PaneAlmuerzoEjecutivo(primaryStage);
        Scene scene = new Scene(root3.getRoot(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
