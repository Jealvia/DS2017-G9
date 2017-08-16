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
import SegundaParte.Categoria;
import Modelo.Persistencia;
import SegundaParte.Platos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Julio Alvia
 */
public class PaneCategorias_ListaPlatos extends PaneInterfaceBase {
    private BorderPane contenedor;
    //PARA PRESENTAR LISTA DE OPCIONES
    static ObservableList<String> tiposPlatos;
    static ListView<String> listaPlatos;
    

   

    public PaneCategorias_ListaPlatos() {
        this.contenedor = new BorderPane();
    }

    public BorderPane getContenedor() {
        return contenedor;
    }

    public void setContenedor(BorderPane contenedor) {
        this.contenedor = contenedor;
    }

    public void ListaCategorias(ArrayList<Platos> lista, Stage primaryStage, String restaurante) {
        Set<Categoria> categoria = new HashSet<>();
        for (Platos m : lista) {
            categoria.add(m.getCategoria());
        }
        int tam = categoria.size();
        ArrayList<String> listacategorias = new ArrayList<>();
        Iterator<Categoria> it1 = categoria.iterator();
        while (it1.hasNext()) {
            Categoria temp = new Categoria();
            temp = it1.next();
            listacategorias.add(temp.getNombre());
        }
        VBox vbox = new VBox(10);
        //PARA PRESENTAR UNA LISTA DE OPCIONES
        tiposPlatos = FXCollections.observableArrayList(listacategorias);
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
            listapt = PaneCategorias_ListaPlatos.listaPresentar(opcion, restaurante);
            PaneListaPlatos lp = new PaneListaPlatos();
            lp.listaPlatos(listapt,primaryStage);
            lp.pantallaListaPlatos(primaryStage);
        });
        
    }
    public static ArrayList<Platos> listaPresentar(String categorias, String restaurante) {
        ArrayList<Platos> listPlatos = Persistencia.leerPlatos();
        ArrayList<Platos> lista = new ArrayList<>();
        if ("-".equals(restaurante)) {
            for (int i=0;i<listPlatos.size();i++) {
                if (listPlatos.get(i).getCategoria().getNombre().equals(categorias)) {
                    lista.add(listPlatos.get(i));
                }
            }
        } else {
            for (int i=0;i<listPlatos.size();i++) {
                if (listPlatos.get(i).getCategoria().getNombre().equals(categorias) && listPlatos.get(i).getNombreRestaurante().equals(restaurante)) {
                    lista.add(listPlatos.get(i));
                }
            }
        }
        return lista;
    }
    @Override
    public void ConstruirPane(Stage primaryStage, ArrayList<Object> lista) {
        Scene escena = new Scene(contenedor, 800, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
