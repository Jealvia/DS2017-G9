/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

/**
 *
 * @author jimmy
 */
//CAMBIA
//2
import DecoratorPanes.Busqueda;
import DecoratorPanes.ListaCategorias;
import DecoratorPanes.ListaPlatos;
import DecoratorPanes.PaneInicioSesion;
import Modelo.Persistencia;
import Modelo.Platos;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class PaneOrganizeCliente {

    Group root;
    ArrayList<Platos> lista;
    HashMap<String, Platos> categoriaPlato;
    Stage primaryStage;

    public PaneOrganizeCliente() {
        this.primaryStage = primaryStage;
        this.root = new Group();
        this.lista = new ArrayList<Platos>();
        this.categoriaPlato = Persistencia.leerPlatos();

    }

    public void menuCliente(Stage primaryStage, String id) {
        
        //Crear una instancia de MenuBar que contrendra los menus
        MenuBar menuBar = new MenuBar();
        //Objeto Menu que contiene uno o mas items, u otros menus para hacer submenus
        Menu menu = new Menu("Categorias de Platos");
        //Creando los items(menuItem) quu iran en el primer menu
        MenuItem opcion1 = new MenuItem("Seleccione categoría");
        System.out.println("**" + categoriaPlato.size());
        for (Platos values : categoriaPlato.values()) {
            lista.add(values);
        }

        //Si es estudiantil devuelve el arreglo solo estudiantil
        opcion1.setOnAction((ActionEvent event) -> {
            //System.exit(0);
            ListaCategorias tmp = new ListaCategorias();
            tmp.ListaCategorias(this.lista, primaryStage, "-", id);
            tmp.pantallaListaCategoria(primaryStage);

        });
        menu.getItems().add(opcion1);

        //Agregando el objeto menu al menuBar
        menuBar.getMenus().add(menu);

        //Objeto Menu2
        Menu menu2 = new Menu("Buscar Platos");
        MenuItem opcion2 = new MenuItem("Lista Platos");

        //Se encarga de la busqueda 
        opcion2.setOnAction(new EventHandler<ActionEvent>() {
            Busqueda busq = new Busqueda(categoriaPlato, primaryStage, id);

            @Override
            public void handle(ActionEvent event) {
                // PaneInformacionPlatos.pantallaInformacionPlatos(primaryStage);
                busq.pantallaBusquedad(primaryStage);
            }
        });
        menu2.getItems().add(opcion2);
        //Agregando el objeto menu2 al menuBar
        menuBar.getMenus().add(menu2);
        //Objeto Menu3
        Menu menu3 = new Menu("Cerrar Sesion");
        MenuItem opcion3 = new MenuItem("Regresar a Login");

        opcion3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                PaneInicioSesion root = new PaneInicioSesion(primaryStage);
                root.menuPrincipal(primaryStage);
                Scene scene = new Scene(root.getRoot(), 300, 400);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });
        menu3.getItems().add(opcion3);
        //Agregando el menu3 al menuBar
        menuBar.getMenus().add(menu3);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.getChildren().add(menuBar);

    }
    // metodo que me obtiene el root1

    public Group getRoot() {
        return root;
    }

    public static void pantallaCliente(Stage primaryStage, String id) {
        PaneOrganizeCliente root4 = new PaneOrganizeCliente();
        Scene scene = new Scene(root4.getRoot(), 400, 250, Color.ORANGERED);
        primaryStage.setScene(scene);
        root4.menuCliente(primaryStage, id);
        primaryStage.show();
    }

}
