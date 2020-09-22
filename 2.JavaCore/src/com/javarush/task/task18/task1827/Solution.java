package com.javarush.task.task18.task1827;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //args = new String[]{"-c", "Шорты пляжные синие", "159.00", "12"};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = "c:\\z\\0.txt"; // reader.readLine();
        String fileName = reader.readLine();
        reader.close();
        if (args.length > 0) {
            switch (args[0]) {
                case "-c":
                    BufferedReader inFile = new BufferedReader(new FileReader(fileName));
                    int max = 0;
                    while (inFile.ready()) {
                        String s = inFile.readLine();
                        int num = Integer.parseInt(s.substring(0, 8).trim());
                        max = Math.max(num, max);
                    }
                    inFile.close();

                    BufferedOutputStream outFile = new BufferedOutputStream(new FileOutputStream(fileName, true));
                    Charset windows1251 = Charset.forName("Windows-1251");
                    String newLine = String.format("%n%-8d%-30s%-8s%-4s", max + 1, args[1], args[2], args[3]);

                    byte[] buffer;
                    buffer = newLine.getBytes(windows1251);
                    outFile.write(buffer);


                    outFile.close();

                    //System.out.println(newLine);
                    break;
            }

        }
    }
}
