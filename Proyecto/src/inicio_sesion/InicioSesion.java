package inicio_sesion;

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
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class InicioSesion {
    
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

    public InicioSesion(Stage primaryStage) {
        this.primaryStage=primaryStage;
        this.imgLoadFondo=new Image("/imagenes/ESPOL-2-GRIS.png");
        this.imgFondo=new ImageView(imgLoadFondo);
        this.imgFondo.setFitHeight(300);
        this.imgFondo.setFitWidth(500);
        this.rootPrincipal=new BorderPane();
        this.ingresoUsuario=new TextField();
        this.ingreso_Contraseña=new PasswordField();
        this.ingresoContraseña=new TextField();
        this.UsuarioLabel=new Label("Usuario: ");
        this.ContraseñaLabel=new Label("Contraseña: ");
        this.IngresarButton= new Button("Ingresar");
        this.SalirButton= new Button("Salir");
        this.rootPrincipal.getChildren().add(imgFondo);
    }
    public static BorderPane getRoot(){
        return rootPrincipal;
    }
    public void menuPrincipal(Stage primaryStage){
        IngresarButton.setOnAction(new EventHandler <ActionEvent>(){
            public void handle(ActionEvent event) 
            {
                if(ingreso_Contraseña.getText().equals("Jacelly@espol.edu.ec")){
                    System.out.println("INGRESO AL SISTEMA");
                }else{
                    System.out.println("ERROR DE IDENTIFICACION");
                }
                primaryStage.close();
                System.exit(0);//importante para poder salir del Output
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
        VBox root1 = new VBox(5,UsuarioLabel,ingresoUsuario,ContraseñaLabel,ingreso_Contraseña,buttonBox);
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
