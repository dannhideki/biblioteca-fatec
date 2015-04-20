package br.gov.sp.centropaulasouza.biblioteca.utils.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author hideki
 */
public class ManipulateDate {
 
    private static final String[] monthsStrings = {"Janeiro", "Fevereiro", "Março",
            "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
            "Novembro", "Dezembro" };
 
    private static final Map<String, Object> days;
    static {
        days = new LinkedHashMap<>();
        for (int i = 1; i <= 31; i++) {
            days.put(String.valueOf(i), String.valueOf(i));
        }
    }
 
    private static final Map<String, Object> months;
    static {
        months = new LinkedHashMap<>();
        for (int i = 0; i < 12; i++) {
            months.put(monthsStrings[i], String.valueOf(i+1));
        }
    }
 
    private static final Map<String, Object> years;
    private static final Calendar calendar = GregorianCalendar.getInstance();
    static {
        years = new LinkedHashMap<>();
        int year = calendar.get(Calendar.YEAR);
        for (int i = year - 16; i >= year - 80; i--)
            years.put(String.valueOf(i), String.valueOf(i));
    }
 
    public static Map<String, Object> getDays() {
        return days;
    }
 
    public static Map<String, Object> getMonths() {
        return months;
    }
 
    public static Map<String, Object> getYears() {
        return years;
    }
     
    public static Date getDate(int year, int month, int day){
        return (new GregorianCalendar(year, month - 1, day)).getTime();
    } 
 
}
