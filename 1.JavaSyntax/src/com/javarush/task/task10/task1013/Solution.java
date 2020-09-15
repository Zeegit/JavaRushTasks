package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int a1;
        private short a2;
        private long a3;
        private char a4;
        private double a5;
        private boolean a6;



        public Human(int a1) {
            this.a1 = a1;
        }

        public Human(int a1, short a2, long a3, char a4) {
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
            this.a4 = a4;
        }

        public Human(int a1, short a2, long a3) {
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
        }

        public Human(int a1, short a2) {
            this.a1 = a1;
            this.a2 = a2;
        }

        public Human(int a1, short a2, long a3, char a4, double a5, boolean a6) {
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
            this.a4 = a4;
            this.a5 = a5;
            this.a6 = a6;
        }

        public Human(boolean a6) {
            this.a6 = a6;
        }

        public Human(double a5) {
            this.a5 = a5;
        }

        public Human(char a4) {
            this.a4 = a4;
        }

        public Human(long a3) {
            this.a3 = a3;
        }

        public Human(short a2) {
            this.a2 = a2;
        }
    }
}
