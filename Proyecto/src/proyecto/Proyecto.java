package proyecto;
import Modelo.InicioSesion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Proyecto extends Application{
    public static void main(String[] args) {
         launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        InicioSesion root=new InicioSesion(primaryStage);
        root.menuPrincipal(primaryStage);
        Scene scene=new Scene(root.getRoot(),300,400); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}