/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
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
    private String nombre,descripcion,categoria,tipo,servido;
    private Restaurante nombreRestaurante;

    public Platos(String nombre, String descripcion, String categoria, String tipo, String servido, Restaurante nombreRestaurante) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipo = tipo;
        this.servido = servido;
        this.nombreRestaurante = nombreRestaurante;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public Restaurante getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(Restaurante nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }
    public ArrayList<E> listarPlatos(HashMap<String, Platos> listPlatos, String categoria) {
        ArrayList<E> lista = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if (entry.getKey() == categoria) {
                lista.addAll((Collection<? extends E>) entry.getValue());
            }
        }

        return lista;
    }
    //lista de platos que solo pertenecen a un restaurante
    public ArrayList<E> listarPlatosAsistente(HashMap<String, Platos> listPlatos, String restaurante) {
        ArrayList<E> lista = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if (entry.getValue().getNombreRestaurante().getNombre() == restaurante) {
                lista.addAll((Collection<? extends E>) entry.getValue());
            }
        }

        return lista;
    }
    //Solo sirve para agregar platillo
    public boolean agregarPlatillo(String categoria,String nombre,String descripcion,String servido,String tipo,String restaurante){
        //Julio: agregar informacion al CSV
        String info=categoria+";"+nombre+";"+descripcion+";"+servido+";"+tipo+";"+restaurante;
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("platos.csv")),true);
            pw.println(info);
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("el archivo platos.csv no existe");
        } catch (IOException ex) {
            System.out.println("se produjo error al escribir platos.csv");
        }
        return true;
    }
    
    //el primer valor que tiene que recibir debe ser un identificador(nombe)
    public boolean modificarPlatillo(String identificador,String categoria,String nombre,String descripcion,String servido,String tipo,String restaurante,HashMap<String, Platos> listPlatos){
        Restaurante rest=new Restaurante(restaurante);
        Platos temp=new Platos(nombre,descripcion,categoria,tipo,servido,rest);
        
        for (Map.Entry<String, Platos> entry : listPlatos.entrySet()) {
            if(entry.getValue().getNombre()==identificador){
                if(entry.getValue().getNombreRestaurante().getNombre()==restaurante)
                    entry.setValue(temp);
            }
        }
        Persistencia.writePlatos(listPlatos);
        return true;
    }
    
    
 

    

    
    
    
}
