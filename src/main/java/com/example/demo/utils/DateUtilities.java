/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.utils;


import com.example.demo.exceptions.BusinessException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class DateUtilities {

    public static Date convertLocalDateTime(Object localDateTime, String pattern) {

        Date convertedDate = null;

        if ((localDateTime instanceof LocalDate) || (localDateTime instanceof LocalDateTime)) {

            String datePattern = (pattern != null && !pattern.equals("")) ? pattern : "yyyy-MM-dd";
            SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

            try {

                dateFormatter.parse(localDateTime.toString());

                convertedDate = dateFormatter.parse(localDateTime.toString());
            } catch (ParseException ex) {
                Logger.getLogger(DateUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return convertedDate;
    }

    public static Date convertLocalDateTime(Object localDateTime) {
        return convertLocalDateTime(localDateTime, null);
    }

    public static Date getCurrentLocalDateTime(LocalDateTime localDateTime) {
        Date dateTime = null;
        try {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            String DateTimeStrring = localDateTime
                    .format(DateTimeFormatter.ofPattern(pattern));
            dateTime = new SimpleDateFormat(pattern).parse(DateTimeStrring);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateTime;
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));

    }

    public static Date convertStringToDate(String datePattern, String dateStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        Date date = new Date();
        try {
            date = dateFormatter.parse(dateStr);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;

    }

    public static Date setZeroTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static void checkDateBetween(Date startDate, Date endDate, Date date) {

        startDate = setZeroTime(startDate);
        endDate = setZeroTime(endDate);
        date = setZeroTime(date);

        if (date.before(startDate)) {
            throw new BusinessException("DATE_LESS_MIN");
        }
        if (date.after(endDate)) {
            throw new BusinessException("DATE_EXCEED_MAX");
        }

    }
    public static Date addDays(Date date,int days )
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days); 
        Date currentDatePlus = c.getTime();
        return setZeroTime(currentDatePlus);
    }
   public static String getDateTime(Timestamp ts)  
    {  
        String df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(ts);      
        return df; 
    }  
}
