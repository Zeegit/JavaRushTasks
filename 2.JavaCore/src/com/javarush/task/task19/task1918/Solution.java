package com.javarush.task.task19.task1918;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader (fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        reader.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String path  = consoleReader.readLine();
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append(fileReader.readLine());
        }
        fileReader.close();
        String data = stringBuilder.toString();

        String startTag = "<" + args[0];
        String endTag = "</" + args[0] + ">";
        int startTagIndex;
        int endTagIndex;
        int tempStartTagIndex = 0;
        while(tempStartTagIndex != -1){
            startTagIndex = data.indexOf(startTag, tempStartTagIndex);
            if(startTagIndex == -1 ){
                return;
            }
            endTagIndex = data.indexOf(endTag, startTagIndex);

            tempStartTagIndex = data.indexOf(startTag, startTagIndex + 1);
            if(tempStartTagIndex < endTagIndex && tempStartTagIndex != -1){
                endTagIndex = data.indexOf(endTag, endTagIndex + 1);
            }

            System.out.println(data.substring(startTagIndex, endTagIndex + endTag.length()));


        }
    }
}
