/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.Categoria;
import Modelo.MarcadorModelado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * En esta clase se define una ventana de dialogo para la creacion y edicion de los marcadores sobre el mapa
 * @author Julio Alvia
 */
public class MarcadorVentanaEdicion {
    //Campos de la clase
    private GridPane root;
    private int imgtot = 0, imgpos = 0;
    private Label nombre, categoria, descripcion, imagenes;
    private Button  ima, anterior, siguiente,eliminar,eliminarImagen;
    private ButtonType aceptar;
    private TextField nombre1, descripcion1;
    private ImageView img;
    private Image cargarimg;
    private ChoiceBox<Categoria> catego;
    private ArrayList<File> listaimg;
    private ArrayList<String> stringimg;
    private Pane rootPrincipal;
    private Point2D pos;
    private ArrayList listaMarcadores;
    private ArrayList<MarcadorModelado> listaMarcadormodelo;
    private Stage primaryStage;
    MarcadorVista marcadorVista;
    Dialog dialog;

    public MarcadorVentanaEdicion(){}
    
    
    
    /**
     * Constructor de la MarcadorVentanaEdicion que se utiliza para la creacion de nuevos marcadores
     * @param rootPrin parametro en el Pane sobre el cual esta el mapa y los marcadores
     * @param pos poscicion sobre la cual se va a crear el nuevo marcador
     * @param listaMarcadores lista de MarcadoresVista que contiene los marcadores sobre el pane
     * @param listaMarcadormodelo lista de MarcadoresModelo que contiene los maracadore cargados del archivo xml
     * @param primaryStage stage principal que se usa para mostrar la informacion de cada marcador
     */
    public MarcadorVentanaEdicion(Pane rootPrin, Point2D pos,ArrayList listaMarcadores,ArrayList<MarcadorModelado> listaMarcadormodelo,Stage primaryStage) {
        this.listaMarcadores=listaMarcadores;
        this.rootPrincipal = rootPrin;
        root = new GridPane();
        this.pos = pos;
        this.dialog=new Dialog();
        this.listaMarcadormodelo=listaMarcadormodelo;
        this.primaryStage=primaryStage;
        PreOrganizador();
        Organizador1();
    }//Cierre del constructor 
    /**
     * Constructor de la MarcadorVentanaEdicion que se utiliza para la edicion de los marcadores
     * @param marcadorVista MarcadorVista que se va a editar
     * @param primaryStage stage principal que se utiliza para mostrar un popup con la informacion del marcador
     */
    public MarcadorVentanaEdicion(MarcadorVista marcadorVista,Stage primaryStage){
        root = new GridPane();
        this.dialog=new Dialog();        
        this.primaryStage=primaryStage;
        PreOrganizador();
        Organizador2(marcadorVista);
    }//Cierre del constructor    
    /**
     * Metodo que ubica elementos comunes entre la creacion y la edicion dentro de la ventana de dialogo
     */
    private void PreOrganizador(){
        dialog.setTitle("Añadir marcador");
        dialog.setHeaderText("Ingresar datos");
        aceptar = new ButtonType("Aceptar", ButtonData.OK_DONE);
        eliminar=new Button("Eliminar marcador");
        dialog.getDialogPane().getButtonTypes().addAll(aceptar /*ButtonType.OK*/, ButtonType.CANCEL);
        nombre = new Label("Nombre");
        categoria = new Label("Categoria");
        descripcion = new Label("Descripcion");
        imagenes = new Label("Imagenes");        
        catego = new ChoiceBox<>();
        catego.setItems(FXCollections.observableArrayList(Categoria.values()));
        ima = new Button("Insertar");
        anterior = new Button("Anterior");
        siguiente = new Button("Siguiente");
        eliminarImagen=new Button("Eliminar imagen");
        img = new ImageView();
        img.setFitHeight(100);
        img.setFitWidth(200);
        nombre1 = new TextField(); 
        descripcion1 = new TextField();
        
        root.setVgap(5);
        root.setHgap(5);
        root.add(nombre, 2, 2);
        root.add(categoria, 2, 3);
        root.add(descripcion, 2, 5);
        root.add(imagenes, 2, 8);        
        GridPane.setColumnSpan(nombre1, 2);
        root.add(catego, 3, 3);
        GridPane.setColumnSpan(catego, 6);
        GridPane.setColumnSpan(descripcion1, 2);
        GridPane.setRowSpan(descripcion1, 4);
        root.add(ima, 3, 8);
        root.add(anterior, 2, 9);
        root.add(img, 3, 9);
        root.add(siguiente, 4, 9);
        root.add(eliminarImagen, 3, 10);
        root.setAlignment(Pos.CENTER);
        dialog.getDialogPane().setContent(root);
    }//Cierre del metodo
    /**
     * Metodo que ubica elementos exclusivos de la creacion dentro de la ventana de dialogo
     */
    private void Organizador1() {
        root.add(nombre1, 3, 2);
        root.add(descripcion1, 3, 4);
        catego.setValue(Categoria.AULAS);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == aceptar) {
                MarcadorModelado tmp = new MarcadorModelado(nombre1.getText(), catego.getValue(), descripcion1.getText(), stringimg,pos.getX(),pos.getY());
                MarcadorVista tmp2=new MarcadorVista(tmp, tmp.getCategoria(), rootPrincipal, pos,listaimg,primaryStage);
                this.listaMarcadores.add(tmp2);
                this.listaMarcadormodelo.add(tmp);
            return tmp2;                
            }
            return null;
        });
        listaimg = new ArrayList<>();
        stringimg = new ArrayList<>();
        seleccionImagen();
        Optional<MarcadorVista> tmp2 = dialog.showAndWait();
                
    }//Cierre del metodo
    /**
     * Metodo que ubica elementos exclusivos de la edicion dentro de la ventana de dialogo
     */
    private void Organizador2(MarcadorVista _marcadorVista){
        this.marcadorVista=_marcadorVista;
        root.add(eliminar, 2, 11);
        nombre1.setText(new String(marcadorVista.getMarcador().getNombre()));        
        descripcion1.setText(new String(marcadorVista.getMarcador().getDescripcion()));
        catego.setValue(marcadorVista.getMarcador().getCategoria());
        root.add(nombre1, 3, 2);
        root.add(descripcion1, 3, 4);
        
        eliminar.setOnAction(new EliminarMarcador(marcadorVista,dialog));
        

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == aceptar) {
                marcadorVista.getMarcador().setNombre(nombre1.getText());
                marcadorVista.getMarcador().setDescripcion(descripcion1.getText());
                marcadorVista.getMarcador().setCategoria(catego.getValue());
                marcadorVista.setImages(listaimg);
                marcadorVista.getMarcador().setImagePaths(stringimg);
                marcadorVista.rebuild();
            return null;
                
            }
            return null;
        });
        listaimg = new ArrayList<File>();
        for(File f:marcadorVista.getImages()){
            listaimg.add(f);
        }
        
        stringimg = new ArrayList<String>();
        for (String s:marcadorVista.getMarcador().getImagePaths()){
            stringimg.add(s);
        }
        
        try {
            
            imgtot = listaimg.size();
            System.out.println(listaimg.size());
            if (imgtot > 0) {
                imgpos = 0;
            }
            if(!listaimg.isEmpty()){
                img.setImage(new Image(listaimg.get(imgpos).toURI().toURL().toString()));
            }
        } catch (MalformedURLException exc) {
            Logger.getLogger(MarcadorVentanaEdicion.class.getName()).log(Level.SEVERE, null, exc);

        }
        seleccionImagen();
        Optional<MarcadorVista> tmp2 = dialog.showAndWait();
    }//Cierre del metodo
    
    /**
     * Metodo guarda las acciones de seleccionar y borrar imagenes que pertenecen a un marcador
     */
    private void seleccionImagen(){
        ima.setOnAction((ActionEvent e) -> {
            Window stage = null;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Imagen");
                File file = fileChooser.showOpenDialog(stage);
                if (file.isFile() && (file.getName().contains(".jpg")) || (file.getName().contains(".png"))
                        || (file.getName().contains(".bmp")) || (file.getName().contains(".gif"))) {
                    
                    String direccion = file.toURI().toURL().toString();               
                    
                    File file1 = new File("src/DataAccess/" + file.getName());
                    copyFileUsingFileStreams(file, file1);
                    cargarimg = new Image(file1.toURI().toURL().toString());
                    img.setImage(cargarimg);
                    listaimg.add(file1);
                    imgtot = listaimg.size();
                    System.out.println(listaimg.size());
                    if (imgtot > 1) {
                        imgpos++;
                    }
                    stringimg.add("src/DataAccess/" + file.getName());
                }
            } catch (MalformedURLException exc) {
                Logger.getLogger(MarcadorVentanaEdicion.class.getName()).log(Level.SEVERE, null, exc);
            } catch (IOException ex) {
                Logger.getLogger(MarcadorVentanaEdicion.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        siguiente.setOnAction((ActionEvent e) -> {
            if (imgpos < imgtot - 1) {
                try {
                    imgpos++;
                    String direccion1 = listaimg.get(imgpos).toURI().toURL().toString();
                    Image imageload = new Image(direccion1);
                    img.setImage(imageload);
                } catch (MalformedURLException exc) {
                    Logger.getLogger(MarcadorVentanaEdicion.class.getName()).log(Level.SEVERE, null, exc);
                }
            }
        });

        anterior.setOnAction((ActionEvent e) -> {
            if (imgpos > 0) {
                try {
                    imgpos--;
                    String direccion1 = listaimg.get(imgpos).toURI().toURL().toString();
                    Image imageload = new Image(direccion1);
                    img.setImage(imageload);
                } catch (MalformedURLException exc) {
                    Logger.getLogger(MarcadorVentanaEdicion.class.getName()).log(Level.SEVERE, null, exc);
                }
            }
        });
        eliminarImagen.setOnAction(e->{
            if (imgtot >= 0) {
                listaimg.remove(imgpos);
                stringimg.remove(imgpos);
                if (imgtot > 1) {
                    if (imgpos > 0) {

                        try {
                            imgpos--;
                            String direccion1 = listaimg.get(imgpos).toURI().toURL().toString();
                            Image imageload = new Image(direccion1);
                            img.setImage(imageload);
                        } catch (MalformedURLException exc) {
                            Logger.getLogger(MarcadorVentanaEdicion.class.getName()).log(Level.SEVERE, null, exc);
                        }
                        
                    } else {
                        try {
                                String direccion1 = listaimg.get(imgpos).toURI().toURL().toString();
                                Image imageload = new Image(direccion1);
                                img.setImage(imageload);
                            } catch (MalformedURLException exc) {
                                Logger.getLogger(MarcadorVentanaEdicion.class.getName()).log(Level.SEVERE, null, exc);
                            }
                    }
                    imgtot--;
                }else{
                    img.setImage(null);
                }
            }
        });
        
    }//Cierre del metodo

    

       
    //Metodo que se utiliza para copiar una imagen seleccionada de cualquier parte a la carpeta del proyecto
    private static void copyFileUsingFileStreams(File source, File dest) throws IOException {
        //C:\Users\Julio Alvia\Documents\NetBeansProjects\proyectopoo\proyectopoo2p\proyectopoo\proyectopoo2p\src\DataAccess
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }//Cierre del metodo
}
