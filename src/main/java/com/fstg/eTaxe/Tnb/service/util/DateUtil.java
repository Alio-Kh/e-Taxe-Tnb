/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alikhyatti
 */
public class DateUtil {

    private static String FORMAT_YY_MM_DD = "yyyy-MM-dd";
    private static String FORMAT_YYYY = "yyyy";

    public static Date parse(String dateAsString) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YY_MM_DD);
            return simpleDateFormat.parse(dateAsString);
        } catch (ParseException exception) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }

    public static Date parseToYear(String dateAsString) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYY);
            return simpleDateFormat.parse(dateAsString);
        } catch (ParseException exception) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }

    public static String format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YY_MM_DD);
        return simpleDateFormat.format(date);
    }

    public static String formattoYear(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYY);
        return simpleDateFormat.format(date);
    }

    public static int formatToYearInteger(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYY);
        String dateStr = simpleDateFormat.format(date);
        return Integer.valueOf(dateStr);
    }

    public static Date parseYearIntegerToDate(int annee) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YY_MM_DD);
        String date = String.valueOf(annee) + "-01-02";
        return parse(date);

    }

    public static int periodMonth(Date date1, Date date2) {
        String date1Str = DateUtil.format(date1);
        String date2Str = DateUtil.format(date2);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate2 = LocalDate.parse(date2Str, format);
        LocalDate localDate1 = LocalDate.parse(date1Str, format);
        Period period = Period.between(localDate2, localDate1);
        return period.getYears() * 12 + period.getMonths();

    }

}
