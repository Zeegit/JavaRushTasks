package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"c:\\z\\l.txt22", "c:\\z\\l.txt221111"};
        StringJoiner stringJoiner = new StringJoiner(",");

        BufferedReader r = new BufferedReader(new FileReader(args[0]));
        BufferedWriter w = new BufferedWriter(new FileWriter(args[1]));
        while (r.ready()) {
            for (String s : r.readLine().split(" ")) {
                if (s.length() > 6) {
                    stringJoiner.add(s);
                }
            }
        }


        w.write(stringJoiner.toString());
        r.close();
        w.close();
    }
}
