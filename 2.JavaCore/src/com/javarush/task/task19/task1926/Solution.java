package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.Collections;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f1 = new BufferedReader(new FileReader(reader.readLine()));

        while (f1.ready()) {
            String line = f1.readLine();
            StringBuilder sb = new StringBuilder(line);

            System.out.println(sb.reverse().toString());
        }

        f1.close();
        reader.close();
    }
}
