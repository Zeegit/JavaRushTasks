package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {
            TreeSet<Character> set = new TreeSet<>();
            while (file.ready()) {
                char[] array = file.readLine().toLowerCase().replaceAll("[^a-z]", "").toCharArray();


                for (char ch : array) {
                    set.add(ch);
                }
            }

            set.stream().limit(5).forEach(System.out::print);
        }

    }
}
