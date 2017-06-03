/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.Categoria;
import Modelo.MarcadorModelado;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Esta clase define un marcador con su respectivo icono dentro de el pane donde esta el mapa
 * @author jonax
 */

public class MarcadorVista {
    //Campos de la clase
    private MarcadorModelado marcador;
    private Rectangle rectangulo;
    private String image_path;
    private double initX;
    private double initY;
    private double initMX;
    private double initMY;
    private Point2D posicionInitMouse;
    private ArrayList<File> images;
    private Pane root;
    private Stage primaryStage;
    
    public MarcadorVista (){
        
    }
    /**
     * Constructor de el MarcadorVista
     * @param marcador es el MarcadorModelado va dentro del marcadorVista
     * @param cat parametro que tiene la categoria del MarcadorVista
     * @param root es el Pane donde esta el mapa y los marcadores
     * @param pos es la poscicion dentro del mapa donde se ubica el Mmarcador
     * @param images lista de File que guarda los archivos de las imagenes del marcador 
     * @param primaryStage stage principal que se usa para mostrar el popup con la informacio del marcador
     */
    public MarcadorVista(MarcadorModelado marcador,Categoria cat,Pane root,Point2D pos,ArrayList<File> images,Stage primaryStage){
        this.primaryStage=primaryStage;
        this.marcador = marcador;
        this.root = root;
        Image img = new Image(marcador.getCategoria().getImagen());
        ImagePattern imagePattern = new ImagePattern(img);
        rectangulo = new Rectangle(72,72);
        rectangulo.setFill(imagePattern);
        rectangulo.setTranslateX(pos.getX());
        rectangulo.setTranslateY(pos.getY());
        
        initMX=pos.getX();
        initMY=pos.getY();
        this.images=images;       
       
        showInfo();
        root.getChildren().add(rectangulo);
        mover();
       
        rectangulo.setOnMouseClicked((MouseEvent me)->{
            
            if(me.getClickCount() == 2){
                MarcadorVentanaEdicion m= new MarcadorVentanaEdicion(this,primaryStage);
            }
        });
        
    }//Cierre del constructor
    /**
     * Metodo que devuelve el MarcadorModelado de un MarcadorVisa
     * @return el MarcadorModelado de un MarcadorVisa
     */
    public MarcadorModelado getMarcador() {
        return marcador;
    }
    /**
     * Metodo que devuelve el Rectangle donde esta el icono del marcador
     * @return el Rectangle donde esta el icono del marcador
     */
    public Rectangle getRectangulo() {
        return rectangulo;
    }
       
    /**
     * Metodo que guarda el MarcadorModelado de un MarcadorVisa
     * @param marcador es el MarcadorModelado que se va a guardar 
     */
    public void setMarcador(MarcadorModelado marcador) {
        this.marcador = marcador;
    }
    /**
     * Metodo vuelve a poner el icono sobre el marcador y la informacion en el popup una vas que estos se modifican
     */
    public void rebuild(){
        Image img = new Image(marcador.getCategoria().getImagen());
        ImagePattern imagePattern = new ImagePattern(img);
        rectangulo.setFill(imagePattern);
        showInfo(); 
    }//Cierre del metodo
    /**
     * Metodo que devuelve una lista de File con las imagenes del marcador
     * @return lista de File con las imagenes del marcador
     */
    public ArrayList<File> getImages() {
        return images;
    }
    /**
     * Metodo que guarda una lista de File con las imagenes del marcador
     * @param images lista de File con las imagenes del marcador
     */
    public void setImages(ArrayList<File> images) {
        this.images = images;
    }
    /**
     * Metodo que devuele una cadena de caracteres con la informacion del marcador
     * @return cadena de caracteres con la informacion del marcador
     */
    @Override
    public String toString() {
        return "Nombre: " + marcador.getNombre() + "\nCategoria: " + marcador.getCategoria().getTipo()+ "\nDescriccion: " + marcador.getDescripcion();
    }
    
