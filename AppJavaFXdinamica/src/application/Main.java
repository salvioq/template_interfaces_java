package application;
		

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


import javafx.stage.Stage;

		 
public class Main extends Application {

	private String stTitulo;
	public HBox raizHBox;
	public GridPane raizGridPane;
	public Scene scene1, scene2;
	
	//	//Constructor vacío
	public Main() {
	}
	
	// Método llamado desde el framework javaFX, en la Application JavaFX para lanzar todo
	public static void main(String[] args) {
		Application.launch(args);
    }
	
	@Override
	public void init() {
		// Inicializacion de objetos tras el constructor
		stTitulo="JavaFX";
	}
	
	@Override
	public void start(Stage primaryStage) {
			// Preparacion de los componentes graficos en un contenedor tipo HBOX
			// declaraciones nodos
			// nodos Label / Button / Textfield /ChoiceBox 
            Label lbInfo = new Label("1.- Mostrando un HBox");
            lbInfo.setMinSize(150.0, 50.0);
            
            Button btAceptar = new Button("Mas info...");
            btAceptar.setMinSize(100.0, 30.0);
            
            btAceptar.setOnAction((e) ->  { 
        		Alert a = new Alert(AlertType.ERROR);
        		a.initOwner(primaryStage);
            	a.setTitle(stTitulo);
            	a.setHeaderText("HBox Alert");
            	a.setContentText("Lanzado desde el Button en el HBox.");
            	a.showAndWait();  // es modal, no hara otra cosa hasta pulsar OK
            	primaryStage.setScene(scene2); //carga en la pantalla primaryStage la escena scene2
            	primaryStage.setTitle(stTitulo + " Escena2");
    			primaryStage.show(); // no modal, muestra la aplicacion, auto "controlada"
            	} 
            );
            //contenedor raiz de nodos: HBox /  GridPane
            raizHBox = new HBox();
            raizGridPane = new GridPane();
                        
            //ajustes del HBOX
            raizHBox.setPrefWidth(200);
            raizHBox.setPrefHeight(100);
            
            raizHBox.getChildren().addAll(lbInfo, btAceptar);
            
            // O
            // declaracion de un FXMLLoader para cargar desde .FXML
            // FXMLLoader loader = new FXMLLoader();
            // loader.setLocation(AppGestion.class.getResource("formulario.fxml"));
            // AnchorPane raiz = (AnchorPane) loader.load();
            // IMPORTANTE el tipo del objeto contenedor raiz debe coincidir con el cast de loader.load()
 
            // O
            // BorderPane / StackPane /    
            
            // o
            // Preparacion de los componentes graficos en un contenedor GridPane
            Label lbInfo2 = new Label("2.- Mostrando un GridPane");
            lbInfo2.setMinSize(150.0, 50.0);
            
            
            Button btAceptar2 =  new Button("Mas info 2...");
            btAceptar2.setOnAction((e) ->  { 
        		Alert a = new Alert(AlertType.CONFIRMATION);
        		a.initOwner(primaryStage);
            	a.setTitle(stTitulo);
            	a.setHeaderText("GridPane Alert");
            	a.setContentText("Lanzado desde el Button2 en el GridPane,\n OK -> volver a scene1 HBox, Cancel -> seguir en scene2 Grid");
            	a.showAndWait();  // es modal, no hara otra cosa hasta pulsar OK
            	Optional<ButtonType> result = a.showAndWait();
            	if (result.isPresent() && result.get() == ButtonType.OK) {
            		primaryStage.setScene(scene1); //carga en la pantalla primaryStage la escena scene2
            		primaryStage.setTitle(stTitulo + " Escena1");
            		primaryStage.show(); // para refrescar la stage actual con la scene elegida
                } else { 
            		if (result.isPresent() && result.get() == ButtonType.CANCEL) {
            			// en realidad esto es un alert modal, 
            			// no haría falta recargar el scene2, ya estaba activa la scene2, se cerraría el alert y ya esta
            			primaryStage.setScene(scene2); //carga en la pantalla primaryStage la escena scene2
            			primaryStage.setTitle(stTitulo + " Escena2");
            			primaryStage.show(); // para refrescar la stage actual con la scene elegida
            		}
            	}
     		} 
            );
            
            // Preparacion de tamaños de columna del GridPane
            raizGridPane.getColumnConstraints().add(new ColumnConstraints(200)); // column 0 is 200px wide
            raizGridPane.getColumnConstraints().add(new ColumnConstraints(100)); // column 1 is 100px wide
            raizGridPane.getRowConstraints().add(new RowConstraints(50)); // row 0 is 50px height
            raizGridPane.getRowConstraints().add(new RowConstraints(30)); // row 1 is 30px wide
            
            // Places the button at the second row and second column
            // Set one constraint at a time...
            GridPane.setRowIndex(btAceptar2, 1);
            GridPane.setColumnIndex(btAceptar2, 1);
            // coloca btAceptar2 en segunda fila y segunda columna
            raizGridPane.getChildren().add(btAceptar2);

            // Places the label at the first row and first column, and occupies span of two columns
            // Sometimes is more convenient 
            // Set more than one constraint at once...
            //   GridPane.setConstraints(child, columnIndex, rowIndex, columnspan, rowspan);
            GridPane.setConstraints(lbInfo2, 0, 0, 2, 1); 
            // coloca lbInfo2 en primera fila/columna, ancho 2 columnas (span), alto 1 columna
            raizGridPane.getChildren().add(lbInfo2);	
                       
            
            // Carga contenedor raiz previamente preparado en escena: 
            // se carga HBox en la scena1
            scene1 = new Scene(raizHBox);
            // o se carga GridPane en la scena2
            scene2 = new Scene(raizGridPane);
            
            // Preparacion de la ventana primaryStage
            primaryStage.setTitle(stTitulo + "Escena1");
                     
            // se pone en ventana primaryStage la scene preferida -> scene1
            primaryStage.setScene(scene1);
            //muestra escena
			primaryStage.show(); // no modal, muestra la aplicacion, auto "controlada"
		}
    
	
	@Override
	public void stop() {
		// Acciones finales antes de Application.exit()
		Alert a = new Alert(AlertType.INFORMATION);
		a.initOwner(null);
    	a.setTitle(stTitulo);
    	a.setHeaderText("Stop Alert");
    	a.setContentText("Lanzado desde metodo stop() antes de Platform.exit() y System.exit(0).");
    	a.showAndWait();  // es modal, no hara otra cosa hasta pulsar OK
    }    
	
}
