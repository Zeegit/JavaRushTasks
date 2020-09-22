package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"-u", "198478", "11Шорты пляжные синие", "159.00", "12"};
        List<String> list = new ArrayList<>();
        //args = new String[]{"19847983"};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = "c:\\z\\0.txt"; // reader.readLine();
        String fileName = reader.readLine();
        reader.close();
        if (args.length > 0) {
            BufferedReader inFile = new BufferedReader(new FileReader(fileName));
            while (inFile.ready()) {
                String s = inFile.readLine();
                int num = Integer.parseInt(s.substring(0, s.indexOf(" ")).trim());
                if (num == Integer.parseInt(args[0])) {
                    System.out.println(s);
                }
            }
            inFile.close();
        }
    }
}
