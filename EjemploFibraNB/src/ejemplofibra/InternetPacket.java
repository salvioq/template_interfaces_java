/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofibra;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
 
public class InternetPacket {
    private final StringProperty speed = new SimpleStringProperty();
    private final StringProperty bandwidth = new SimpleStringProperty();
    private final StringProperty contractDuration = new SimpleStringProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    public static List<InternetPacket> packetsSold = new ArrayList<InternetPacket>();
    private static int idC = 0;
     
     
     
    public InternetPacket(){
    }
     
    public InternetPacket(String speed,String bandwidth, String contractDuration, String firstName, String lastName, String address){
         
        this.speed.set(speed);
        this.bandwidth.set(bandwidth);
        this.contractDuration.set(contractDuration);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
        this.id.set(idC++);
         
    }
     
    public StringProperty speedProperty(){
        return speed;
    }
    public String getSpeed(){
        return speed.get();
    }
    public void setSpeed(String speed){
        this.speed.set(speed);
    }
    public StringProperty bandwidthProperty(){
        return bandwidth;
    }
    public String getBandwidth(){
        return bandwidth.get();
    }
    public void setBandwidth(String bandwidth){
        this.bandwidth.set(bandwidth);
    }
    public StringProperty addressProperty(){
        return address;
    }
    public String getAddress(){
        return address.get();
    }
    public void setAddress(String address){
        this.address.set(address);
    }
    public StringProperty contractDurationProperty(){
        return contractDuration;
    }
    public String getContractDuration(){
        return contractDuration.get();
    }
    public void setContractDuration(String contractDuration){
        this.contractDuration.set(contractDuration);
    }
    public StringProperty firstNameProperty(){
        return firstName;
    }
    public String getFirstName(){
        return firstName.get();
    }
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    public StringProperty lastNameProperty(){
        return lastName;
    }
    public String getLastName(){
        return lastName.get();
    }
    public void setlastName(String lastName){
        this.lastName.set(lastName);
    }
     
    @Override
    public String toString(){
        return "Id: " + String.valueOf(id.get())+ 
                "\nFirst Name: " + firstName.get() + 
                "\nLast Name: " + lastName.get() + 
                "\nAddress: " + address.get() + 
                "\nContract Duration: " + contractDuration.get() + 
                "\nSpeed: " + speed.get() + 
                "\nBandwidth: " + bandwidth.get();
    }
     
    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());
 
    public ObjectProperty<ArrayList<String>> errorsProperty()
    {
    return errorList;
    }
     
    public boolean isValid()
    {
    boolean isValid = true;
 
    if(firstName.get() != null && firstName.get().equals(""))
    {
        errorList.getValue().add("First name can't be empty!");
        isValid = false;
    }
    if(lastName.get().equals(""))
    {
        errorList.getValue().add("Last name can't be empty!");
        isValid = false;
    }
    if(address.get().equals(""))
    {
        errorList.getValue().add("Address can't be empty!");
        isValid = false;
    }
//    if(contractDuration.get().equals(""))
//    {
//        errorList.getValue().add("Contract duration can't be empty!");
//        isValid = false;
//    }
//        if(speed.get().equals(""))
//    {
//        errorList.getValue().add("Speed can't be empty!");
//        isValid = false;
//    }
//        if(bandwidth.get().equals(""))
//    {
//        errorList.getValue().add("Bandwidth can't be empty!");
//        isValid = false;
//    }
 
    return isValid;
    }
    public boolean save()
    {
    if(isValid())
    {
        packetsSold.add(this);
        return true;
    }
 
    return false;
    }
     
}
