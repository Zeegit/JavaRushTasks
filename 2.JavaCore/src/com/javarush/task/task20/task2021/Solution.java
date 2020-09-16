package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("not now");
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new NotSerializableException("not now");
        }

    }

    public static void main(String[] args) {

    }
}
