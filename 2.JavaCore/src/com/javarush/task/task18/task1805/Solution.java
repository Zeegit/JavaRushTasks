package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        Set<Integer> set = new HashSet<>();

        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            set.add(data);
        }
        inputStream.close();

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }

    }
}
