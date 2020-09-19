package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();

        try (BufferedReader inF = new BufferedReader(new FileReader(fileIn));
             BufferedWriter outF = new BufferedWriter(new FileWriter(fileOut))) {
            for (String s : inF.readLine().split("\\s+")) {
                outF.write(String.valueOf((int) Math.round(Double.parseDouble(s.trim()))));
                outF.write(" ");
            }

        }
    }
}
