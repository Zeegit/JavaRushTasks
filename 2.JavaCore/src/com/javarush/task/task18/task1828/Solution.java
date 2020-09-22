package com.javarush.task.task18.task1828;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"-u", "198478", "11Шорты пляжные синие", "159.00", "12"};
        List<String> list = new ArrayList<>();
        //args = new String[]{"-d", "198478"};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = "c:\\z\\0.txt"; // reader.readLine();
        String fileName = reader.readLine();
        reader.close();
        if (args.length > 0) {
            if (args[0].equals("-d") || args[0].equals("-u")) {
                BufferedReader inFile = new BufferedReader(new FileReader(fileName));
                while (inFile.ready()) {
                    String s = inFile.readLine();
                    int num = Integer.parseInt(s.substring(0, 8).trim());
                    if (num != Integer.parseInt(args[1])) {
                        list.add(s);
                    } else if (args[0].equals("-d")) {
                        continue;
                    } else if (args[0].equals("-u")) {
                        String newLine = String.format("%-8d%-30s%-8s%-4s", num, args[2], args[3], args[4]);
                        list.add(newLine);
                    }
                }
                inFile.close();

                BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
                //Charset windows1251 = Charset.forName("Windows-1251");
                for (int i = 0; i < list.size(); i++) {
                    //byte[] buffer;
                    //buffer = s.getBytes(windows1251);
                    outFile.write(list.get(i));
                    //if (i > 0)
                    {
                        outFile.newLine();
                    }
                    ///outFile.write("\n");
                }
                outFile.flush();
                outFile.close();

                //System.out.println(newLine);


            }

        }

    }
}
