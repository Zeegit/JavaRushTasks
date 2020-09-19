package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
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

        int posEq = result.indexOf("=");
        int posOp = result.indexOf("+") + result.indexOf("-") + result.indexOf("*") + 2;
        int res = 0;
        if (result.contains("+")) {
            res = Integer.parseInt(result.substring(0, posOp).trim()) + Integer.parseInt(result.substring(posOp + 1, posEq).trim());
        }
        if (result.contains("-")) {
            res = Integer.parseInt(result.substring(0, posOp).trim()) - Integer.parseInt(result.substring(posOp + 1, posEq).trim());
        }
        if (result.contains("*")) {
            res = Integer.parseInt(result.substring(0, posOp).trim()) * Integer.parseInt(result.substring(posOp + 1, posEq).trim());
        }

        System.out.println(result + res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

