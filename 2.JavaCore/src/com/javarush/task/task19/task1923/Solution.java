package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader f1 = new BufferedReader(new FileReader("C:\\Z\\l.txt"));
//        BufferedWriter f2 = new BufferedWriter(new FileWriter("C:\\Z\\l.txt22"));
        BufferedReader f1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter f2 = new BufferedWriter(new FileWriter(args[1]));



        while (f1.ready()) {
            String line = f1.readLine();
            for (String s: line.split(" ")) {
                if (s.matches("\\S*\\d+\\S*")) {
                    f2.write(s);
                    f2.write(" ");
                }
            }
        }

        f1.close();
        f2.close();

    }
}
