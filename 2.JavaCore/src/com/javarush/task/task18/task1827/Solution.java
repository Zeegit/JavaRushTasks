package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static class Price {
        String id; // - 8 символов.
        String productName; // название товара, 30символов .
        String price; // цена, 8 символов.
        String quantity; //количество, 4 символа.

        public Price(String id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }
    }

    private static List<Price> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        args = new String[]{"-c", "productName", "price", "quantity"};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader f1 = new BufferedReader(new FileReader(fileName));

        while (f1.ready()) {
            char[] id = new char[8];
            char[] productName = new char[30];
            char[] price = new char[8];
            char[] quantity = new char[4];
            System.out.println(f1.read(id));
            System.out.println(f1.read(productName));
            System.out.println(f1.read(price));
            System.out.println(f1.read(quantity));
        }
        f1.close();

        list.add(new Price("1", "weewr", "wer", "werw"));
        list.add(new Price("1", "weewr", "wer", "werw"));
        list.add(new Price("1", "weewr", "wer", "werw"));

        BufferedWriter f2 = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++) {
            f2.write(list.get(i).id, 0, 8);
            f2.write(list.get(i).productName, 0, 30);
            f2.write(list.get(i).price, 0, 8);
            f2.write(list.get(i).quantity, 0, 4);
        }

    }
}
