package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"c:\\z\\0.txt"};
        BufferedReader inF = new BufferedReader(new FileReader(args[0]));
        TreeMap<Character, Integer> map = new TreeMap<>();


        while (inF.ready()) {
            Character ch = (char) inF.read();
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }
        inF.close();

        for (Map.Entry<Character, Integer> m: map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        //System.out.println(map);
    }
}
