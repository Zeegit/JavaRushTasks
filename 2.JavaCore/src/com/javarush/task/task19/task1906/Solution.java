package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();

        BufferedReader inF = new BufferedReader(new FileReader(fileIn));
        BufferedWriter outF = new BufferedWriter(new FileWriter(fileOut));
        int cnt = 1;
        while (inF.ready()) {
            char ch = (char) inF.read();
            if (cnt % 2 == 0) {
                outF.write(ch);
            }
            cnt++;
        }

        inF.close();
        outF.close();


    }
}
