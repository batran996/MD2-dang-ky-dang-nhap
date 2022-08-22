package config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
   public static Scanner scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public List<T> readFile(String pathFile) {
        List<T> tList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return tList;
    }

    public void writeFile(String pathFile, List<T> tList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            fileOutputStream.close();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}