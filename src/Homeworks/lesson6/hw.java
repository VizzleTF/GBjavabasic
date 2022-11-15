package Homeworks.lesson6;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class hw {
    static void workStream(FileInputStream fis) {
        try {
            int a =0;
            while (true){
                a = fis.read();
                if (a != -1)
                    System.out.print((char)a);
                else
                    break;
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    static void workStream(FileInputStream fis, FileOutputStream fos) {
        try {
            int a = 0;
            PrintStream ps = new PrintStream(fos);
            while (true) {
                a = fis.read();
                if (a != -1)
                    ps.print((char) a);
                else
                    break;
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    static boolean checkFile(String fis, String x){
        try {
            Scanner scanner = new Scanner(new FileInputStream(fis));
            while (scanner.hasNext()) {
                if (scanner.next().equals(x))
                    return true;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    static boolean checkFiles(String fis, String x){
        File folder = new File(fis);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (checkFile(file.getAbsolutePath(), x))
                    return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        try {

            FileInputStream fis1 = new FileInputStream("/home/ivan/GeekBrains/src/Homeworks/lesson6/files/1.txt");
            FileInputStream fis2 = new FileInputStream("/home/ivan/GeekBrains/src/Homeworks/lesson6/files/2.txt");
            FileInputStream fis3 = new FileInputStream("/home/ivan/GeekBrains/src/Homeworks/lesson6/files/3.txt");
            FileOutputStream fos = new FileOutputStream("/home/ivan/GeekBrains/src/Homeworks/lesson6/files/3.txt");

            workStream(fis1, fos);
            workStream(fis2, fos);
            workStream(fis3);

            System.out.println();
            System.out.println();

            if (checkFile("/home/ivan/GeekBrains/src/Homeworks/lesson6/files/3.txt", "test")) {
                System.out.println("Your word is in text");
            } else {
                System.out.println("No matches");
            }

            System.out.println();

            if (checkFiles("/home/ivan/GeekBrains/src/Homeworks/lesson6/files", "THIS")) {
                System.out.println("Your word is in files of folder");
            } else {
                System.out.println("No matches");
            }


        } catch (Exception e) { e.printStackTrace(); }
    }
}
