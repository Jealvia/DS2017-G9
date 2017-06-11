/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformacionPlatos;

//CAMBIA
//2
import MenuBarAsistente.PaneOrganizaAsistente;
import MenuBarCliente.PaneOrganizeCliente;
import Modelo.Platos;
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
public class PaneInformacionPlatos {
    public static BorderPane root4;
    private Image imgLoadFondo4;
    private ImageView imgFondo4;
    private Image imgLoadPlatos4;
    private ImageView imgPlatos4;
    public  Label NombreLabel;
    public  Label RestauranteLabel;
    public  Label CategoriaLabel;
    public Label IngredienteLabel;
    public Label DescripcionLabel;
    public static   TextField NombreText;
    public static  TextField RestauranteText;
    public static  TextField CategoriaText;
    public static  TextField IngredientesText;
    public static TextField DescripcionText;
    public  Button RetornarButton;
    public  Button SalirButton;
    public  Button ModificarButton;

    
    
    
    public PaneInformacionPlatos(Stage primaryStage) {
        imgLoadFondo4=new Image("/imagenes/fondo4.jpg");
        imgFondo4=new ImageView(imgLoadFondo4);

        imgFondo4.setFitHeight(800);
        imgFondo4.setFitWidth(800);
        imgLoadPlatos4=new Image("/imagenes/pt1.jpg");
        imgPlatos4=new ImageView(imgLoadPlatos4);
        imgPlatos4.setFitHeight(200);
        imgPlatos4.setFitWidth(200);
        
        this.NombreText=new TextField();
        this.RestauranteText=new TextField();
        this.CategoriaText=new TextField();
        this.IngredientesText=new TextField();
        this.DescripcionText=new TextField();
        
        this.RetornarButton=new Button("Retornar");
        this.SalirButton=new Button("Salir");
       
        this.NombreLabel=new Label("Nombre: ");
        this.RestauranteLabel=new Label("Restaurante: ");
        this.CategoriaLabel=new Label("Categoria: ");
        this.IngredienteLabel=new Label("Ingredientes: ");
        this.DescripcionLabel=new Label("Descripcion: ");
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 15);
        
        RestauranteLabel.setTextFill(Color.rgb(21, 117, 84));
        CategoriaLabel.setTextFill(Color.rgb(21, 117, 84));
        IngredienteLabel.setTextFill(Color.rgb(21, 117, 84));
        DescripcionLabel.setTextFill(Color.rgb(21, 117, 84));
        NombreLabel.setTextFill(Color.rgb(21, 117, 84));
        
        NombreLabel.setFont(theFont);
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
    public void DiseñoVentanaPlatos(Stage primaryStage,HashMap<Integer,Platos> numPlt,Integer opcion){
        HBox PaneHorizontal=new HBox(20,imgPlatos4,RetornarButton);
        HBox PaneHorizontalBotones=new HBox(300,RetornarButton,SalirButton);
        PaneHorizontal.setAlignment(Pos.CENTER);
        PaneHorizontalBotones.setAlignment(Pos.CENTER);
        
        SalirButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("SALIO DEL SISTEMA");
                primaryStage.close();
                System.exit(0);//importante para poder salir del Output
            }
        });
        
        RetornarButton.setOnAction((ActionEvent event) -> {
            PaneOrganizeCliente root = new PaneOrganizeCliente();
            root.pantallaCliente(primaryStage);
//                
        });
        
        Iterator it = numPlt.keySet().iterator();
            while(it.hasNext()){
                Integer key = (Integer) it.next();
                if(key==opcion){
                    System.out.println("Clave: " + key + " -> Valor: " + numPlt.get(opcion).getNombre());
                    NombreText.setText(numPlt.get(opcion).getNombre());
                    IngredientesText.setText(numPlt.get(opcion).getIngredientes());
                    RestauranteText.setText(numPlt.get(opcion).getObjRestaurante().getNombre());
                    DescripcionText.setText(numPlt.get(opcion).getDescripcion());
                    CategoriaText.setText(numPlt.get(opcion).getCategoria().getNombre());
                    imgPlatos4.setImage(new Image("/imagenes/pt"+key+".jpg"));
                    //Para que no se pueda editar la informacion en los textfielts
                    NombreText.setEditable(false);
                    IngredientesText.setEditable(false);
                    RestauranteText.setEditable(false);
                    DescripcionText.setEditable(false);
                    CategoriaText.setEditable(false);
                }
            }
        VBox PaneOjetos=new VBox(5,NombreLabel,NombreText,RestauranteLabel,RestauranteText,CategoriaLabel,CategoriaText
        ,IngredienteLabel,IngredientesText,DescripcionLabel,PaneHorizontal,DescripcionText,PaneHorizontalBotones);
        PaneOjetos.setAlignment(Pos.CENTER_LEFT);
        PaneOjetos.setStyle("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: Orange;");       
        root4.setCenter(PaneOjetos);
    }
    public static void pantallaInformacionPlatosCliente(Stage primaryStage,HashMap<Integer,Platos> numPlt,Integer opcion){
        PaneInformacionPlatos root4=new PaneInformacionPlatos(primaryStage);       
        Scene scene=new Scene(root4.getRoot(),500,600);
        primaryStage.setScene(scene);
        root4.DiseñoVentanaPlatos(primaryStage,numPlt,opcion);
        primaryStage.show();
    }
  
}
