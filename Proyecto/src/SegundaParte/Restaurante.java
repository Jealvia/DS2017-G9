/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package SegundaParte;
 
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;


 
/**
 *
 * @author Julio Alvia
 */
 
public abstract class Restaurante implements IRestaurante{
    
    private String nombre;
    private String descripcion;
    private String telefono;
    private ArrayList<Platos> listaPlatos;
    private FileWriter archivoPlatos;
    private FileWriter archivoAsistentes;
    private boolean compraOnline;   

    public Restaurante(String nombre, String descripcion, String telefono, boolean compraOnline) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.compraOnline = compraOnline;
        
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Platos> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(ArrayList<Platos> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public FileWriter getArchivoPlatos() {
        return archivoPlatos;
    }

    public void setArchivoPlatos(FileWriter archivoPlatos) {
        this.archivoPlatos = archivoPlatos;
    }

    public boolean isCompraOnline() {
        return compraOnline;
    }

    public void setCompraOnline(boolean compraOnline) {
        this.compraOnline = compraOnline;
    }
    public FileWriter getArchivoAsistentes() {
        return archivoAsistentes;
    }

    public void setArchivoAsistentes(FileWriter archivoAsistentes) {
        this.archivoAsistentes = archivoAsistentes;
    }
    
    
}
 