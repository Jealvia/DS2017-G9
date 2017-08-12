/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DecoratorPanes.Categoria;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Julio Alvia
 */
public class Persistencia<E> {

    /**
     *
     * @return
     */
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
                String restaurante = valores[4].trim();
                Restaurante rest = new Restaurante(restaurante);
                System.out.println(restaurante);
                switch (rol) {
                    case "Cliente":
                        temporal.put(id, new Usuario(nombre, id, contrasena, rol, rest));
                        break;
                    case "Asistente de Restaurante":
                        temporal.put(id, new Usuario(nombre, id, contrasena, rol, rest));
                        break;
                }
            }
        } catch (IOException e) {
        }
        return temporal;
    }

    public static HashMap<String, Platos> leerPlatos() {
        HashMap<String, Platos> temporal = new HashMap<>();
        String linea;
        try {
            FileReader f = new FileReader("platos.csv");
            BufferedReader br = new BufferedReader(f);
            int i = 0;
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String valores[];
                valores = linea.split(";");
                String cat = valores[0].trim();
                Categoria categoria = new Categoria(cat);
                String nombre = valores[1].trim();
                String descripcion = valores[2].trim();
                String servido = valores[3].trim();
                String tipo = valores[4].trim();
                String restaurante = valores[5].trim();
                String ingredientes = valores[6].trim();
                
                Restaurante rest = new Restaurante(restaurante);
                temporal.put(nombre, new Platos(nombre, descripcion, categoria, tipo, servido, rest, ingredientes));
            }
        } catch (IOException e) {
        }
        return temporal;
    }

    public static HashMap<String, Restaurante> leerRestaurante() {
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
                temporal.put(nombre, new Restaurante(nombre, descripcion, telefono));
            }

        } catch (IOException e) {
        }
        return temporal;
    }

    public static boolean writePlatos(HashMap<String, Platos> listaplatos) {
        //public static void writeEventos(HashMap<String, Evento> eventos) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("platos.csv", true)));

            for (Map.Entry<String, Platos> entry : listaplatos.entrySet()) {

                String linea = entry.getKey() + ";" + entry.getValue().getNombre() + ";" + entry.getValue().getDescripcion() + ";" + entry.getValue().getServido() + ";" + entry.getValue().getTipo() + ";" + entry.getValue().getObjRestaurante().getNombre() + ";" + entry.getValue().getIngredientes();

                System.out.println(linea);
                pw.write(linea + "\n");

            }

            System.out.println("GUARDADO CON EXITO");
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("el archivo eventos.csv no existe");
        } catch (IOException ex) {
            System.out.println("se produjo error al escribir eventos.csv");
        }
        return true;
    }

    public static boolean LimpiarCSVPlatos(HashMap<String, Platos> listaplatos) {
        //public static void writeEventos(HashMap<String, Evento> eventos) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("platos.csv", true)));
            pw.write("");
            System.out.println("ELIMINADOS CON EXITO");
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
