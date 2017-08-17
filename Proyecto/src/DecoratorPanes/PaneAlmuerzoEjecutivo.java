package DecoratorPanes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AlmuerzoBuilder.EjecutivoBuilder;
import AlmuerzoBuilder.IPrecio;
import AlmuerzoBuilder.LunchDirector;
import AlmuerzoBuilder.PostrePrecio;
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
  
    public PaneAlmuerzoEjecutivo(Stage primaryStage,ArrayList<Platos> listaPlatos) {
        primaryStage.setTitle("COMPRA ONLINE");
        primaryStage.setResizable(false);
        root3 = new BorderPane();
        titulo=new Label("COMPRA ONLINE");
        categoria=new Label("Ejecutivo");
        postre=new Label("Postres");
        bebida=new Label("Bebidas");
        segundo=new Label("Sgundos");
        sopa=new Label("Sopas");
        imgLoadFondo3 = new Image("/imagenes/fondo10.jpg");
        imgFondo3 = new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(600);
        imgFondo3.setFitWidth(1100);
        segundos= new ChoiceBox();
        segundos.setPrefWidth(5000);
        sopas= new ChoiceBox();
        sopas.setPrefWidth(5000);
        postres= new ChoiceBox();
        postres.setPrefWidth(5000);
        bebidas= new ChoiceBox();
        bebidas.setPrefWidth(5000);
        aceptar=new Button("Aceptar");
        aceptar.setAlignment(Pos.TOP_CENTER);
        llenarChoiceBox(listaPlatos);
        PanePlatosChoiceBox=new HBox(100,segundos,sopas,postres,bebidas);
        PanePlatosChoiceBox.setAlignment(Pos.CENTER);
        PaneBotonChoiceBox=new VBox(100,PanePlatosChoiceBox,aceptar);
        PaneBotonChoiceBox.setAlignment(Pos.CENTER);
        PaneObjetos=new VBox(50,titulo,categoria,PaneBotonChoiceBox);
        PaneObjetos.setAlignment(Pos.TOP_CENTER);
        PaneObjetos.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: yellow;");
        root3.getChildren().addAll(imgFondo3);
        root3.setCenter(PaneObjetos);
    }

    // metodo que me obtiene el root1
    public BorderPane getRoot() {
        return root3;
    }
    public void llenarChoiceBox(ArrayList<Platos> listaPlatos){
        for(int i=0;i<listaPlatos.size();i++){
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
    public void eventoBotonAceptar(){
        aceptar.setOnAction(new EventHandler<ActionEvent>(){   
            @Override
            public void handle(ActionEvent event) {
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
