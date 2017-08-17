/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import SegundaParte.Platos;
import java.util.*;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Julio Alvia
 */
public class PaneListaPlatos {

    private static BorderPane contenedor;
    //PARA PRESENTAR LISTA DE OPCIONES
    static ObservableList<String> tiposPlatos;
    static ListView<String> listaPlatos;

    public PaneListaPlatos() {
        this.contenedor = new BorderPane();
    }

    public static BorderPane getContenedor() {
        return contenedor;
    }

    public static void setContenedor(BorderPane contenedor) {
        PaneListaPlatos.contenedor = contenedor;
    }

    public void listaPlatos(ArrayList<Platos> lista, Stage primaryStage) {
        ArrayList<String> lista1 = new ArrayList<>();
        HashMap<Integer, Platos> numPlt = new HashMap<Integer, Platos>();
        VBox vbox = new VBox(10);
        int cont = 0;
        for (Platos m : lista) {
            System.out.println(m.getNombre());
            HBox hbox = new HBox();
            System.out.println("Nombre: " + m.getNombre() + "\n" + "Restaurante: " + m.getNombreRestaurante());
            lista1.add("Nombre: " + m.getNombre() + "\n" + "Restaurante: " + m.getNombreRestaurante());
            numPlt.put(cont, m);
            cont++;
            vbox.getChildren().add(hbox);

        }
        //PARA PRESENTAR UNA LISTA DE OPCIONES
        PaneListaPlatos.tiposPlatos = FXCollections.observableArrayList(lista1);
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
            Integer opcion = listaPlatos.getSelectionModel().getSelectedIndex();
            PaneInformacionPlatos paneInfor = new PaneInformacionPlatos(primaryStage);
            ArrayList<Object> list = new ArrayList<>();
            list.add(numPlt);
            list.add(opcion);
            paneInfor.ConstruirPane(primaryStage, list);
        });

    }

    public void pantallaListaPlatos(Stage primaryStage) {
        Scene escena = new Scene(contenedor, 800, 400);
        primaryStage.setScene(escena);
        primaryStage.show();

    }

}
