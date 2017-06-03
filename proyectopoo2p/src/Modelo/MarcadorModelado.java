/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase define los metadatos de un marcador
 * @author grupopoo
 * 
 */
@XmlRootElement (name = "marcador")
public class MarcadorModelado {
    //Campos de la clase
    private String nombre;
    private Categoria categoria;
    private String descripcion;
    private ArrayList<String> imagePaths;
    private double posX;
    private double posY;
    
    public MarcadorModelado(){        
    }
    
    /**
     * Constructor para el marcador modelado
     * @param nombre El parámetro nombre define el nombre del marcador
     * @param categoria El parametro categoria contine la caategoria del marcador
     * @param descripcion El parametro descripcion contiene la descripcion 
     * @param listaImagenes El parametro listaImagenes contiene las direcciones de las imagenes de marcador
     * @param posX El parametro posX guarda la poscicion x del marcadoren el Pane
     * @param posY El parametro posY guarda la poscicion y del marcador en el Pane
     */
    public MarcadorModelado(String nombre,Categoria categoria, String descripcion, ArrayList<String> listaImagenes,double posX,double posY){
        //Campos de la clase
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.imagePaths = listaImagenes;
        this.posX=posX;
        this.posY=posY;
    }//Cierre del constructor
    
    //inicio de metodos gets
     /**
     * Método que devuelve el nombre del marcador
     * @return el nombre del marcador
     */
    @XmlElement (name = "nombre")
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que devuelve la categoria del marcador
     * @return la categoria del marcador
     */
    @XmlElement (name = "categoria")
    public Categoria getCategoria() {
        return categoria;
    }
    /**
     * Método que devuelve la descripcion del marcador
     * @return la descripcion del marcador
     */
    @XmlElement (name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Método que devuelve la lista de direcciones de imagrnes del marcador
     * @return la lista de direcciones de imagrnes del marcador
     */
    @XmlElementWrapper (name= "arreglodeimagenes")
    @XmlElement (name = "imagen")
    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }
    
    /**
     * Método que devuelve la poscicion x dentro del pane del marcador
     * @return la poscicion x dentro del pane del marcador
     */
    @XmlElement (name = "posX")
    public double getPosX() {
        return posX;
    }
    
    /**
     * Método que devuelve la poscicion y dentro del pane del marcador
     * @return la poscicion y dentro del pane del marcador
     */
    @XmlElement (name = "posY")
    public double getPosY() {
        return posY;
    }
    //inicio de metodos set
    /**
     * Método que guarda la poscicion x dentro del pane del marcador
     * @param posX poscicion "y" del marcador dentro del pane
     */
    public void setPosX(double posX) {
        this.posX = posX;
    }
    
    /**
     * Método que guarda la poscicion "y" dentro del pane del marcador
     * @param posY poscicion "y" del marcador dentro del pane
     */
    public void setPosY(double posY) {
        this.posY = posY;
    }
    /**
     * Método que guarda el nombre del marcador
     * @param nombre nombre del marcador 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que guarda el nombre del marcador
     * @param categoria nombre del marcador 
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    /**
     * Método que guarda la descripcion del marcador
     * @param descripcion descripcion del marcador 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Método que guarda las direcciones de imagenes del marcador
     * @param imagePaths lista de direcciones de imagnes dentro del macador
     */
    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }
    
    
}
