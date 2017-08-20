package DecoratorPanes;

import Modelo.Persistencia;
import SegundaParte.Usuario;
import java.util.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneInicioSesion<E> {

    HashMap<String, Usuario> informUsuarios;
    ArrayList<Usuario> UserContra;
    public static BorderPane rootPrincipal;
    public static Stage primaryStage;
    private Button IngresarButton;
    private Button SalirButton;
    private Image imgLoadFondo;
    private ImageView imgFondo;
    private Image imgLoadLogin;
    private ImageView imgLogin;
    private Persistencia pers;
    public static TextField ingresoUsuario;
    public PasswordField ingreso_Contraseña;
    public static Label UsuarioLabel;
    public static Label ContraseñaLabel;
    public static Label MensajeLabel;
    public static Label RolesLabel;
    //Choice box for location 
    ChoiceBox TiposRolesBox = new ChoiceBox();

    public PaneInicioSesion(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.imgLoadFondo = new Image("/imagenes/ESPOL-2-GRIS.png");
        this.imgFondo = new ImageView(imgLoadFondo);
        this.imgFondo.setFitHeight(400);
        this.imgFondo.setFitWidth(300);
        this.imgLoadLogin = new Image("/imagenes/login.png");
        this.imgLogin = new ImageView(imgLoadLogin);
        this.imgLogin.setFitHeight(100);
        this.imgLogin.setFitWidth(100);
        this.rootPrincipal = new BorderPane();
        this.ingresoUsuario = new TextField();
        this.ingreso_Contraseña = new PasswordField();
        ingreso_Contraseña.setPromptText("Your password");
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
        TiposRolesBox.getItems().addAll("Cliente", "Asistente", "Administrador");
        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("INICIO DE SESION");
        primaryStage.setResizable(false);
    }

    public static BorderPane getRoot() {
        return rootPrincipal;
    }

    public void menuPrincipal(Stage primaryStage) {
        IngresarButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                for (Map.Entry<String, Usuario> entry : informUsuarios.entrySet()) {
                    String a = (String) TiposRolesBox.getValue();
                    if (entry.getKey().equals(ingresoUsuario.getText()) && entry.getValue().getContraseña().equals(ingreso_Contraseña.getText()) && (a.equals(entry.getValue().getRol()) && "Cliente".equals(entry.getValue().getRol()))) {
                        MensajeLabel.setText("Your password has been confirmed!");
                        MensajeLabel.setTextFill(Color.rgb(21, 117, 84));
                        System.out.println("INGRESO AL SISTEMA");
                        PaneOrganizeCliente.pantallaCliente(primaryStage);
                    } else if (entry.getKey().equals(ingresoUsuario.getText()) && entry.getValue().getContraseña().equals(ingreso_Contraseña.getText()) && (a.equals(entry.getValue().getRol()) && "Asistente".equals(entry.getValue().getRol()))) {
                        MensajeLabel.setText("Your password has been confirmed!");
                        MensajeLabel.setTextFill(Color.rgb(21, 117, 84));
                        PaneOrganizeAsistente.pantallaAsistente(primaryStage, entry.getValue().getRest());

                    } else {
                        MensajeLabel.setText("Identification Error!");
                        MensajeLabel.setTextFill(Color.rgb(210, 39, 30));
                    }

                }

            }
        });
        SalirButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();
                System.exit(0);//importante para poder salir del Output8
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
