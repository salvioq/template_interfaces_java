package es.dam.gestion.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import es.dam.gestion.modelo.Alumno;

import java.time.Period;

/**
 * Helper functions for handling dates.
 * 
 * @author Marco Jakob
 */
public class FechaUtil {

    /** The date pattern that is used for conversion. Change as you wish. */
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /** The date formatter. */
    private static final DateTimeFormatter DATE_FORMATTER = 
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Returns the given date as a well formatted String. The above defined 
     * {@link FechaUtil#DATE_PATTERN} is used.
     * 
     * @param date the date to be returned as a string
     * @return formatted string
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Converts a String in the format of the defined {@link FechaUtil#DATE_PATTERN} 
     * to a {@link LocalDate} object.
     * 
     * Returns null if the String could not be converted.
     * 
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Checks the String whether it is a valid date.
     * 
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return FechaUtil.parse(dateString) != null;
    }
    
    /**
     * Calcula el periodo entre dos fechas f1 y f2
     * 
     * @param f1, f2
     * @return String con la diferencia en años y meses "x años, y meses"
     */

    public  String getEdad(Alumno a) {
    	return FechaUtil.periodoFechas(a.getBirthday(), LocalDate.now());
    }
    public static String periodoFechas(LocalDate f1, LocalDate f2) {
        Period p = Period.between(f1, f2);
        return (p.getYears()+ " años, " + p.getMonths() + " meses"); 
    }
}