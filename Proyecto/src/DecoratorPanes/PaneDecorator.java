/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

/**
 *
 * @author jimmy
 */
public abstract class PaneDecorator {
    
    Pane_Interface<Object> pane;
    public PaneDecorator(Pane_Interface pane) {
        this.pane = pane;
    }

    public Pane_Interface<Object> getPane() {
        return pane;
    }

    public void setPane(Pane_Interface<Object> pane) {
        this.pane = pane;
    }

    
    
}
