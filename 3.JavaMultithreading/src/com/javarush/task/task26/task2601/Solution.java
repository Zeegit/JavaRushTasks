package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        //Integer[] a = new Integer[]{13, 8, 15, 5, 17};
        //sort(a);
        //Arrays.stream(a).forEach(System.out::println);
    }

    public static Integer[] sort(Integer[] array) {
        final double mediana;

        Arrays.sort(array);
        int pos = array.length / 2;

        if (array.length % 2 == 0) {
            mediana = 1.0 * (array[pos-1] + array[pos]) / 2;
        } else {
            mediana = array[pos];
        }

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(Math.abs(mediana - o1), Math.abs(mediana - o2));
            }
        });
        return array;
    }
}
