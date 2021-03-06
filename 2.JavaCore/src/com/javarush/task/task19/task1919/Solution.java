package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"c:\\z\\0.txt"};
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        while (file.ready()) {
            String[] s = file.readLine().split(" ");

            map.put(s[0], map.getOrDefault(s[0], 0.0) + Double.parseDouble(s[1]));
        }
        file.close();

        for (Map.Entry<String, Double> m: map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
