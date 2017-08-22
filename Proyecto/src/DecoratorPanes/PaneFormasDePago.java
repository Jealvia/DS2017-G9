/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecoratorPanes;

import SegundaParte.Carnet;
import SegundaParte.Pago;
import SegundaParte.PagoCarnet;
import SegundaParte.PagoTarjetaCredito;
import SegundaParte.Platos;
import SegundaParte.TarjetaCredito;
import java.util.ArrayList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author jimmy
 */
public class PaneFormasDePago {

    private Label LabeltarjetaCredito;
    private Label LabelCarnetInteligente;
    private Label labelTitulo;
    private Label LabelNumero;
    private Label LabelCVC;
    private Label labelFechaExpiracion;
    private Label LabelUsuario;
    private Label LabelContraseña;
    private Button pagarPorTarjeta;
    private Button pagarPorCarnet;
    public static BorderPane root5;
    private Image imgLoadFondo3;
    private ImageView imgFondo3;
    private TextField txtUsuario;
    private PasswordField ingreso_Contraseña;
    private TextField txtCVC;
    private TextField txtNumero;
    private TextField txtFechaExpiracion;
    private VBox PaneObjetos1;
    private VBox PaneObjetos;
    private VBox PaneObjetos2;
    private double valorPagar;

    public PaneFormasDePago(Stage primaryStage) {
        primaryStage.setTitle("FORMAS DE PAGO");
        primaryStage.setResizable(false);
        root5 = new BorderPane();
        LabeltarjetaCredito = new Label("Tarjeta de Credito");
        LabelCarnetInteligente = new Label("Carnet Inteligente");
        labelTitulo = new Label("******PAGOS******");
        LabelNumero = new Label("Numero:");
        LabelCVC = new Label("CVC:");
        labelFechaExpiracion = new Label("Fecha de expiracion: ");
        LabelUsuario = new Label("Numero de matricula:");
        LabelContraseña = new Label("Contraseña: ");
        txtNumero = new TextField();
        txtCVC = new TextField();
        txtFechaExpiracion = new TextField();
        txtUsuario = new TextField();
        ingreso_Contraseña = new PasswordField();
        ingreso_Contraseña.setPromptText("Your password");
        imgLoadFondo3 = new Image("/imagenes/fondo9.jpg");
        imgFondo3 = new ImageView(imgLoadFondo3);
        imgFondo3.setFitHeight(520);
        imgFondo3.setFitWidth(500);
        pagarPorTarjeta = new Button("Pagar Tarjeta");
        pagarPorCarnet = new Button("Pagar");
        PaneObjetos1 = new VBox(1, LabeltarjetaCredito, LabelNumero, txtNumero, LabelCVC, txtCVC, labelFechaExpiracion, txtFechaExpiracion, pagarPorTarjeta);
        PaneObjetos2 = new VBox(1, LabelCarnetInteligente, LabelUsuario, txtUsuario, LabelContraseña, ingreso_Contraseña, pagarPorCarnet);
        root5.getChildren().addAll(imgFondo3);

    }
    
    // metodo que me obtiene el root1
    public BorderPane getRoot() {
        return root5;
    }

    public void diseñoVentanaFormasDePago() {

        PaneObjetos1.setAlignment(Pos.CENTER_LEFT);
        PaneObjetos1.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: yellow;");

        PaneObjetos2.setAlignment(Pos.CENTER_LEFT);
        PaneObjetos2.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 8;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        PaneObjetos = new VBox(50, labelTitulo, PaneObjetos2, PaneObjetos1);
        PaneObjetos.setAlignment(Pos.TOP_CENTER);

        root5.setCenter(PaneObjetos);
    }

    public void eventoBotonPagarPorTarjeta() {
        
    }

    public void eventoBotonPagarPorCarnet() {
        
    }
    
    
    public void pantallaFormasDePago(Stage primaryStage,String eleccion) {
        String[] arreglo=eleccion.split(";");
        PaneFormasDePago root = new PaneFormasDePago(primaryStage);
        Scene scene = new Scene(root.getRoot(), 500, 520);
        primaryStage.setScene(scene);
        diseñoVentanaFormasDePago();
        primaryStage.show();
        
        pagarPorCarnet.setOnAction((ActionEvent event) -> {
            System.out.println("Valor a pagar"+valorPagar);
            Carnet carnet=new Carnet();
            Pago pago = new Pago(new PagoCarnet());
            boolean resultado = pago.ejecutarPago(Double.parseDouble(arreglo[1]));
            if(txtUsuario==null||ingreso_Contraseña==null){
                JOptionPane.showMessageDialog(null, "Faltan llenar campos", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
            }else if(!txtUsuario.getText().equals(carnet.getNumeroMatricula())){
                JOptionPane.showMessageDialog(null, "Numero de matricula inexistente", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
            }else if(!ingreso_Contraseña.getText().equals(carnet.getContraseña())){
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
            }else if(carnet.getSaldo()+ valorPagar > carnet.getMonto()){
                JOptionPane.showMessageDialog(null, "Saldo insuficiente", "ERROR", JOptionPane.WARNING_MESSAGE); 
            }else {
                carnet.setSaldo(carnet.getSaldo()+valorPagar);
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente\n Hora: "+arreglo[0]+"\n Saldo restante:" +carnet.getSaldo()+"");
                PaneOrganizeCliente.pantallaCliente(primaryStage);
                
                
            }
        });
        pagarPorTarjeta.setOnAction((ActionEvent event) -> {
            System.out.println("hola" + valorPagar);
            TarjetaCredito tarjeta=new TarjetaCredito();
            Pago pago = new Pago(new PagoTarjetaCredito());
            boolean resultado = pago.ejecutarPago(Double.parseDouble(arreglo[1]));
            if(txtNumero==null||txtCVC==null||txtFechaExpiracion==null){
                JOptionPane.showMessageDialog(null, "Faltan llenar campos", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
            }else if(!txtCVC.getText().equals(tarjeta.getCVC())){
                JOptionPane.showMessageDialog(null, "CVC incorrecto", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
            }else if(!txtNumero.getText().equals(tarjeta.getFechaExpiracion())){
                JOptionPane.showMessageDialog(null, "Numeros incorrectos", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
            }else if(!txtFechaExpiracion.getText().equals(tarjeta.getNumeros())){
                JOptionPane.showMessageDialog(null, "Fecha incorrecta", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente\n Hora: "+arreglo[0]+"\n");
                PaneOrganizeCliente.pantallaCliente(primaryStage);
                
            } 
            //AQUI SE MOSTRARA UN MENSAJE DE QUE SE A REALIZADO LA COMPRA PARA ESTO FALTA
            //Una vez aprobado y procesado el pago,
            //Se le mostrará al usuario el número de orden
        });
        
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

}
