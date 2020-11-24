package es.dam.gestion.controlador;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

import es.dam.gestion.AppGestion;
import es.dam.gestion.modelo.Alumno;
import es.dam.gestion.util.FechaUtil;


public class AlumnoVistaController {
    @FXML
    private TableView<Alumno> personTable;
    @FXML
    private TableColumn<Alumno, String> firstNameColumn;
    @FXML
    private TableColumn<Alumno, String> lastNameColumn;
    @FXML
    private TableColumn<Alumno,String> ageColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label ageLabel;

    // Reference to the main application.
    private AppGestion mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public AlumnoVistaController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        // llenar ageColumn
        ageColumn.setCellValueFactory(celldata -> celldata.getValue().ageProperty());

      
        
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(AppGestion mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param alumno the person or null
     */
    private void showPersonDetails(Alumno alumno) {
        if (alumno != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(alumno.getFirstName());
            lastNameLabel.setText(alumno.getLastName());
            streetLabel.setText(alumno.getStreet());
            postalCodeLabel.setText(Integer.toString(alumno.getPostalCode()));
            cityLabel.setText(alumno.getCity());
            birthdayLabel.setText(FechaUtil.format(alumno.getBirthday()));
            ageLabel.setText(getEdad(alumno));
        } else {
            // alumno is null, remove all the text.
            firstNameLabel.setText(""); //$NON-NLS-1$
            lastNameLabel.setText(""); //$NON-NLS-1$
            streetLabel.setText(""); //$NON-NLS-1$
            postalCodeLabel.setText(""); //$NON-NLS-1$
            cityLabel.setText(""); //$NON-NLS-1$
            birthdayLabel.setText(""); //$NON-NLS-1$
            ageLabel.setText(""); //$NON-NLS-1$
            }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Alumno Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Alumno tempPerson = new Alumno();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Alumno selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Alumno Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
    
     
    /**
     * Returns calculated Age from Alumno'sBirthday minus now(),Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param a (Alumno)
     * @return the String containing age "x años, y meses"
     */

    public  String getEdad(Alumno a) {
    	return FechaUtil.periodoFechas(a.getBirthday(), LocalDate.now());
    }
}