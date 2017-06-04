/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuBarCliente;

/**
 *
 * @author jimmy
 */

import InformacionPlatos.PaneInformacionPlatos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

public class PaneOrganizeCliente  {
    Group root;

    public PaneOrganizeCliente() {
        this.root = new Group();
    }
    
    public void menuCliente(Stage primaryStage){        
        //Crear una instancia de MenuBar que contrendra los menus
        MenuBar menuBar = new MenuBar();
        //Objeto Menu que contiene uno o mas items, u otros menus para hacer submenus
        Menu menu = new Menu("Categorias de Platos");
        //Creando los items(menuItem) quu iran en el primer menu
        MenuItem opcion1 =new MenuItem("Estudiantil");
        opcion1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.exit(0);
                  PaneInformacionPlatos.pantallaInformacionPlatos(primaryStage);
            }
        });
        menu.getItems().add(opcion1);
        
        //Separador
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Ejecutivo"));
        System.out.println("****"+menu.getText().intern());
        //Agregando el objeto menu al menuBar
        menuBar.getMenus().add(menu);
        //Objeto Menu2
        Menu menu2 = new Menu("Buscar Platos");
        //Agregando el objeto menu2 al menuBar
        menuBar.getMenus().add(menu2);
        //Objeto Menu3
        Menu menu3 = new Menu("Cerrar Sesion");
        menu3.setOnAction((event) -> {
            System.exit(0);
        });
        //Agregando el menu3 al menuBar
        menuBar.getMenus().add(menu3);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.getChildren().add(menuBar);
        
    }
     // metodo que me obtiene el root1
     public Group getRoot(){
        return root;
    }
    public static void pantallaCliente(Stage primaryStage){
        PaneOrganizeCliente root4=new PaneOrganizeCliente();       
        Scene scene=new Scene(root4.getRoot(),400,250,Color.ORANGERED);
        primaryStage.setScene(scene);
        root4.menuCliente(primaryStage);
        primaryStage.show();
    }

}
