/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

/**
 *
 * @author Julio Alvia
 */
import DecoratorPanes.Categoria;
import Modelo.Persistencia;
import Modelo.Platos;
import static java.awt.PageAttributes.MediaType.E;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import static javafx.scene.input.KeyCode.E;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Julio Alvia
 */
public class ListaCategorias extends PaneInterfaceBase {
    private BorderPane contenedor;
    //PARA PRESENTAR LISTA DE OPCIONES
    static ObservableList<String> tiposPlatos;
    static ListView<String> listaPlatos;
    public HashMap<String, Platos> categoriaPlato;

   

    public ListaCategorias() {
        this.contenedor = new BorderPane();
    }

    public BorderPane getContenedor() {
        return contenedor;
    }

    public void setContenedor(BorderPane contenedor) {
        this.contenedor = contenedor;
    }

    public void ListaCategorias(ArrayList<Platos> lista, Stage primaryStage, String restaurante) {
        Set<Categoria> catego = new HashSet<>();
        for (Platos m : lista) {
            catego.add(m.getCategoria());
        }
        int tam = catego.size();
        ArrayList<String> listacategorias = new ArrayList<>();
        Iterator<Categoria> it1 = catego.iterator();
        while (it1.hasNext()) {
            Categoria temp = new Categoria();
            temp = it1.next();
            listacategorias.add(temp.getNombre());
        }
        VBox vbox = new VBox(10);
        //PARA PRESENTAR UNA LISTA DE OPCIONES
        ListaCategorias.tiposPlatos = FXCollections.observableArrayList(listacategorias);
        listaPlatos = new ListView<String>(tiposPlatos);
        listaPlatos.setPrefSize(50, 100);
        vbox.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: DARKCYAN;");
        vbox.getChildren().add(listaPlatos);
        contenedor.setCenter(vbox);

        listaPlatos.setOnMouseClicked((MouseEvent me) -> {
            String opcion = listaPlatos.getSelectionModel().getSelectedItem();
            ArrayList<Platos> listapt = new ArrayList<>();
            listapt = ListaCategorias.listaPresentar(opcion, restaurante);
            ListaPlatos lp = new ListaPlatos();
            lp.listaPlatos(listapt,primaryStage);
            lp.pantallaListaPlatos(primaryStage);
        });
        
    }
    public static ArrayList<Platos> listaPresentar(String categorias, String restaurante) {
        HashMap<String, Platos> categoriaPlato = new HashMap<>();
        categoriaPlato = Persistencia.leerPlatos();
        ArrayList<Platos> lista = new ArrayList<>();
        if ("-".equals(restaurante)) {
            for (Platos plato : categoriaPlato.values()) {
                if (plato.getCategoria().getNombre().equals(categorias)) {
                    lista.add(plato);
                }
            }
        } else {
            for (Platos plato : categoriaPlato.values()) {
                if (plato.getCategoria().getNombre().equals(categorias) && plato.getRestaurante().getNombre().equals(restaurante)) {
                    lista.add(plato);
                }
            }
        }
        return lista;
    }
    //Muestra una ventana con las categotias pertenecientes al administrador
//    public void pantallaListaCategoria(Stage primaryStage) {
//        Scene escena = new Scene(contenedor, 800, 400);
//        primaryStage.setScene(escena);
//        primaryStage.show();
//    }
    @Override
    public void ConstruirPane(Stage primaryStage, ArrayList<Object> lista) {
        Scene escena = new Scene(contenedor, 800, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }



  

 

  

        


}
