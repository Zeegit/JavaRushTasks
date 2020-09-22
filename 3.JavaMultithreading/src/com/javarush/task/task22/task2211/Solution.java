package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // args = new String[] {"c:\\z\\l.txt11 ", "c:\\z\\l.txt22" };
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buffer = new byte[file.available()];
        file.read(buffer);

        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");


        String s = new String(buffer, windows1251);
        buffer = s.getBytes(utf8);

        FileOutputStream out = new FileOutputStream(args[1]);
        out.write(buffer);

        file.close();
        out.close();
    }
}
