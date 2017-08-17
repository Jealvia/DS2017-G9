/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public abstract class PaneInterfaceBase implements Pane_Interface<Object> {

    public static BorderPane root;

    public PaneInterfaceBase() {
        root = new BorderPane();
    }

    public void ConstruirPanePrueba(Stage primaryStage) {
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
