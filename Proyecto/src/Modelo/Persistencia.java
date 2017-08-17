/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import SegundaParte.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Julio Alvia
 * @param <E>
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
                System.out.println(restaurante);
                switch (rol) {
                    case "Cliente":
                        temporal.put(id, new Usuario(nombre, id, contrasena, rol, restaurante));
                        break;
                    case "Asistente":
                        temporal.put(id, new Usuario(nombre, id, contrasena, rol, restaurante));
                        break;
                }
            }
        } catch (IOException e) {
        }
        return temporal;
    }

    public static ArrayList<Platos> leerPlatos() {
        ArrayList<Platos> temporal = new ArrayList<>();
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
                temporal.add(new Platos(nombre, descripcion, ingredientes, tipo, servido, categoria, restaurante));
            }
        } catch (IOException e) {
        }
        return temporal;
    }

    public static HashMap<String, ArrayList<String>> leerRestaurante() {
        HashMap<String, ArrayList<String>> temporal = new HashMap<>();
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
                ArrayList<String> datosRestaurante = new ArrayList<>();
                datosRestaurante.add(nombre);
                datosRestaurante.add(descripcion);
                datosRestaurante.add(telefono);
                datosRestaurante.add(asistente);
                temporal.put(nombre, datosRestaurante);
            }

        } catch (IOException e) {
        }
        return temporal;
    }

    public static boolean writePlatos(ArrayList<Platos> listaplatos) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("platos.csv", true)));

            for (int i = 0; i < listaplatos.size(); i++) {
                String linea = listaplatos.get(i).getCategoria() + ";" + listaplatos.get(i).getNombre() + ";" + listaplatos.get(i).getDescripcion() + ";" + listaplatos.get(i).getServido() + ";" + listaplatos.get(i).getTipo() + ";" + listaplatos.get(i).getNombreRestaurante() + ";" + listaplatos.get(i).getIngredientes();

                System.out.println(linea);
                pw.write(linea + "\n");

            }
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("el archivo eventos.csv no existe");
        } catch (IOException ex) {
            System.out.println("se produjo error al escribir eventos.csv");
        }
        return true;
    }
}
