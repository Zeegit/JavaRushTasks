package com.javarush.task.task19.task1927;

import java.io.*;

/* 
Контекстная реклама
*/

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);


        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        int i = 0;
        for (String s:result.split(System.lineSeparator())) {
            System.out.println(s);
            if (++i % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
