package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fn = reader.readLine();
            reader.close();

            FileInputStream f = new FileInputStream(fn);
            int size = f.available();
            f.close();

            if (size < 1000) {
                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
