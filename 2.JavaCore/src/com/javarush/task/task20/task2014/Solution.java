package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

     /*   File your_file_name = File.createTempFile("your_file_name", ".txt");
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);

        Solution savedObject = new Solution(4);
        savedObject.(outputStream);
        outputStream.flush();*/

        File your_file_name = File.createTempFile("your_file_name", ".txt");
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);

        Solution savedObject = new Solution(4);

        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(savedObject);
        oos.close();



        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Solution loadedObject = (Solution) ois.readObject();
        ois.close();

        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
