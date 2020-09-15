package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("Май 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Date d = new SimpleDateFormat("MMMM d yyyy").parse(date);
        Calendar c = new GregorianCalendar(d.getYear(), d.getMonth(), d.getDay());
        return  ((c.get(Calendar.DAY_OF_YEAR) % 2) == 0);

    }
}
