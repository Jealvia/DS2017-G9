/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import inicio_sesion.InicioSesion;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Julio Alvia
 */
public class Proyecto extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        InicioSesion root=new InicioSesion(primaryStage);
        root.menuPrincipal(primaryStage);
        Scene scene=new Scene(root.getRoot(),500,300); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
