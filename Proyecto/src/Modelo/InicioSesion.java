package Modelo;


import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class InicioSesion {
    HashMap<String, Usuario> informUsuarios;
    HashMap<String, String> UserContra;
    
    public static BorderPane rootPrincipal;
    public static Stage primaryStage;
    private Button IngresarButton;
    private Button SalirButton;
    private Image imgLoadFondo;
    private ImageView imgFondo;
    public static TextField ingresoUsuario;
    public static TextField ingresoContraseña;
    public PasswordField ingreso_Contraseña;
    public static Label UsuarioLabel;
    public static Label ContraseñaLabel;
    public static Label MensajeLabel;
  
    public InicioSesion(Stage primaryStage) {
        this.primaryStage=primaryStage;
        this.imgLoadFondo=new Image("/imagenes/ESPOL-2-GRIS.png");
        this.imgFondo=new ImageView(imgLoadFondo);
        this.imgFondo.setFitHeight(300);
        this.imgFondo.setFitWidth(500);
        this.rootPrincipal=new BorderPane();
        this.ingresoUsuario=new TextField();
        this.ingreso_Contraseña=new PasswordField();
        ingreso_Contraseña.setPromptText("Your password");
        this.ingresoContraseña=new TextField();
        this.UsuarioLabel=new Label("Usuario: ");
        this.ContraseñaLabel=new Label("Contraseña: ");
        this.MensajeLabel=new Label();
        this.IngresarButton= new Button("Ingresar");
        this.SalirButton= new Button("Salir");
        this.rootPrincipal.getChildren().add(imgFondo);
        this.informUsuarios=Persistencia.leerUsuarios();
        this.UserContra=new HashMap<>();
        
    }
    public static BorderPane getRoot(){
        return rootPrincipal;
    }
    public void menuPrincipal(Stage primaryStage){
        IngresarButton.setOnAction(new EventHandler <ActionEvent>(){
            public void handle(ActionEvent event) 
            {
                for (Usuario values : informUsuarios.values()) {
                    UserContra.put(values.getId(), values.getContraseña()); 
                 }            
                if(UserContra.containsKey(ingresoUsuario.getText()) && UserContra.containsValue(ingreso_Contraseña.getText())){
                    MensajeLabel.setText("Your password has been confirmed!");
                    MensajeLabel.setTextFill(Color.rgb(21, 117, 84));
                    System.out.println("INGRESO AL SISTEMA");
                }else{
                    MensajeLabel.setText("Your password is incorrect!");
                    MensajeLabel.setTextFill(Color.rgb(210, 39, 30));
                    System.out.println("ERROR DE IDENTIFICACION");
                }
//                primaryStage.close();
//                System.exit(0);//importante para poder salir del Output
            }
        });
        SalirButton.setOnAction(new EventHandler <ActionEvent>(){
            public void handle(ActionEvent event) 
            {
                System.out.println("SALIO DEL SISTEMA");
                primaryStage.close();
                System.exit(0);//importante para poder salir del Output
            }
        });
        // Create the ButtonBox		
        HBox buttonBox = new HBox(10,IngresarButton,SalirButton);
        buttonBox.setAlignment(Pos.CENTER);
        // Create the VBox
        VBox root1 = new VBox(5,UsuarioLabel,ingresoUsuario,ContraseñaLabel,ingreso_Contraseña,MensajeLabel,buttonBox);
        // Set the Style-properties of the VBox
        root1.setStyle("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: Blue;"); 
        // Add the scene to the Stage
        rootPrincipal.setCenter(root1);
    }
    
}
