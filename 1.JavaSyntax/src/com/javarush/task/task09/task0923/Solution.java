package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        int vowelCount = 0;
        int consonantCount = 0;
        char[] vowelArray = new char[s.length()];
        char[] consonantArray = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {

            }
            else if (isVowel(c)) {
                vowelArray[vowelCount++] = c;
            } else {
                consonantArray[consonantCount++] = c;
            }
        }

        for (int i = 0; i < vowelCount; i++) {
            System.out.print(vowelArray[i]);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < consonantCount; i++) {
            System.out.print(consonantArray[i]);
            System.out.print(" ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}