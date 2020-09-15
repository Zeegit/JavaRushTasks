package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();

        BufferedReader inF = new BufferedReader(new FileReader(fileIn));
        BufferedWriter outF = new BufferedWriter(new FileWriter(fileOut));


        while (inF.ready()) {
            String line = inF.readLine();
            String[] strings = line.split(" ");
            for (String s: strings) {
                if (s.matches("\\d+")) {
                    outF.write(s + " ");
                }
            }
        }
        inF.close();
        outF.close();
    }

}
