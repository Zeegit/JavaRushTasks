package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        //args = new String[] {"c:\\z\\0.txt", "5", "aaaaaaaa"};
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {

            raf.seek(Math.min(number, raf.length()));

            raf.write(text.getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
