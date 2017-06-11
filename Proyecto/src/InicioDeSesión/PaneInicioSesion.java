package InicioDeSesión;
<<<<<<< HEAD
import MenuBarAdministrador.PaneOrganizaAdministrador;
=======




>>>>>>> master
import MenuBarCliente.PaneOrganizeCliente;
import MenuBarAsistente.PaneOrganizaAsistente;
import Modelo.Persistencia;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class PaneInicioSesion<E> {

    private HashMap<String, Usuario> informUsuarios;
    private ArrayList<Usuario> UserContra;
    private  BorderPane rootPrincipal;
    private  Stage primaryStage;
    private Button IngresarButton;
    private Button SalirButton;
    private Image imgLoadFondo;
    private ImageView imgFondo;
    private Image imgLoadLogin;
    private ImageView imgLogin;
    private Persistencia pers;
    private TextField ingresoUsuario;
    private PasswordField ingreso_Contraseña;
    private  Label UsuarioLabel;
    private  Label ContraseñaLabel;
    private  Label MensajeLabel;
    private  Label RolesLabel; 
    //Choice box for location 
    private ChoiceBox TiposRolesBox ;
    

    public PaneInicioSesion(Stage primaryStage) {
        this.TiposRolesBox = new ChoiceBox();
        this.imgLoadFondo = new Image("/imagenes/ESPOL-2-GRIS.png");
        this.imgFondo = new ImageView(imgLoadFondo);
        this.imgFondo.setFitHeight(400);
        this.imgFondo.setFitWidth(300);
        this.imgLoadLogin = new Image("/imagenes/login.png");
        this.imgLogin = new ImageView(imgLoadLogin);
        this.imgLogin.setFitHeight(100);
        this.imgLogin.setFitWidth(100);
        this.rootPrincipal = new BorderPane();
        this.ingresoUsuario = new TextField("Ingresar Usuario");
       
        this.ingreso_Contraseña = new PasswordField();
        this.ingreso_Contraseña.setPromptText("Your password");
        this.UsuarioLabel = new Label("Usuario: ");
        this.ContraseñaLabel = new Label("Contraseña: ");
        this.MensajeLabel = new Label();
        this.RolesLabel = new Label("Rol: ");
        this.IngresarButton = new Button("Ingresar");
        this.SalirButton = new Button("Salir");
        this.rootPrincipal.getChildren().add(imgFondo);
        this.informUsuarios = Persistencia.leerUsuarios();
        this.UserContra = new ArrayList<>();
        this.TiposRolesBox = new ChoiceBox();
        this.TiposRolesBox.getItems().addAll("Cliente", "Asistente de Restaurante", "Administrador");
        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("INICIO DE SESION");
        primaryStage.setResizable(false);
    }

 
    public  BorderPane getRoot() {
        return rootPrincipal;
    }

    
    
    public  void menuPrincipal(Stage primaryStage) {
        
        IngresarButton.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                
                for (Map.Entry<String, Usuario> entry : informUsuarios.entrySet()) {
                    System.out.println("Asistente");
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue().getNombre());
                    System.out.println(entry.getValue().getNombreRestaurante());
                    String a=(String) TiposRolesBox.getValue();
                    //ESTA VALIDACION DEBE MEJORAR PORQUE CUALQUIER USUARIO PUEDE ENTRAR COMO ASISTENTE O ADMINITRADOR
                    if (entry.getKey().equals(ingresoUsuario.getText()) && entry.getValue().getContraseña().equals(ingreso_Contraseña.getText()) && (a.equals(entry.getValue().getRol()) && "Cliente".equals(entry.getValue().getRol()))) {
                        MensajeLabel.setText("Your password has been confirmed!");
                        MensajeLabel.setTextFill(Color.rgb(21, 117, 84));
                        System.out.println("INGRESO AL SISTEMA");
                        
<<<<<<< HEAD
                        PaneOrganizeCliente poc=new PaneOrganizeCliente();
                        poc.pantallaCliente(primaryStage,ingresoUsuario.getText());

=======
                        PaneOrganizeCliente.pantallaCliente(primaryStage);
>>>>>>> master
                    } 
                    else if(entry.getKey().equals(ingresoUsuario.getText()) && entry.getValue().getContraseña().equals(ingreso_Contraseña.getText()) && (a.equals(entry.getValue().getRol()) && "Asistente de Restaurante".equals(entry.getValue().getRol()))) {
                        MensajeLabel.setText("Your password has been confirmed!");
                        MensajeLabel.setTextFill(Color.rgb(21, 117, 84));
                        System.out.println("Asistente");
<<<<<<< HEAD
                        PaneOrganizaAsistente poa=new PaneOrganizaAsistente();
                        poa.pantallaAsistente(primaryStage,entry.getValue().getRest().getNombre(),ingresoUsuario.getText());
=======
                        System.out.println(entry.getValue().getRest().getNombre());
                        
                        PaneOrganizaAsistente.pantallaAsistente(primaryStage,entry.getValue().getRest().getNombre());
>>>>>>> master

                    }
                    else {
                        MensajeLabel.setText("Your password is incorrect!");
                        MensajeLabel.setTextFill(Color.rgb(210, 39, 30));
                        System.out.println("ERROR DE IDENTIFICACION");
                    }
                }
            }
        });
        SalirButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("SALIO DEL SISTEMA");
                primaryStage.close();
                System.exit(0);//importante para poder salir del Output
            }
        });
        // Create the ButtonBox		
        HBox buttonBox = new HBox(10, IngresarButton, SalirButton);
        buttonBox.setAlignment(Pos.CENTER);
        // Create the VBox
        VBox root1 = new VBox(5, imgLogin, UsuarioLabel, ingresoUsuario, ContraseñaLabel, ingreso_Contraseña, RolesLabel, TiposRolesBox, MensajeLabel, buttonBox);
        // Set the Style-properties of the VBox
        root1.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: Blue;");
        // Add the scene to the Stage
        
        rootPrincipal.setCenter(root1);
    }

}
