package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        reader.close();

        BufferedReader file = new BufferedReader(new FileReader(fn));
        while (file.ready()) {
            String s = file.readLine();
            List<String> list = Arrays.asList(s.split(" "));

            int cnt = 0;
            for (String w: words) {
                if (list.contains(w)) {
                    cnt++;
                }
            }

            if (cnt == 2) {
                System.out.println(s);
            }
        }
        file.close();

    }
}
