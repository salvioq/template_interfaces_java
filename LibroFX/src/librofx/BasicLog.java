/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librofx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author SalvioQ
 */
public class BasicLog {
    /** 
    * using LDT  The LocalDateTime date formatter with pattern \"yyyy.MM.dd-HH.mm.ss,SSS : \"  
    */
    private final String DATE_PATTERN = "yyyy.MM.dd-HH.mm.ss,SSS : ";
    private final DateTimeFormatter LDT = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public String LDTformat(LocalDateTime ldt) {
            return LDT.format(LocalDateTime.now());
    }
    
     /**
     * Generating TimeLog as a ArrayList.
     * Each element added, sItem composed by sTime and sMessage 
     */
    private ArrayList<String> basicLog = new ArrayList<String>();
    private String sTime,  sItem;
    private final boolean DEBUG = true;
    
    
    //Constructor
    // First log entry  -- basicLog.size() --> 1
    public void CronoLog() {
        this.addLog(": Start Log :");
    }

    public ArrayList<String> getBasicLog() {
        return basicLog;
    }
    
    public void dumpLog(){
        System.out.println(basicLog.toString());
    }
	
    public boolean addLog(String sMensaje){
        //Time Mark     
	sTime=LDTformat(LocalDateTime.now());
        sItem = sTime.concat(sMensaje);
        if (DEBUG) {
            System.out.println(sItem);
        }
        return basicLog.add(sItem);
    }   
}
