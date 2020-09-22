package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static void main(String[] args) {
        String n = "Ivanov, Ivan";
        System.out.println( n.substring(0, n.indexOf(",")).trim());
        System.out.println(n.substring(n.indexOf(",")+1, n.length()).trim());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> c: countries.entrySet()) {
                if (c.getValue().equals(customer.getCountryName())) {
                    return c.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String n = contact.getName();
            return n.substring(n.indexOf(",")+1, n.length()).trim();
        }

        @Override
        public String getContactLastName() {
            String n = contact.getName();
            return n.substring(0, n.indexOf(",")).trim();

        }

        @Override
        public String getDialString() {
            return "callto://"+contact.getPhoneNumber().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}