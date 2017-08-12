/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package SegundaParte;
 

 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
 

 
/**
 *
 * @author Julio Alvia
 */
 
public class Almuerzo {

    private ArrayList<Platos> listaPlatos;

    public void leerPlatos() {
        String linea;
        try {
            FileReader f = new FileReader("platos.csv");
            BufferedReader br = new BufferedReader(f);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                //(String nombre, String descripcion, String ingredientes, String tipo, String servido, Categoria categoria)
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
                Platos platos=new Platos(nombre,descripcion,ingredientes,tipo,servido,categoria) ;
                this.listaPlatos.add(platos);
            }
        } catch (IOException e) {
        }
    }


 
    
 
}
 