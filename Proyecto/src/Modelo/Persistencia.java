/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Julio Alvia
 */
public class Persistencia {

    public static HashMap<String, Usuario> leerUsuarios() {
        HashMap<String, Usuario> temporal = new HashMap<>();
        String linea;
        
        try {
            
            FileReader f = new FileReader("usuario.csv");
            BufferedReader br = new BufferedReader(f);
            
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    System.out.println(linea);
                    break;
                }
                String valores[];
                valores = linea.split(";");
                String nombre = valores[0].trim();
                String id = valores[1].trim();
                String contrasena = valores[2].trim();
                String rol = valores[3].trim();

                switch (rol) {
                    case "cliente":
                        temporal.put(nombre, new Usuario(nombre, id, contrasena, rol));
                        break;
                    case "asistente":
                        temporal.put(nombre, new Usuario(nombre, id, contrasena, rol));
                        break;
                }
                
                
            }
        } catch (IOException e) {
        }
        return temporal;
    }

    
    public static HashMap<String, Platos> leerPlatos()
    {
        HashMap<String, Platos> temporal = new HashMap<>();
        String linea;
        try {
            FileReader f = new FileReader("platos.csv");
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String valores[];
                valores = linea.split(",");
                String categoria = valores[0].trim();
                String nombre = valores[1].trim();
                String descripcion = valores[2].trim();
                String servido = valores[3].trim();
                String tipo = valores[4].trim();
                
                String restaurante = valores[5].trim();
                Restaurante rest=new Restaurante(restaurante);
                switch (categoria) {
                    case "estudiantil":
                        temporal.put(categoria, new Platos(nombre,descripcion,categoria,tipo,servido,rest));
                        break;
                    case "ejecutivo":
                        temporal.put(categoria, new Platos(nombre,descripcion,categoria,tipo,servido,rest));
                        break;
                }
            }
        } catch (IOException e) {
        }
        return temporal;
    }

    public static HashMap<String, Restaurante> leerRestaurante()
    {
        HashMap<String, Restaurante> temporal = new HashMap<>();
        String linea;
        try {
            FileReader f = new FileReader("restaurante.csv");
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String valores[];
                valores = linea.split(";");
                String nombre = valores[0].trim();
                String descripcion = valores[1].trim();
                String telefono = valores[2].trim();
                String asistente = valores[3].trim();
                temporal.put(nombre,new Restaurante(nombre,descripcion,telefono));
            }
            
        } catch (IOException e) {
        }
        return temporal;
    }
    
    public static boolean writePlatos(HashMap<String, Platos> listaplatos){
        //public static void writeEventos(HashMap<String, Evento> eventos) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("platos.csv")));
            for (Map.Entry<String, Platos> entry : listaplatos.entrySet()) {
                String linea=entry.getValue().getCategoria()+";"+entry.getValue().getNombre()+entry.getValue().getDescripcion()+";"+entry.getValue().getServido()+";"+entry.getValue().getTipo()+entry.getValue().getNombreRestaurante().getNombre();
                pw.println(linea);
            }

            pw.close();
        
        } catch (FileNotFoundException ex) {
            System.out.println("el archivo eventos.csv no existe");
        } catch (IOException ex) {
            System.out.println("se produjo error al escribir eventos.csv");
        }
            return true;
    }
        
    
    
    public static boolean agregarAdministrador() {

        return true;
    }
}
