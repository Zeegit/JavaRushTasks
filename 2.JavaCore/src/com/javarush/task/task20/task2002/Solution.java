package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", ".txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            {User u = new User();
            u.setFirstName("fff");
            u.setLastName("dd");
            u.setBirthDate(new Date(1976,10,01));
            u.setCountry(User.Country.RUSSIA);
            javaRush.users.add(u);}
            {User u = new User();
                u.setFirstName("fff");
                u.setLastName("dd");
                u.setBirthDate(new Date(1976,10,01));
                u.setCountry(User.Country.RUSSIA);
                javaRush.users.add(u);}
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(String.valueOf(users.size()));
            writer.write("\n");
            for (User u: users) {


                writer.write(u.getFirstName()); writer.write("\n");
                writer.write(u.getLastName()); writer.write("\n");
                writer.write(String.valueOf(u.getBirthDate().getTime())); writer.write("\n");
                writer.write(String.valueOf(u.isMale())); writer.write("\n");
                writer.write(String.valueOf(u.getCountry())); writer.write("\n");
            }

            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int n = Integer.parseInt(reader.readLine());
            if (n > 0) {
                users = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    User u = new User();
                    u.setFirstName(reader.readLine());
                    u.setLastName(reader.readLine());
                    u.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    u.setMale(Boolean.parseBoolean(reader.readLine()));
                    String str = reader.readLine();
                    if (str.equals("UKRAINE")) { u.setCountry(User.Country.UKRAINE); }
                    if (str.equals("RUSSIA")) { u.setCountry(User.Country.RUSSIA); }
                    if (str.equals("OTHER")) { u.setCountry(User.Country.OTHER);  }
                    users.add(u);
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
