package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        Set<Integer> set = new HashSet<>();

        int cnt = 0;
        int code = (int) ',';
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == code) {
                cnt++;
            }
        }
        inputStream.close();

        System.out.print(cnt);
    }
}
