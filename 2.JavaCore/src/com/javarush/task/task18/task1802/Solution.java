package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        int minData = Integer.MAX_VALUE;
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            if (data < minData) {
                minData = data;
            }
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        System.out.println(minData);
    }
}
