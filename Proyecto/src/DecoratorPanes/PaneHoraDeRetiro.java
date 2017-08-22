/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import SegundaParte.Platos;
import java.util.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class PaneHoraDeRetiro {
    private  BorderPane contenedor;
    private Label fechaActual;
    private Button siguiente;
    private String eleccion;
    
    
    //PARA PRESENTAR LISTA DE OPCIONES
    static ObservableList<String> tiposPlatos;
    static ListView<String> listaPlatos;

    public PaneHoraDeRetiro(Stage primaryStage) {
        this.contenedor = new BorderPane();
        this.siguiente=new Button("Siguiente");
        eventoBotonSiguiente(primaryStage);
    }

    public  BorderPane getContenedor() {
        return contenedor;
    }

    public void setContenedor(BorderPane contenedor) {
        this.contenedor = contenedor;
    }
    public String horaActual(){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();
        String dia = Integer.toString(c2.get(Calendar.DATE));
        String  mes = Integer.toString(c2.get(Calendar.MONTH));
        String annio = Integer.toString(c2.get(Calendar.YEAR));
        return "fecha Limite: Hoy "+dia+" / "+mes+" / "+annio;
    }
    public ArrayList<String> horariosDisponibles(int horaInicio,int horaFin){
        ArrayList<String> horarios=new ArrayList<>();
        int aumentador=30;
        for(int i=0;i<8;i++){
            if(aumentador==60){
                horaInicio+=1;
                horarios.add((horaInicio-1)+"h"+(aumentador-30)+" - "+(horaInicio)+"h00");
                aumentador-=30;
            }else{
                horarios.add(horaInicio+"h00"+" - "+horaInicio+"h"+aumentador);
                aumentador+=30;
            }
           
        }   
        return horarios;
    }
    
    public void listaPlatos(ArrayList<Platos> lista, Stage primaryStage,double valor) {
        
        VBox vbox = new VBox(10);
        primaryStage.setTitle("HORARIO DE RETIRO DE ALMUERZO");
        primaryStage.setResizable(false);
        
        ObservableList<String> names = FXCollections.observableArrayList(horariosDisponibles(11,15));
        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<String>(data);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);
        data.add("Double Click to Select Value");
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(names));
        listView.setPrefHeight(50);
        this.fechaActual=new Label(horaActual());
        
        vbox.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: DARKCYAN;");
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(fechaActual,listView,siguiente);
        contenedor.setCenter(vbox);
        listView.setOnMouseClicked((MouseEvent me) -> {
            this.setEleccion(names.get(listView.getSelectionModel().getSelectedIndex())+";"+valor);
        });

    }
    
    public void eventoBotonSiguiente(Stage primaryStage){
        siguiente.setOnAction((ActionEvent event) -> {
            //AQUI SE CORRERA EL PANE DE ELEGIR FORMAS DE PAGO
            
            PaneFormasDePago pago=new PaneFormasDePago(primaryStage);
            pago.pantallaFormasDePago(primaryStage,this.getEleccion());
        });
    }

    public void pantallaListaPlatos(Stage primaryStage) {
        Scene escena = new Scene(contenedor, 300, 300);
        primaryStage.setScene(escena);
        primaryStage.show();
        
    }

    public String getEleccion() {
        return eleccion;
    }

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }
    
    
}



