/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofibra;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author squiralte
 */
public class EjemploFibra extends Application {
    private GridPane raiz;
    
    @Override
    public void start(Stage primaryStage) {
        try{
            URL fxmlUrl = getClass().getClassLoader().getResource("ejemplofibra/FXMLFibra.fxml");
            raiz = FXMLLoader.<GridPane>load(fxmlUrl);
            Scene scene = new Scene(raiz, 300, 250);
        
            primaryStage.setTitle("FIBRA OPTICA");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
             
    }
     @Override
    public void stop() {
        System.out.println("Cerrando...");
        
    }
          

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
