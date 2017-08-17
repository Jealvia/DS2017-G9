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

import Modelo.Persistencia;
import SegundaParte.Platos;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

public class PaneOrganizeCliente {

    private Group root;
    private ArrayList<Platos> listaPlatos;

    public PaneOrganizeCliente() {
        this.root = new Group();
        this.listaPlatos = Persistencia.leerPlatos();
    }

    public void menuCliente(Stage primaryStage) {
        //Crear una instancia de MenuBar que contrendra los menus
        MenuBar menuBar = new MenuBar();
        //Objeto Menu que contiene uno o mas items, u otros menus para hacer submenus
        Menu menu = new Menu("Categorias de Platos");
        //Creando los items(menuItem) quu iran en el primer menu
        MenuItem opcion1 = new MenuItem("Seleccione categoría");
        //Si es estudiantil devuelve el arreglo solo estudiantil
        opcion1.setOnAction((ActionEvent event) -> {
            PaneCategorias_ListaPlatos tmp = new PaneCategorias_ListaPlatos();
            tmp.ListaCategorias(this.listaPlatos, primaryStage, "-");
            ArrayList<Object> list = new ArrayList<>();
            tmp.ConstruirPane(primaryStage, list);
        });
        menu.getItems().add(opcion1);
        //Agregando el objeto menu al menuBar
        menuBar.getMenus().add(menu);
        //Objeto Menu2
        Menu menu2 = new Menu("Buscar Platos");
        MenuItem opcion2 = new MenuItem("Lista Platos");
        //Se encarga de la busqueda 
        opcion2.setOnAction(new EventHandler<ActionEvent>() {
            PaneBusqueda busq = new PaneBusqueda(primaryStage, listaPlatos);

            @Override
            public void handle(ActionEvent event) {
                // PaneInformacionPlatos.pantallaInformacionPlatos(primaryStage);
                ArrayList<Object> list = new ArrayList<>();
                busq.ConstruirPane(primaryStage, list);
            }
        });
        menu2.getItems().add(opcion2);
        //Agregando el objeto menu2 al menuBar
        menuBar.getMenus().add(menu2);
        //Objeto Menu3
        Menu menu3 = new Menu("Pedidos de Almuerzos");
        MenuItem opcion3 = new MenuItem("Almuerzo");
        opcion3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PanaCategoria_CompraOnline compraOnline = new PanaCategoria_CompraOnline();
                compraOnline.listaCategoriaCompraOnline(primaryStage, listaPlatos);
                compraOnline.pantallaListaCategoriaCompraOnline(primaryStage);
//                  PaneFormasDePago pago=new PaneFormasDePago(primaryStage);
//                  pago.pantallaFormasDePago(primaryStage);
            }
        });
        menu3.getItems().add(opcion3);
        //Agregando el menu3 al menuBar
        menuBar.getMenus().add(menu3);
        //Objeto Menu4
        Menu menu4 = new Menu("Cerrar Sesion");
        MenuItem opcion4 = new MenuItem("Regresar a Login");
        opcion4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PaneInicioSesion root = new PaneInicioSesion(primaryStage);
                root.menuPrincipal(primaryStage);
                Scene scene = new Scene(root.getRoot(), 300, 400);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });
        menu4.getItems().add(opcion4);
        //Agregando el menu3 al menuBar
        menuBar.getMenus().add(menu4);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.getChildren().add(menuBar);
    }

    // metodo que me obtiene el root1
    public Group getRoot() {
        return root;
    }

    public static void pantallaCliente(Stage primaryStage) {
        PaneOrganizeCliente root4 = new PaneOrganizeCliente();
        Scene scene = new Scene(root4.getRoot(), 600, 250, Color.ORANGERED);
        primaryStage.setScene(scene);
        root4.menuCliente(primaryStage);
        primaryStage.show();
    }

}
