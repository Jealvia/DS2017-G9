/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
//CAMBIA
//2
import Categoria.Categoria;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Julio Alvia
 */
public class Platos <E>{
    private String nombre,descripcion,tipo,servido,ingredientes;
    Categoria categoria;
    private Restaurante restaurante;

    public Platos(String nombre, String descripcion, Categoria categoria, String tipo, String servido, Restaurante restaurante,String ingredientes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipo = tipo;
        this.servido = servido;
        this.restaurante = restaurante;
        this.ingredientes=ingredientes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    
    public String getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    public Platos(){
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
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getServido() {
        return servido;
    }
    public void setServido(String servido) {
        this.servido = servido;
    }
    public Restaurante getObjRestaurante() {
        return restaurante;
    }
    public void setNombreRestaurante(Restaurante nombreRestaurante) {
        this.restaurante = nombreRestaurante;
    } 
    public ArrayList<Platos> listarPlatos(HashMap<String, Platos> listPlatos, String categoria) {
        ArrayList<Platos> lista = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if (entry.getValue().getCategoria().getNombre().equals(categoria)) {
                lista.addAll((Collection<? extends Platos>) entry.getValue());
            }
        }
        return lista;
    }
    //lista de platos que solo pertenecen a un restaurante
    public ArrayList<E> listarPlatosAsistente(HashMap<String, Platos> listPlatos, String restaurante) {
        ArrayList<E> lista = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if (entry.getValue().getObjRestaurante().getNombre().equals(restaurante)) {
                lista.addAll((Collection<? extends E>) entry.getValue());
            }
        }
        return lista;
    }
    //Solo sirve para agregar platillo
    public boolean agregarPlatillo(String categoria,String nombre,String descripcion,String servido,String tipo,String restaurante,String ingredientes) {
        //Julio: agregar informacion al CSV
        
        String info=categoria+";"+nombre+";"+descripcion+";"+servido+";"+tipo+";"+restaurante+";"+ingredientes;
        String ruta = "C:\\Users\\jimmy\\Documents\\proyectoDS\\DS2017-G9\\Proyecto\\platos.csv";
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ruta)),true);
            pw.println(info);
            System.out.println("");
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("el archivo platos.csv no existe");
        } catch (IOException ex) {
            System.out.println("se produjo error al escribir platos.csv");
        }
        
       
        return true;
    }
    //el primer valor que tiene que recibir debe ser un identificador(nombe)
    public boolean modificarPlatillo(String identificador,Categoria categoria,String nombre,String descripcion,String servido,String tipo,String restaurante,String ingrediente,HashMap<String, Platos> listPlatos){
        Restaurante rest=new Restaurante(restaurante);
        Platos temp=new Platos(nombre,descripcion,categoria,tipo,servido,rest,ingrediente);
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if(entry.getValue().getNombre()==identificador){
                if(entry.getValue().getObjRestaurante().getNombre()==restaurante)
                    entry.setValue(temp);
            }
        }
        Persistencia.writePlatos(listPlatos);
        return true;
    }
    
    
 

    

    
    
    
}
