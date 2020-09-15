package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        string = string.trim().replaceAll(" +", " ");
        for (int i = 0; i < string.length() - 1; i++) {

            if (i == 0 && string.charAt(i + 1) != ' ') {

                string = string.substring(0, i) + string.substring(i, i+1).toUpperCase() + string.substring(i+1);

            } else if (string.charAt(i) == ' ' && string.charAt(i + 1) != ' '){

                string = string.substring(0, i+1) + string.substring(i+1, i+2).toUpperCase() + string.substring(i+2);
            }
        }

        System.out.println(string);
    }
}
