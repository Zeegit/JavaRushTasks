package com.javarush.task.task19.task1907;

import java.io.*;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        reader.close();

        BufferedReader inF = new BufferedReader(new FileReader(fileIn));
        int cnt = 0;
        while (inF.ready()) {
            String line = inF.readLine();
            String[] strings = line.split("[\\s\\p{P}]");
            for (String s : strings) {
                if (s.equals("world")) {
                    cnt++;
                }
            }
        }
        inF.close();
        System.out.println(cnt);

    }
}
