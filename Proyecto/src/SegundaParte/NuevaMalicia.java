/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Julio Alvia
 */

public class NuevaMalicia extends Restaurante{

    
    @Override
    public void agregarDetalles() {
        String archivoPlatos = "platos_"+this.getNombre()+".csv";
        this.setArchivoPlatos(new File(archivoPlatos));
        String archivoAsistentes = "asistentes_"+this.getNombre()+".csv";
        this.setArchivoAsistentes(new File(archivoAsistentes));
    }

    @Override
    public void llenarListaPlatos() {
        String linea;
        try {
            FileReader f = new FileReader(this.getArchivoPlatos().getName());
            BufferedReader br = new BufferedReader(f);
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
                String ingredientes = valores[5].trim();
                this.getListaPlatos().add(new Platos(nombre,descripcion,ingredientes,tipo,servido,categoria));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean setOnline() {
        return false;
    }

    @Override
    public void llenarListaAsistentes() {
        String linea;
        try {
            FileReader f = new FileReader(this.getArchivoAsistentes().getName());
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String valores[];
                valores = linea.split(";");
                String nombre = valores[0].trim();
                String identificacion = valores[1].trim();
                String contraseña = valores[2].trim();
                this.getListaAsistentes().add(new Asistente(nombre, identificacion, contraseña));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
