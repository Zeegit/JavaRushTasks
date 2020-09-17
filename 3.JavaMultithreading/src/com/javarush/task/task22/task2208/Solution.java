package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        //{name=Ivanov, country=Ukraine, city
        System.out.println(params);
        System.out.println(getQuery(params));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            String format;
            if (sb.length() == 0) {
                format = "%s = '%s'";
            } else {
                format = " and %s = '%s'";
            }
            if (param.getValue() != null) {
                sb.append(String.format(format, param.getKey(), param.getValue()));
            }
        }
        return sb.toString();
    }
}
