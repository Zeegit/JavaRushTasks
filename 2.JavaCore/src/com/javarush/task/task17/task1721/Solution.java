package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = reader.readLine();
        String fn2 = reader.readLine();

        reader.close();

        BufferedReader f1 = new BufferedReader(new FileReader(fn1));
        while (f1.ready()) {
            allLines.add(f1.readLine());
        }
        f1.close();

        BufferedReader f2 = new BufferedReader(new FileReader(fn2));
        while (f2.ready()) {
            forRemoveLines.add(f2.readLine());
        }
        f2.close();

        new Solution().joinData();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
