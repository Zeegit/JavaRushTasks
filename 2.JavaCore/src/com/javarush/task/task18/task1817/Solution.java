package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream f1 = new FileInputStream(args[0]);

        int sp = 0;
        int all = 0;

        while (f1.available() > 0) {
            int ch = f1.read();
            if (ch == 32) {
                sp++;
            }
            all++;
        }
        f1.close();

        System.out.printf("%.2f\n", (double) sp/all * 100);
    }
}
