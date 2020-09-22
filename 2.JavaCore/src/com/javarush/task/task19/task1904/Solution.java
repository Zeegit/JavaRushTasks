package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(java.util.Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            // Иванов Иван Иванович 31 12 1950
            // Петров Петр Петрович 31 12 1957
            String[] line = fileScanner.nextLine().split(" ");

            return new Person(line[1], line[2], line[0], new Date(Integer.parseInt(line[5])-1900, Integer.parseInt(line[4])-1, Integer.parseInt(line[3])));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }

}
