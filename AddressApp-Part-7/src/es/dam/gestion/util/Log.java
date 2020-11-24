/**
 * 
 */
package es.dam.gestion.util;

/**
 * @author SalvioQ
 *
 */

import java.util.ArrayList;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.lang.String;

public class Log  {      // extends ArrayList<String> {

	
	// private static final long serialVersionUID = -7512395694935544681L;
	/**
	 * private LocalDateTime and Clock  
	 */
	
	public String sTimeMark, elemento;

	public LocalDateTime ldtInstant0, ldtOffset;
	public Clock clock0, clockNow;
	
	public StringBuilder StrMsg = new StringBuilder();
	public ArrayList<String> LogList = new ArrayList<String>();
	
	private final ObjectProperty<ArrayList<String>> beanLogList = new SimpleObjectProperty<>(this, "beanLogList", new ArrayList<>());
	 
    public ObjectProperty<ArrayList<String>> logListProperty()
    {
    	return beanLogList;
    }
    
    //agregar elemento
//    beanLogList.getValue().add("First name can't be empty!");
    
//    ArrayList<String> errList = ip.errorsProperty().get();
//    
//    errList.forEach((errList1) -> {
//        errMsg.append(errList1);
//    });
		 

	/**
	 * 
	 */
	Log() {
		// Initialize time marks
		ldtInstant0 = LocalDateTime.now();
		clock0 = Clock.systemUTC();
		// First log entry
		this.logAdd(":Start LOG:");
	}
	
	//@Override
	public boolean logAdd(String s){
		sTimeMark=LDTFormat(LocalDateTime.now()) + ":+ " + CLKFormat(LocalDateTime.now(clock0)) + ":";
		elemento=sTimeMark.concat(s);
		return beanLogList.getValue().add(elemento);
		
	}
	
	//@Override
	public void clear() {
		beanLogList.getValue().clear();
	}
	
	//@Override
	public boolean isEmpty() {
		return (beanLogList.getValue().size()==1?true:false);
	}
	
	public int size() {
		return beanLogList.getValue().size();
	}
	

	/** 
	 * LocalDateTime Format string utility method
	 *
	 * final DATE_PATTERN
	 * final LDT  The LocalDateTime date formatter with pattern \"yyyy.MM.dd-HH.mm.ss,SSS\"  
	 * */
	private static final String DATE_PATTERN = "yyyy.MM.dd-HH.mm.ss,SSS";
	private static final DateTimeFormatter LDT = DateTimeFormatter.ofPattern(DATE_PATTERN);
	private static final String CLOCK_PATTERN = "+HH.mm.ss,SSS";
	private static final DateTimeFormatter CLK = DateTimeFormatter.ofPattern(CLOCK_PATTERN);
	/**
     * @Returns the given LocalDateTime as a formatted String 
     * 
     * @param ldt the LocalDateTime to format or null for LocalDateTime.now()
     * @return formatted string
     */
    public static String LDTFormat(LocalDateTime ldt) {
        if (ldt == null) {
            return LDT.format(LocalDateTime.now());
        } else {
        	return LDT.format(ldt);
        }
    }
    public static String CLKFormat(LocalDateTime offset) {
        return CLK.format(offset);
    }
	
}
