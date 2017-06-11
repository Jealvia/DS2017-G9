/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformacionPlatos;
<<<<<<< HEAD

import InicioDeSesión.PaneInicioSesion;
import MenuBarAsistente.PaneOrganizaAsistente;
import MenuBarCliente.PaneOrganizeCliente;
import Modelo.Persistencia;
=======
//cambia
//2
>>>>>>> master
import Modelo.Platos;
import Modelo.Usuario;
import com.sun.pisces.PiscesRenderer;
import java.util.ArrayList;
import java.util.HashMap;
<<<<<<< HEAD
import java.util.Iterator;
import java.util.Map;
=======
>>>>>>> master
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Julio Alvia
 */
public class ListaPlatos {

    Label nombre;
    static VBox vbox;
    HBox hbox;
    private Stage primaryStage;
    static BorderPane contenedor;
    static ArrayList<String> list;
    //PARA PRESENTAR LISTA DE OPCIONES
    static ObservableList<String> tiposPlatos;
    static ListView<String> listaPlatos;
<<<<<<< HEAD
    Button retornarButton;
    HashMap<String, Usuario> informUsuarios;
    
=======
    HashMap<String, Platos> categoriaPlato;    
    
    public static void mostrarListaPltaos(ArrayList<Platos> lista, Stage primaryStage) {
        for (Platos m : lista) {
            System.out.println("**" + m.getNombre());
            Label nombre = new Label("Nombre: " + m.getNombre() + "\n" + "Restaurante: " + m.getObjRestaurante().getNombre());
            list.add("Nombre: " + m.getNombre() + "\n" + "Restaurante: " + m.getObjRestaurante().getNombre());
            vbox.getChildren().add(nombre);
            vbox.setAlignment(Pos.CENTER);
        }
    }
>>>>>>> master

    public ListaPlatos() {
        this.contenedor=new BorderPane();
        this.retornarButton=new Button("Retornar");
        this.informUsuarios = Persistencia.leerUsuarios();
    }
    public static BorderPane getContenedor() {
        return contenedor;
    }

    public static void setContenedor(BorderPane contenedor) {
        ListaPlatos.contenedor = contenedor;
    }
   
    public void ventanaListaPlatos(ArrayList<Platos> lista, Stage primaryStage,String id){
        ArrayList<String> lista1=new ArrayList<>();
        HashMap<Integer,Platos> numPlt=new HashMap<Integer,Platos>();
        VBox vbox = new VBox(10);
        int cont=0;
        retornarButton.setOnAction(new EventHandler<ActionEvent>() {      
            public void handle(ActionEvent event) {
                System.out.println(id);
                for (Map.Entry<String, Usuario> entry : informUsuarios.entrySet()) {
                    
                    if(entry.getValue().getRol().equals("Cliente")&& id.equals(entry.getKey())){
                        PaneOrganizeCliente root2 = new PaneOrganizeCliente();
                        root2.pantallaCliente(primaryStage,id);
                    }else if (entry.getValue().getRol().equals("Asistente de Restaurante")&& id.equals(entry.getKey())){
                        PaneOrganizaAsistente root1 =new PaneOrganizaAsistente();
                        root1.pantallaAsistente(primaryStage,entry.getValue().getRest().getNombre(),id);
                    }
                    
                }
               
            }
        });
        for (Platos m : lista) {
            System.out.println(m.getNombre());
            HBox hbox = new HBox();
            System.out.println("Nombre: " + m.getNombre() + "\n" + "Restaurante: " + m.getObjRestaurante().getNombre());
            lista1.add("Nombre: " + m.getNombre() + "\n" + "Restaurante: " + m.getObjRestaurante().getNombre());
            numPlt.put(cont, m);
            cont++;
            
            vbox.getChildren().add(hbox);
           
        }

        //PARA PRESENTAR UNA LISTA DE OPCIONES
        ListaPlatos.tiposPlatos = FXCollections.observableArrayList(lista1);
        listaPlatos = new ListView<String>(tiposPlatos);
        listaPlatos.setPrefSize(50, 100);
        vbox.setStyle("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: DARKCYAN;");
        vbox.getChildren().addAll(listaPlatos,retornarButton);
        contenedor.setCenter(vbox);
        listaPlatos.setOnMouseClicked((MouseEvent me) -> {
            Integer opcion=listaPlatos.getSelectionModel().getSelectedIndex();
            PaneInformacionPlatos.pantallaInformacionPlatosCliente(primaryStage,numPlt,opcion,id); 
        });
        Scene escena = new Scene(contenedor,800,400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    

  

}
