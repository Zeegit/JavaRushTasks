package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String d1 = reader.readLine();
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        System.out.println(df.format(d).toUpperCase());
    }
}
