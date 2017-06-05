package InicioDeSesión;




import InformacionPlatos.PaneInformacionPlatos;
import MenuBarAdministrador.PaneOrganizaAdministrador;
import MenuBarCliente.PaneOrganizeCliente;
import MenuBarAsistente.PaneOrganizaAsistente;
import Modelo.Persistencia;
import Modelo.Usuario;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
public class PaneInicioSesion {
    HashMap<String, Usuario> informUsuarios;
    HashMap<String, String> UserContra;
    
    public static BorderPane rootPrincipal;
    public static Stage primaryStage;
    private Button IngresarButton;
    private Button SalirButton;
    private Image imgLoadFondo;
    private ImageView imgFondo;
    private Image imgLoadLogin;
    private ImageView imgLogin;
    public static TextField ingresoUsuario;
    public static TextField ingresoContraseña;
    public PasswordField ingreso_Contraseña;
    public static Label UsuarioLabel;
    public static Label ContraseñaLabel;
    public static Label MensajeLabel;
    public static Label RolesLabel;
    
   //PARA PRESENTAR LISTA DE OPCIONES
//    ObservableList<String> tiposRoles;
//    ListView<String> listaRoles; 
    
    //Choice box for location 
    ChoiceBox TiposRolesBox = new ChoiceBox(); 

     
  
    public PaneInicioSesion(Stage primaryStage) {
        this.primaryStage=primaryStage;
        this.imgLoadFondo=new Image("/imagenes/ESPOL-2-GRIS.png");
        this.imgFondo=new ImageView(imgLoadFondo);
        this.imgFondo.setFitHeight(400);
        this.imgFondo.setFitWidth(300);
        this.imgLoadLogin=new Image("/imagenes/login.png");
        this.imgLogin=new ImageView(imgLoadLogin);
        this.imgLogin.setFitHeight(100);
        this.imgLogin.setFitWidth(100);
        this.rootPrincipal=new BorderPane();
        this.ingresoUsuario=new TextField();
        this.ingreso_Contraseña=new PasswordField();
        ingreso_Contraseña.setPromptText("Your password");
        this.ingresoContraseña=new TextField();
        this.UsuarioLabel=new Label("Usuario: ");
        this.ContraseñaLabel=new Label("Contraseña: ");
        this.MensajeLabel=new Label();
        this.RolesLabel=new Label("Rol: ");
        this.IngresarButton= new Button("Ingresar");
        this.SalirButton= new Button("Salir");
        this.rootPrincipal.getChildren().add(imgFondo);
        this.informUsuarios=Persistencia.leerUsuarios();
        this.UserContra=new HashMap<>();
        
        this.TiposRolesBox = new ChoiceBox();
        TiposRolesBox.getItems().addAll("Cliente","Asistente de Restaurante","Administrador");
        
        //Colocar titulo a la ventana y desactivar el boton de control de maximizar
        primaryStage.setTitle("INICIO DE SESION");
        primaryStage.setResizable(false);
        //PARA PRESENTAR UNA LISTA DE OPCIONES
//        this.tiposRoles = FXCollections.observableArrayList( 
//        "Cliente", "Asistente de Restaurante", "Administrador"); 
//        listaRoles = new ListView<String>(tiposRoles); 
        
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
                    if(TiposRolesBox.getValue().equals("Cliente")){
//                        pantallaInformacionPlatos(primaryStage);
                    
                        PaneOrganizeCliente.pantallaCliente(primaryStage);
                    }else if(TiposRolesBox.getValue().equals("Asistente de Restaurante")){
                        PaneOrganizaAsistente.pantallaAsistente(primaryStage);
                    }else{
                        PaneOrganizaAdministrador.pantallaAdministrador(primaryStage);    
                    }
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
        VBox root1 = new VBox(5,imgLogin,UsuarioLabel,ingresoUsuario,ContraseñaLabel,ingreso_Contraseña,RolesLabel,TiposRolesBox,MensajeLabel,buttonBox);
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
