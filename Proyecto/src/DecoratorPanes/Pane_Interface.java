/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import java.util.ArrayList;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public interface Pane_Interface<E> {
    public void ConstruirPane(Stage primaryStage,ArrayList<E> lista);
}
