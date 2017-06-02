/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Julio Alvia
 */
public class Persistencia {

    public static HashMap<String, Usuario> leerUsuarios() {
        HashMap<String, Usuario> temporal = new HashMap<>();
        String linea;
        try {
            FileReader f = new FileReader("usuarios.csv");
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String valores[];
                valores = linea.split(",");
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
            FileReader f = new FileReader("usuarios.csv");
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

                switch (categoria) {
                    case "estudiantil":
                        temporal.put(nombre, new Platos());
                        break;
                    case "ejecutivo":
                        temporal.put(nombre, new Platos());
                        break;
                }
            }
        } catch (IOException e) {
        }
        return temporal;
    }

    public static boolean agregarAdministrador() {

        return true;
    }
}
