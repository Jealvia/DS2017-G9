/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaParte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Julio Alvia
 */

public class NuevaMalicia extends Restaurante{

    public NuevaMalicia(String nombre, String descripcion, String telefono, boolean compraOnline) {
        super(nombre, descripcion, telefono, compraOnline);
    }

 
    @Override
    public boolean setOnline() {
        return false;
    }

    
}
