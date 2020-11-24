/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofibra;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import ejemplofibra.InternetPacket;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * FXML Controller class
 *
 * @author squiralte
 */
public class FXMLFibraController implements Initializable {
    ObservableList<String> olspeed, olbandwidth, olcontractduration;
    
    @FXML
    private Button closeBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    
    @FXML
    private ChoiceBox<String> speed;
    @FXML
    private ChoiceBox<String> bandwidth;
    @FXML
    private ChoiceBox<String> contractDuration;
   
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;

    InternetPacket ip;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ip= new InternetPacket();
        // Create the ObservableLists for the ListViews
        olspeed = FXCollections.<String>observableArrayList("2-Mbit", 
                        "5-Mbit",
                        "10-Mbit",
                        "20-Mbit",
                        "50-Mbit",
                        "100-Mbit");
        olbandwidth = FXCollections.<String>observableArrayList("1-GB",
                "5-GB",
                "10-GB",
                "100-GB",
                "FLAT");
        olcontractduration = FXCollections.<String>observableArrayList("1 Year", "2 Years");
    
// assign the FXCollection<String>observableList
        //
//	speed = new ChoiceBox<>(olspeed);
//      bandwidth = new ChoiceBox<>(olbandwidth);
//      contractDuration = new ChoiceBox<>(olcontractduration);
//        speed.getItems().clear();
//        speed.getItems().addAll(olspeed);
//        bandwidth.getItems().clear();
//        bandwidth.getItems().addAll(olbandwidth);
//        contractDuration.getItems().clear();
//        contractDuration.getItems().addAll(olcontractduration);
        
		
        // Select the first season from the list
        speed.getSelectionModel().selectFirst();

        // cargar los items del choice box.
        
        firstName.textProperty().bindBidirectional(ip.firstNameProperty());
        lastName.textProperty().bindBidirectional(ip.lastNameProperty());
        address.textProperty().bindBidirectional(ip.addressProperty());
//        speed.itemsProperty().bindBidirectional(ip.speedProperty());
//        bandwidth.itemsProperty().bindBidirectional(ip.bandwidthProperty());
//        contractDuration.itemsProperty().bindBidirectional(ip.contractDurationProperty());
        
        
    }    

    @FXML
    private void saveChanges(ActionEvent event) {
         if(ip.isValid()){
            // 
            System.out.println(ip.toString());
            //
            ip.save();
        }else
    {
        StringBuilder errMsg = new StringBuilder();
 
        ArrayList<String> errList = ip.errorsProperty().get();
 
            errList.forEach((errList1) -> {
                errMsg.append(errList1);
            });
 
        System.out.println(errMsg);
    }
   }

    @FXML
    private void accionCerrar(ActionEvent event) {
        // guardar antes de salir
    	ArrayList<InternetPacket> lista = ip.getPacketsSold();
    	lista.forEach( paquete -> { System.out.println(paquete.toString()); });
    	
    	
//    	Alert a = new Alert(AlertType.INFORMATION);
//		a.initOwner(null);
//    	a.setTitle("Listado");
//    	a.setHeaderText("Listado Packetes incluidos");
//    	lista.forEach( paquete -> { System.out.println(paquete.toString()); });
//    	a.setContentText(lista.t);
//    	a.showAndWait();  // es modal, no hara otra cosa hasta pulsar OK
        // Platform.exit();
    }
    p
    
    @FXML
    private void accionLImpiar(ActionEvent event) {
        
        
        
        speed.getSelectionModel().clearSelection();
        bandwidth.getSelectionModel().clearSelection();
        contractDuration.getSelectionModel().clearSelection();
        firstName.textProperty().setValue("");
        lastName.textProperty().setValue("");
        address.textProperty().setValue("");
        
        
    }
}