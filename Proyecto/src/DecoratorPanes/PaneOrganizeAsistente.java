/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import Modelo.Persistencia;
import SegundaParte.Platos;
import java.util.ArrayList;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneOrganizeAsistente {

    private Group root;
    private ArrayList<Platos> lista;
    private ArrayList<Platos> listaPlatos;

    public PaneOrganizeAsistente() {
        this.root = new Group();
        this.lista = new ArrayList<Platos>();
        this.listaPlatos = Persistencia.leerPlatos();

    }
    // metodo que me obtiene el root1

    public void menuAsistente(Stage primaryStage, String restaurante) {
        //Crear una instancia de MenuBar que contrendra los menus
        MenuBar menuBar = new MenuBar();
        //Objeto Menu que contiene uno o mas items, u otros menus para hacer submenus
        Menu menu = new Menu("Agregar Platillo");
        //Creando los items(menuItem) quu iran en el primer menu
        MenuItem opcion1 = new MenuItem("Nuevo Platillo");

        //Si es estudiantil devuelve el arreglo solo estudiantil
        opcion1.setOnAction((ActionEvent event) -> {
            //Karol aqui te toca modificar
            PaneAgregarPlatillo pap = new PaneAgregarPlatillo(primaryStage);
            for (int i = 0; i < listaPlatos.size(); i++) {
                if (restaurante.equals(listaPlatos.get(i).getNombreRestaurante())) {
//                    pap.pantallaAgregarPlatosAsistente(primaryStage, values.getObjRestaurante());
                    ArrayList<Object> list = new ArrayList<>();
                    list.add(listaPlatos.get(i).getNombreRestaurante());
                    pap.ConstruirPane(primaryStage, list);
                }
            }

        });
        menu.getItems().add(opcion1);

        //Separador
        menu.getItems().add(new SeparatorMenuItem());

        //Agregando el objeto menu al menuBar
        menuBar.getMenus().add(menu);
        //Objeto Menu2
        Menu menu2 = new Menu("Lista de platos");
        MenuItem opcion2 = new MenuItem("Lista del restaurante");
        //Mostrar lista de platos del restaurante
        opcion2.setOnAction((ActionEvent event) -> {
            for (int i = 0; i < listaPlatos.size(); i++) {
                if (restaurante.equals(listaPlatos.get(i).getNombreRestaurante())) {
                    lista.add(listaPlatos.get(i));
                }
            }
            PaneListaPlatos lp = new PaneListaPlatos();
            lp.listaPlatos(lista, primaryStage);
            lp.pantallaListaPlatos(primaryStage);

        });
        menu2.getItems().add(opcion2);
        //Agregando el objeto menu2 al menuBar
        menuBar.getMenus().add(menu2);
        //Agrega menu lista por categoria
        Menu menucat = new Menu("Categorias de Platos");
        MenuItem opciones = new MenuItem("Seleccione categoría");
        opciones.setOnAction((ActionEvent event) -> {
            ArrayList<Platos> listplatos = new ArrayList<>();
            for (int i = 0; i < listaPlatos.size(); i++) {
                if (listaPlatos.get(i).getNombreRestaurante().equals(restaurante)) {
                    System.out.println(listaPlatos.get(i).getNombreRestaurante());
                    System.out.println(restaurante);
                    listplatos.add(listaPlatos.get(i));
                }
            }
            PaneCategorias_ListaPlatos tmp = new PaneCategorias_ListaPlatos();
            tmp.ListaCategorias(listplatos, primaryStage, restaurante);
            ArrayList<Object> list = new ArrayList<>();
            tmp.ConstruirPane(primaryStage, list);

        });
        menucat.getItems().add(opciones);
        menuBar.getMenus().add(menucat);
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

    public Group getRoot() {
        return root;
    }

    public static void pantallaAsistente(Stage primaryStage, String restaurante) {
        PaneOrganizeAsistente root4 = new PaneOrganizeAsistente();
        Scene scene = new Scene(root4.getRoot(), 500, 200, Color.CADETBLUE);
        primaryStage.setScene(scene);
        root4.menuAsistente(primaryStage, restaurante);
        primaryStage.show();
    }

}
