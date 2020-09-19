package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //-c name sex bd
        //-u id name sex bd
        //-d id
        //-i id
        String op = args[0];
        Person p;

        switch (op) {
            case "-c":
                SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
                Date date = null;
                try {
                    date = sdt.parse(args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], date));
                } else {
                    allPeople.add(Person.createFemale(args[1], date));
                }
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                SimpleDateFormat sdt1 = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
                Date date1 = null;
                try {
                    date1 = sdt1.parse(args[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                p = allPeople.get(Integer.parseInt(args[1]));
                p.setName(args[2]);
                p.setSex(args[2].equals("м")?Sex.MALE:Sex.FEMALE);
                p.setBirthDate(date1);
                break;
            case "-d":
                p = allPeople.get(Integer.parseInt(args[1]));
                p.setName(null);
                p.setSex(null);
                p.setBirthDate(null);
                break;
            case "-i":
                p = allPeople.get(Integer.parseInt(args[1]));
                System.out.printf("%s %s %te-%tb-%tY%n", p.getName(), p.getSex(), p.getBirthDate(), p.getBirthDate(), p.getBirthDate());    //Миронов м 15-Apr-1990
                break;
        }
    }
}
