package es.dam.gestion.modelo;

import java.time.LocalDate;
// import es.dam.gestion.util.FechaUtil;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import es.dam.gestion.util.FechaUtil;
import es.dam.gestion.util.LocalDateXMLAdaptador;

/**
 * Model class for a Alumno.
 *
 * @author Marco Jakob
 */
public class Alumno {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty age;

    /**
     * Default constructor.
     */
    public Alumno() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Alumno(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 2, 21));
        this.age = new SimpleStringProperty(
                FechaUtil.periodoFechas(LocalDate.of(2000, 2, 3), 
                                            LocalDate.now()));
    }

    
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    //property invocada firstName
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    //property lastName
    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }
    // property streetProperty
    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    @XmlJavaTypeAdapter(LocalDateXMLAdaptador.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
        this.age.set(FechaUtil.periodoFechas(birthday, LocalDate.now()));
    }

    //property  birthdayProperty
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
    
    public void setAge(String s) {
    	// nothing to do with s, 
    	// recalculate age from birthday to now
    	this.age.set(FechaUtil.periodoFechas(birthday.get(), LocalDate.now()));
    }
    
    public String getAge() {
    	// recalculate age from birthday to now
        this.age.set(FechaUtil.periodoFechas(birthday.get(), LocalDate.now()));
        return age.get();   	
    }
    
    //property  ageProperty
    public StringProperty ageProperty() {
    	// recalculate age from birthday to now
        this.age.set(FechaUtil.periodoFechas(birthday.get(), LocalDate.now()));
        return age;
    }
    

}