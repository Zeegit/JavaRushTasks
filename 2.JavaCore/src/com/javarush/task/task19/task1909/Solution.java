package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileIn = reader.readLine();
            String fileOut = reader.readLine();

            try (BufferedReader inF = new BufferedReader(new FileReader(fileIn)); BufferedWriter outF = new BufferedWriter(new FileWriter(fileOut))) {
                while (inF.ready()) {
                    char ch = (char) inF.read();
                    if (ch == '.') {
                        ch = '!';
                    }
                    outF.write(ch);
                }
            }
        }
    }
}
