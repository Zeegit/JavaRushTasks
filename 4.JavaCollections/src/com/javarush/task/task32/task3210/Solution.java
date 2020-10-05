package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        //seek(long pos), read(byte[] b, int off, int len), write(byte[] b)
        //args = new String[] {"c:\\z\\0.txt", "5", "aaa"};
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            byte[] b =  new byte[text.length()];
            raf.seek(number);
            raf.read(b, 0, text.length());
            String readText = new String(b);
            if (text.equals(readText)) {
                raf.seek(raf.length());
                raf.write(new byte[] {'t', 'r', 'u', 'e'});
            } else {
                raf.seek(raf.length());
                raf.write(new byte[] {'f', 'a', 'l', 's', 'e'});
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
