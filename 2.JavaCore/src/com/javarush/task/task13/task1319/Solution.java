package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = reader.readLine();
            BufferedWriter wrirter = new BufferedWriter(new FileWriter(fileName));

            String line = "";

            while (!line.equals("exit")) {
                line = reader.readLine();
                wrirter.write(line, 0, line.length());
                wrirter.write('\n');
                wrirter.flush();
            }
            wrirter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
