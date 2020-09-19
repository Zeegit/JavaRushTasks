package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream f1 = new FileInputStream(fileName1);
        int[] buffer = new int[f1.available()];
        int index = 0;
        while (f1.available() > 0) {
            buffer[index++] = f1.read();
        }
        f1.close();

        FileOutputStream f1o = new FileOutputStream(fileName1);
        FileInputStream f2 = new FileInputStream(fileName2);
        while (f2.available() > 0) {
            f1o.write(f2.read());
        }
        f2.close();

        for (int j : buffer) {
            f1o.write(j);
        }
        f1o.close();

    }
}
