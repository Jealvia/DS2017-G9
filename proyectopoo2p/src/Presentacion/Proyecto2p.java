/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.MarcadorModelado;
import Modelo.MarcadorModeladoWraperClass;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Jonathan Quintana
 */
public class Proyecto2p extends Application {
    //Campos de la clase
    private final static String XML_OUTPUT_FILE="marcadores.xml";    
    private ArrayList<MarcadorModelado> listaMarcadormodelo;
    
   @Override
    public void start(Stage primaryStage) throws JAXBException, IOException {
        MarcadorModeladoWraperClass a=loadData();
        if(a==null){
            listaMarcadormodelo=new ArrayList<MarcadorModelado>();
        }else if(a.getListaMarcador()!=null){
            listaMarcadormodelo=(ArrayList)a.getListaMarcador();
        }else{
            listaMarcadormodelo=new ArrayList<MarcadorModelado>();
        }
        
        
        
        PaneOrganizer organizer = new PaneOrganizer(listaMarcadormodelo,primaryStage);
        
 
        
        Scene scene = new Scene(organizer.getRoot(), 1182.5,700);
        
        primaryStage.setTitle("Bienvenidos a Google Maps versión Espol");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    @Override
    public void stop() {
        List<MarcadorModelado> ab ;
        ab=listaMarcadormodelo;
        System.out.println(ab.size());
        MarcadorModeladoWraperClass cw = new MarcadorModeladoWraperClass();
        cw.setListaMarcador(ab);
        try{saveData(cw);}catch(JAXBException | IOException e){
            System.out.println("error "+e.getMessage());
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)   {
        launch(args);
        
    }
    //marshaling
    /**
     * Guarda los MaracadoreModelo en un archivo xml
     * @param cw Wraper que contiene la lista de MardcadorModelo
     * @throws JAXBException
     * @throws IOException 
     */
    private static void saveData(MarcadorModeladoWraperClass cw) throws JAXBException, IOException{
        JAXBContext context= JAXBContext.newInstance(new Class[] {MarcadorModeladoWraperClass.class, MarcadorModelado.class});
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Writer w= null;
        try{
            w = new FileWriter(XML_OUTPUT_FILE);
            m.marshal(cw, w);
        }catch(IOException e){
            System.out.println("Error al leer el archivo");
        }finally{
            try{
                w.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//Cierre del metodo
    
    /**
     * Metoto que la imformacion de los marcadores un archivo xml
     * @return lista de MarcadoresModelo
     */
    private static MarcadorModeladoWraperClass loadData(){
        FileReader r= null;
        try{
            //Creamos nuevo contexto con el metodo newInstance
            //Le pasamos al metodo la clase con la cuela vamos a trabajar
            //la clase debe estar anotada con JAXB anotaciones
            JAXBContext context= JAXBContext.newInstance(MarcadorModeladoWraperClass.class);

            //Creamo un objeto unmarshaller
            Unmarshaller u = context.createUnmarshaller();

            //creamos objetos FileReader para leer en el archivo
            r = new FileReader(XML_OUTPUT_FILE);
            
            //guardamos la informaciin del cliente en el archivo
            MarcadorModeladoWraperClass e=(MarcadorModeladoWraperClass)u.unmarshal(r);
            
                       
            return e;
        }catch(IOException e1){
            System.out.println("Error al escribir en el archivo "+e1.getMessage());
        }catch(JAXBException e2){
            System.out.println("Error al leer el archivo"+e2.getMessage());
        }finally{
            //cerramos el archivo
            try{
                r.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }//Cierre del metodo
    
}


