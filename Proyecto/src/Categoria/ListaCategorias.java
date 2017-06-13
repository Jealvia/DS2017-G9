/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categoria;

/**
 *
 * @author Julio Alvia
 */
import InformacionPlatos.ListaPlatos;
import Modelo.Persistencia;
import Modelo.Platos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
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
public class ListaCategorias {

    Label nombre;
    static VBox vbox;
    HBox hbox;
    private Stage primaryStage;
    static BorderPane contenedor;
    static ArrayList<String> list;
    //PARA PRESENTAR LISTA DE OPCIONES
    static ObservableList<String> tiposPlatos;
    static ListView<String> listaPlatos;
    public HashMap<String, Platos> categoriaPlato;    
    
    
    public ArrayList<String> ListaCategorias(ArrayList<Platos> lista) {
        Set<Categoria> catego = new HashSet<>();
        for (Platos m : lista) {
            System.out.println("hola");
            catego.add(m.getCategoria());
        }
        int tam=catego.size();
        ArrayList<String> listacategorias=new ArrayList<>();
        Iterator<Categoria> it1 = catego.iterator();
        while (it1.hasNext()){
            Categoria temp=new Categoria();
            temp=it1.next();
            listacategorias.add(temp.getNombre());
        }
        return listacategorias;
    }

    public ListaCategorias() {
        this.contenedor=new BorderPane();
    }
    public static BorderPane getContenedor() {
        return contenedor;
    }

    public static void setContenedor(BorderPane contenedor) {
        ListaCategorias.contenedor = contenedor;
    }
    
    public void ventanaListaCategoria(ArrayList<String> lista, Stage primaryStage,String restaurante,String id){
        VBox vbox = new VBox(10);
        for(String m:lista){
            System.out.println(m);
        }
        //PARA PRESENTAR UNA LISTA DE OPCIONES
        ListaCategorias.tiposPlatos = FXCollections.observableArrayList(lista);
        listaPlatos = new ListView<String>(tiposPlatos);
        listaPlatos.setPrefSize(50, 100);
        vbox.setStyle("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: DARKCYAN;");
        vbox.getChildren().add(listaPlatos);
        contenedor.setCenter(vbox);
        
        listaPlatos.setOnMouseClicked((MouseEvent me) -> {
            String opcion=listaPlatos.getSelectionModel().getSelectedItem();
            ArrayList<Platos> listapt=new ArrayList<>();
            listapt=ListaCategorias.listaPresentar(opcion,restaurante);
            ListaPlatos lp = new ListaPlatos();
            lp.ventanaListaPlatos(listapt, primaryStage,id);
        });
        
        Scene escena = new Scene(contenedor,800,400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    
    public static ArrayList<Platos> listaPresentar(String categorias,String restaurante){
        HashMap<String, Platos> categoriaPlato=new HashMap<>();
        categoriaPlato=Persistencia.leerPlatos();
        ArrayList<Platos> lista=new ArrayList<>();
        if("-".equals(restaurante)){
        for (Platos plato : categoriaPlato.values()) {
            if(plato.getCategoria().getNombre().equals(categorias)){
                lista.add(plato);
            }
        }       
        }else{
            for (Platos plato : categoriaPlato.values()) {
            if(plato.getCategoria().getNombre().equals(categorias)&&plato.getRestaurante().getNombre().equals(restaurante)){
                lista.add(plato);
            }
        }
        }
        return lista;
    }

  

}
