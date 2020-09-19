package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1n = reader.readLine();
        String f2n = reader.readLine();
        String f3n = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(f1n);
        int size = inputStream.available();
        int size_first_half = size / 2 + size % 2;

        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream1 = new FileOutputStream(f2n);
        for (int i = 0; i < size_first_half; i++) {
            outputStream1.write(inputStream.read());
        }

        FileOutputStream outputStream2 = new FileOutputStream(f3n);
        for (int i = size_first_half; i < size; i++) {
            outputStream2.write(inputStream.read());
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
