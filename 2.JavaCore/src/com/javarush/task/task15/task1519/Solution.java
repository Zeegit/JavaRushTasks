package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String text = reader.readLine();
            if (text.equals("exit")) {
                break;
            }

            boolean isDouble = false;
            double valDouble = 0;

            boolean isInteger = false;
            int valInt = 0;

            boolean isShort = false;
            short valShort = 0;

            try {
                valDouble = Double.parseDouble(text);
                isDouble = true;
            } catch (NumberFormatException e) {
            }

            try {
                valInt = Integer.parseInt(text);
                isInteger = true;
            } catch (NumberFormatException e) {
            }

            try {
                valShort = Short.parseShort(text);
                isShort = true;
            } catch (NumberFormatException e) {
            }


            if (isDouble && text.contains(".")) {
                print(valDouble);
            } else if (isShort && valShort > 0 && valShort < 128) {
                print(valShort);
            } else if (isInteger && (valInt <= 0 || valInt >= 128)) {
                print(valInt);
            } else
                print(text);
        }

    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
