package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];

            int count = inputStream.read(buffer);
            returnReversArray(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }

    static void returnReversArray(byte[] arr){
        byte temp;
        for (int i = arr.length-1, j = 0; i >=arr.length/2 ; i--,j++) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}
