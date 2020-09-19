package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        args= new String[]{"-c", "Иванов", "м", "04/01/1990", "Иванова", "ж", "18/05/1999"};
//  args= new String[]{"-u", "0","Петров", "м", "04/01/1991", "1","Петрова", "ж", "18/05/1995"};
// args= new String[]{"-d", "0","1"};
 //       args = new String[]{"-i", "0", "1"};

        String op = args[0];
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        CRUD(op, null, args[i], args[i + 1], args[i + 2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        CRUD(op, args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        CRUD(op, args[i], null, null, null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        CRUD(op, args[i], null, null, null);
                    }
                }
                break;
        }
    }

    public static void CRUD(String op, String id, String name, String sex, String bd) {

        Person p;
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        Date date = null;

        switch (op) {
            case "-c":
                try {
                    date = sdt.parse(bd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (sex.equals("м")) {
                    allPeople.add(Person.createMale(name, date));
                } else {
                    allPeople.add(Person.createFemale(name, date));
                }
                System.out.println(allPeople.size() - 1);
                break;
            case "-u":
                try {
                    date = sdt.parse(bd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                p = allPeople.get(Integer.parseInt(id));
                p.setName(name);
                p.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
                p.setBirthDate(date);
                break;
            case "-d":
                p = allPeople.get(Integer.parseInt(id));
                p.setName(null);
                p.setSex(null);
                p.setBirthDate(null);
                break;
            case "-i":
                p = allPeople.get(Integer.parseInt(id));
                System.out.printf("%s %s %te-%tb-%tY%n", p.getName(), p.getSex(), p.getBirthDate(), p.getBirthDate(), p.getBirthDate());    //Миронов м 15-Apr-1990
                break;
        }
    }
}
