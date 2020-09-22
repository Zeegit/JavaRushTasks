package com.javarush.task.task19.task1917;

import java.io.*;
import java.nio.charset.Charset;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileConsoleWriter  f = new FileConsoleWriter("c:\\z\\2.txt");
        while (true) {
            f.write("100");
            Thread.sleep(100);
        }


    }

    private FileWriter fileWriter;
    BufferedWriter con = new BufferedWriter(new OutputStreamWriter(System.out));

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }


    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }


    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }


    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }









    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        con.write(cbuf, off, len);
        con.flush();
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        con.write(c);
        con.flush();
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        con.write(str);
        con.flush();
        //System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        con.write(str, off, len);
        con.flush();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        con.write(cbuf);
        con.flush();
    }

    public void close() throws IOException {
        //con.close();
        //con.flush();
        fileWriter.close();

    }

}
