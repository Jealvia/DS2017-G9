/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import SegundaParte.Categoria;
import SegundaParte.Platos;
import java.util.*;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PanaCategoria_CompraOnline {

    //PARA PRESENTAR LISTA DE OPCIONES
    private static ObservableList<String> categoriaPlato;
    private static ListView<String> listaPlatos;
    private BorderPane contenedor;

    public PanaCategoria_CompraOnline() {
        this.contenedor = new BorderPane();
    }

    public void listaCategoriaCompraOnline(Stage primaryStage, ArrayList<Platos> lista){
        primaryStage.setTitle("ELEGIR CATEGORIA");
        primaryStage.setResizable(false);
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
        categoriaPlato = FXCollections.observableArrayList(listacategorias);
        listaPlatos = new ListView<String>(categoriaPlato);
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
            if ("ejecutivo".equals(listaPlatos.getSelectionModel().getSelectedItem())) {
                PaneAlmuerzoEjecutivo almuerzoEjecutivo = new PaneAlmuerzoEjecutivo(primaryStage, lista);
                almuerzoEjecutivo.pantallaAlmuerzoEjecutivo(primaryStage, lista);
            } else {
                PaneAlmuerzoEstudiantil almuerzoEstudiantil = new PaneAlmuerzoEstudiantil(primaryStage, lista);
                almuerzoEstudiantil.pantallaAlmuerzoEstudiantil(primaryStage, lista);
            }
        });
    }

    public void pantallaListaCategoriaCompraOnline(Stage primaryStage) {
        Scene escena = new Scene(contenedor, 300, 100);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
