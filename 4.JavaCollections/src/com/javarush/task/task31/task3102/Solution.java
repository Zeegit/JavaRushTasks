package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> f = new ArrayList<>();
        Deque<File> deque = new ArrayDeque<>();

        deque.push(new File(root));

        while (true) {
            File x = deque.pop();

            if (x.isDirectory()) {
                for (File file : x.listFiles()) {
                    deque.push(file);
                }
            } else {
                f.add(x.getAbsolutePath());
            }

            if (deque.isEmpty()) {
                break;
            }
        }

        return f;

    }

    public static void main(String[] args) throws IOException {
        List<String> f = getFileTree("c:\\z");
        System.out.println(f);
    }
}
