package DecoratorPanes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import static MenuBarAsistente.PaneOrganizaAsistente.root2;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneAlmuerzo {

    public static BorderPane root3;
    private Image imgLoadFondo3;
    private ImageView imgFondo3;

    public PaneAlmuerzo(Stage primaryStage) {
        imgLoadFondo3 = new Image("/imagenes/fondo3.jpg");
        imgFondo3 = new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(500);
        imgFondo3.setFitWidth(800);
        root3 = new BorderPane();
        root3.getChildren().add(imgFondo3);
    }

    // metodo que me obtiene el root1
    public BorderPane getRoot() {
        return root3;
    }

    public static void pantallaAdministrador(Stage primaryStage) {
        PaneAlmuerzo root3 = new PaneAlmuerzo(primaryStage);
        Scene scene = new Scene(root3.getRoot(), 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
