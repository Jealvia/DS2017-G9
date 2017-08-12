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
public abstract class PaneDecorator implements PanE{
    PanE pane;

    public PaneDecorator() {
    }

    public PaneDecorator(PanE pane) {
        this.pane = pane;
    }

    public PanE getPane() {
        return pane;
    }

    public void setPane(PanE pane) {
        this.pane = pane;
    }
   
}
