package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human c1 = new Human();
        c1.name = "Vasya";
        c1.age = 7;
        c1.sex = true;
        c1.children = new ArrayList<Human>();

        Human c2 = new Human();
        c2.name = "Olya";
        c2.age = 10;
        c2.sex = false;
        c2.children = new ArrayList<Human>();

        Human c3 = new Human();
        c3.name = "Lena";
        c3.age = 17;
        c3.sex = false;
        c3.children = new ArrayList<Human>();

        Human m = new Human();
        m.name = "Nata";
        m.age = 34;
        m.sex = false;
        m.children = new ArrayList<Human>();
        m.children.add(c1);
        m.children.add(c2);
        m.children.add(c3);

        Human p = new Human();
        p.name = "Oleg";
        p.age = 35;
        p.sex = true;
        p.children = new ArrayList<Human>();
        p.children.add(c1);
        p.children.add(c2);
        p.children.add(c3);


        Human b1 = new Human();
        b1.name = "Valya";
        b1.age = 67;
        b1.sex = false;
        b1.children = new ArrayList<Human>();
        b1.children.add(m);

        Human b2 = new Human();
        b2.name = "Olya";
        b2.age = 65;
        b2.sex = false;
        b2.children = new ArrayList<Human>();
        b2.children.add(p);

        Human d1 = new Human();
        d1.name = "Petr";
        d1.age = 67;
        d1.sex = true;
        d1.children = new ArrayList<Human>();
        d1.children.add(m);

        Human d2 = new Human();
        d2.name = "Semen";
        d2.age = 65;
        d2.sex = true;
        d2.children = new ArrayList<Human>();
        d2.children.add(p);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(m);
        System.out.println(p);
        System.out.println(b1);
        System.out.println(d1);
        System.out.println(b2);
        System.out.println(d2);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
