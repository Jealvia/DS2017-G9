/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

import Modelo.Categoria;
import Presentacion.MarcadorVista;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * En esta clase se define la busqueda de los marcadores segun su categoria usando hilos
 * @author CEEMP02
 */
public class HiloBuscar implements Runnable {
    //Campos de la clase
    private Util tmp;
    private ArrayList<MarcadorVista> lista;
    private Categoria cat;
    private ScrollPane lmarcadores;
    /**
     * Constructor de HiloBuscar
     * @param lista lista de marcadoresVista sobre los cuales se va a buscar 
     * @param cat categoria que se va a buscar
     * @param lmarcadores un ScrollPane donde se almacena la informacion de los hilos encontrados
     */
    public HiloBuscar(ArrayList<MarcadorVista> lista,Categoria cat,ScrollPane lmarcadores ){
        this.lista = lista;
        this.cat = cat;
        this.lmarcadores=lmarcadores;
    }//Cierre del constructor
    
    @Override
    public void run() {
        VBox vbox= new VBox();
        
        tmp = new Util();
        System.out.println("Ha ingresado al hilo\n");
        ArrayList<MarcadorVista> marcadores = tmp.Busqueda(lista,cat);
        int i=0;
        for(MarcadorVista m:marcadores){
            HBox hb= new HBox();
            
            for(File f: m.getImages()){
                Rectangle rec = new Rectangle(75,75);
                try {
                    rec.setFill(new ImagePattern(new Image(f.toURI().toURL().toString())));
                } catch (MalformedURLException exc) {
                }
                hb.getChildren().add(rec);
            }
            String s = m.toString();
            Label lb=new Label("Marcador "+(i+1)+":\n"+m.toString());
            lb.setBorder(Border.EMPTY);
            
            vbox.getChildren().add(new VBox(lb,hb));
            i++;
        }
        vbox.setSpacing(20);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lmarcadores.setContent(vbox);
            }
        });

        System.out.println("Ha salido del hilo");
    }
    
}
