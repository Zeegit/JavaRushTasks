package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 0) {
            int maximum = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                int z = Integer.parseInt(reader.readLine());
                if (z > maximum) {
                    maximum = z;
                }
            }
        
            //напишите тут ваш код

            System.out.println(maximum);
        }
    }
}
