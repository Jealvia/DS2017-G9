/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * En esta clse se encuentran definidas las categorias de los diferntes tipos de marcadores, cada enum contiene la direccion 
 * de su icono correspondiente
 * @author grupopoo
 */
public enum Categoria {
    
    //Categorias
    COMEDOR("DataAccess/comedor.png","Comedor"),
    BANOS("DataAccess/banos.png", "Baños"),
    COPIADORAS("DataAccess/copiadoras.png","Copiadoras"),
    LABORATORIOS("DataAccess/laboratorio.png","Laboratorios"),
    EDIFICIOSADMINISTRATIVOS("DataAccess/administrativos.png","Edificios administrativos"),
    AULAS("DataAccess/aulas.png","Aulas"),
    RECREACION("DataAccess/recreacion.png","Recreación");
    //Campos de la clase
    private final String imagen;
    private final String tipo;
    
    /**
     * Constructor de la categoria
     * @param imagen El parámetro imagen contiene la direccion del icono de la categoria dentro de la caprpeta del proyecto
     * @param tipo El parametro tipo contiene una cadena de caracteres con el nombre de la categoria
     */
    private Categoria(String imagen, String tipo) {
        this.imagen = imagen;
        this.tipo = tipo;
    }//Cierre del constructor
    
    /**
     * Método que devuelve el nombre de la categoria 
     * @return El nombre de la categoria
     */
    public String getTipo() {
        return tipo;
    }
        
    /**
     * Método que devuelve la direccion del icono de la categoria
     * @return La direccion del icono de la categoria
     */
    public String getImagen() {
        return imagen;
    }

    
    
    
    
}


