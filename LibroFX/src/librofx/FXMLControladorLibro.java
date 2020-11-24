/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
//warnings por ser imports del mismo package
import librofx.BasicLog.*;
import librofx.Libro;

/**
 *
 * @author SalvioQ
 */
public class FXMLControladorLibro implements Initializable {
    private BasicLog log = new BasicLog();
    
    @FXML
    private Button btNuevo;
    @FXML
    private Button btLimpiar;
    @FXML
    private Button btListar;
    @FXML
    private Label lbEstado;
    @FXML
    private MenuItem mnListar;
    @FXML
    private MenuItem mnCerrar;
    @FXML
    private MenuItem mnAcercaDe;
    @FXML
    private MenuItem mnLimpiar;
    
    private Libro modelo_libro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        log.addLog("Iniciando");
        modelo_libro = new Libro();
            // TODO
            // vincular los bindings entre modelo_libro y los componentes graficos
            // o cargarlos manualmente
            
    }    

    @FXML
    private void accionNuevo(ActionEvent event) {
        log.addLog(event.getSource().toString());
        lbEstado.setText("Introduzca datos...");
    }

    @FXML
    private void accionLimpiar(ActionEvent event) {
        log.addLog(event.getSource().toString());
        lbEstado.setText("Limpiando datos...");
    }

    @FXML
    private void accionListar(ActionEvent event) {
        log.addLog(event.getSource().toString());
        lbEstado.setText("Mostrando listado ...");
    }

    @FXML
    private void accionMenuAcercaDe(ActionEvent event) {
        log.addLog(event.getSource().toString());
        lbEstado.setText("Menu Acerca de...");
    }

    @FXML
    private void accionCerrar(ActionEvent event) {
        log.addLog(event.getSource().toString());
        lbEstado.setText("...Cerrando...");
        log.dumpLog();
        Platform.exit();
    }   
}
