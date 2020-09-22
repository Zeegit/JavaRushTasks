package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).equals("exit")) {
            Thread t = new ReadThread(s);
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;

        @Override
        public void run() {
            try (FileInputStream in = new FileInputStream(fileName)) {
                int[] array = new int[256];
                while (in.available() > 0) {
                    array[in.read()]++;
                }

                int x = 0;
                int max = array[x];

                for (int i = 0; i < array.length; i++) {
                    if (array[i] > max) {
                        max = array[i];
                        x = i;
                    }
                }
                resultMap.put(fileName, x);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            start();
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
