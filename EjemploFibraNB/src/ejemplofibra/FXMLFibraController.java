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
//ObservableList<String> tipospeed = 
//	FXCollections.<String>observableArrayList("2-Mbit", 
//                        "5-Mbit",
//                        "10-Mbit",
//                        "20-Mbit",
//                        "50-Mbit",
//                        "100-Mbit");
                
    
    @FXML
    private Button closeBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    //FXCollections.<String>observableArrayList<("2-Mbit", "5-Mbit", "10-Mbit", "20-Mbit", "50-Mbit","100-Mbit")
    @FXML
    private ChoiceBox<ObservableList<String>> speed;
    @FXML
    private ChoiceBox<ObservableList<String>> bandwidth;
    @FXML
    private ChoiceBox<ObservableList<String>> ContractDuration;
   
  
    
    
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
        // cargar los items del choice box.
         //        speed.itemsProperty(). --- 
        
        firstName.textProperty().bindBidirectional(ip.firstNameProperty());
        lastName.textProperty().bindBidirectional(ip.lastNameProperty());
        address.textProperty().bindBidirectional(ip.addressProperty());
//        speed.itemsProperty().bindBidirectional(ip.speedProperty());
//        bandwidth.itemsProperty().bindBidirectional(ip.bandwidthProperty());
//        ContractDuration.itemsProperty().bindBidirectional(ip.contractDurationProperty());
        
        
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
        Platform.exit();
    }

    @FXML
    private void accionLImpiar(ActionEvent event) {
        
        
        
        speed.getSelectionModel().clearSelection();
        bandwidth.getSelectionModel().clearSelection();
        ContractDuration.getSelectionModel().clearSelection();
        firstName.textProperty().setValue("");
        lastName.textProperty().setValue("");
        address.textProperty().setValue("");
        
        
    }
}