    /**
     * Metodo que crea un popup para el marcador con su informacion
     */
    private void showInfo(){
        Popup popup = new Popup();
        VBox vbox=new VBox();
        HBox hbox=new HBox();
        for(File f:images){
            Rectangle rec=new Rectangle(100,100);
            try{
            rec.setFill(new ImagePattern(new Image(f.toURI().toURL().toString())) );
            }catch (MalformedURLException exc) {}
            hbox.getChildren().add(rec);
            
        }
        Label nom=new Label("Nombre: "+this.marcador.getNombre());
        Label cat=new Label("Categoria: "+this.marcador.getCategoria().getTipo());
        Label des=new Label("Description: "+this.marcador.getDescripcion());
        vbox.getChildren().addAll(nom,cat,des,hbox);
        Rectangle fondoPop=new Rectangle(300,200);
        fondoPop.setStroke(Color.BLACK);
        fondoPop.setFill(Color.FLORALWHITE);        
        popup.getContent().addAll(new StackPane(fondoPop,vbox));
        
        
        
        
        rectangulo.setOnMouseEntered((MouseEvent me)->{
            //fondoPop.setWidth(vbox.widthProperty().doubleValue());
            //fondoPop.setHeight(vbox.heightProperty().doubleValue());
            popup.setX(me.getScreenX()); popup.setY(me.getScreenY());
            popup.show(primaryStage);
            System.out.println(vbox.widthProperty().doubleValue()+" "+vbox.heightProperty().doubleValue());
        });
        rectangulo.setOnMouseExited((MouseEvent me)->{
            
            popup.hide();
        });
        
        
    }//Cierre del metodo
    /**
     * Metodo que crea las acciones de movimiento del icono del marcador
     */    
    private void mover(){
        rectangulo.setOnMousePressed(me -> {
            System.out.println("mouse: "+me.getX()+" "+me.getY());
            System.out.println("fig: "+rectangulo.getX()+" "+rectangulo.getY());
            rectangulo.setX(me.getX()-(rectangulo.widthProperty().doubleValue()/2));
            rectangulo.setY(me.getY()-(rectangulo.heightProperty().doubleValue()/2));
            //when mouse is pressed, store initial position
            initX = rectangulo.getX();
            initY = rectangulo.getY();
            marcador.setPosX(marcador.getPosX()+me.getX()-(rectangulo.widthProperty().doubleValue()/2));
            marcador.setPosY(marcador.getPosY()+me.getY()-(rectangulo.heightProperty().doubleValue()/2));
            System.out.println("marcador: "+marcador.getPosX()+" "+marcador.getPosY());
            posicionInitMouse = new Point2D(me.getSceneX(), me.getSceneY());
            
        });
        
        rectangulo.setOnMouseDragged((MouseEvent me) -> {
            //calcula la distancia que movimos el mouse 
            //(que ser'ia la distacia que deberías desplazar el objeto)
            double x=rectangulo.getX();
            double y=rectangulo.getY();
            double dragX = me.getSceneX() - posicionInitMouse.getX();
            double dragY = me.getSceneY() - posicionInitMouse.getY();
            
            //calculate new position of the circle
            double newXPosition = initX + dragX;
            double newYPosition = initY + dragY;
            
            double WIDTH_AREA = 2248/*_root.widthProperty().doubleValue()*/;
            double HEIGHT_AREA = 1352/*_root.heightProperty().doubleValue()*/;
            /*
            rectangulo.setX(newXPosition);
            rectangulo.setY(newYPosition);
            */
            //if new position do not exceeds borders of the rectangle, translate to this position
            //initX-posicionInitMouse.getX()
            //initY-posicionInitMouse.getY()
            if ((newXPosition >= initX-posicionInitMouse.getX()) && (newXPosition <= WIDTH_AREA - initMX)) {
                rectangulo.setX(newXPosition);
                
            }
            if ((newYPosition >= initY-posicionInitMouse.getY()+25) && (newYPosition <= HEIGHT_AREA - initMY-75)) {
                rectangulo.setY(newYPosition);
                
            }
            x=rectangulo.getX()-x;
            y=rectangulo.getY()-y;
            marcador.setPosX(marcador.getPosX()+x);
            marcador.setPosY(marcador.getPosY()+y);
            System.out.println("marcador: "+marcador.getPosX()+" "+marcador.getPosY());
            System.out.println("rect: "+rectangulo.getX()+" "+rectangulo.getY());
        });
    }//Cierre del metodo
}
