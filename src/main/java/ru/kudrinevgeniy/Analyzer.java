package ru.kudrinevgeniy;

import java.io.*;

public class Analyzer {
    public static void main(String[] args) {
       try (BufferedReader reader = new BufferedReader(new FileReader("data/input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/integers.txt"))) {
           while (reader.ready()) {
               writer.write(reader.readLine());
               writer.write(System.lineSeparator());
           }
       } catch (IOException e) {
           e.printStackTrace();
       }


    }
}
