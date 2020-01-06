/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alikhyatti
 */
public class DateUtil {
     private static String FORMAT_YY_MM_DD="yyyy-MM-dd" ;
    
    public static Date parse(String dateAsString){
        try {
            SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(FORMAT_YY_MM_DD);
            return  simpleDateFormat.parse(dateAsString);
        } catch (ParseException exception) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }
    
    public static String format(Date date){
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(FORMAT_YY_MM_DD);
        return  simpleDateFormat.format(date);      
    }
}
