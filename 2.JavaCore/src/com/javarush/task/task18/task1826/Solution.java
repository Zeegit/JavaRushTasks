package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int diff = args[0].equals("-e") ? 3 : -3;
        FileInputStream f1 = new FileInputStream(args[1]);
        FileOutputStream f2 = new FileOutputStream(args[2]);


        while (f1.available() > 0) {
            f2.write(f1.read() + diff);
        }
        f1.close();
        f2.close();

    }

}
