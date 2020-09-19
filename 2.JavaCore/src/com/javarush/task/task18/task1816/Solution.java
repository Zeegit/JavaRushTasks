package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream file = new FileInputStream(args[0])) {
            int count = 0;

            while (file.available() > 0) {
                int i = file.read();
                if ((i >= 97 && i <= 122) || (i >= 65 && i <= 90)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
