/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package SegundaParte;
 
import java.io.File;
import java.util.ArrayList;


 
/**
 *
 * @author Julio Alvia
 */
 
public abstract class Restaurante implements IRestaurante{
    
    private String nombre;
    private String descripcion;
    private String telefono;
    private ArrayList<Platos> listaPlatos;
    private File archivoPlatos;
    private File archivoAsistentes;
    private boolean compraOnline;
    private ArrayList<Asistente> listaAsistentes;
    
    public abstract void llenarListaPlatos();
    public abstract void llenarListaAsistentes();
    
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

    public File getArchivoPlatos() {
        return archivoPlatos;
    }

    public void setArchivoPlatos(File archivoPlatos) {
        this.archivoPlatos = archivoPlatos;
    }

    public boolean isCompraOnline() {
        return compraOnline;
    }

    public void setCompraOnline(boolean compraOnline) {
        this.compraOnline = compraOnline;
    }

    public ArrayList<Asistente> getListaAsistentes() {
        return listaAsistentes;
    }

    public void setListaAsistentes(ArrayList<Asistente> listaAsistentes) {
        this.listaAsistentes = listaAsistentes;
    }

    public File getArchivoAsistentes() {
        return archivoAsistentes;
    }

    public void setArchivoAsistentes(File archivoAsistentes) {
        this.archivoAsistentes = archivoAsistentes;
    }
    
    
}
 