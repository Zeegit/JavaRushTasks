package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String params = url.substring(url.indexOf("?") + 1);
        String obj = null;
        for (String param : params.split("&")) {
            if (param.contains("=")) {
                int x = param.indexOf("=");
                String p = param.substring(0, x);
                String v = param.substring(x + 1, param.length());
                if (p.equals("obj")) {
                    obj = v;
                }
                System.out.printf("%s ", p);
            } else {
                System.out.printf("%s ", param);
            }
        }
        System.out.println();
        if (obj != null) {
            try {
                alert(Double.parseDouble(obj));
            } catch (Exception e) {
                alert(obj);
            }
            /*if (obj.contains(".")) {
                alert(Double.valueOf(obj));
            } else {
                alert(obj);
            }*/
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
