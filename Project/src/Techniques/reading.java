package Techniques;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class reading {
    public static String read(String file) {
        try {
            String out = "";
            FileReader readF = new FileReader(file);
            BufferedReader buffR = new BufferedReader(readF);
            Scanner scan = new Scanner(buffR);
            while (scan.hasNextLine()) {
                out += scan.nextLine();
            }
            return out;
        } catch (Exception e) {
            System.out.println(e);
            return e.getMessage();
        }
    }
    public static void main(String[] args) {
        System.out.println(read("resources/file.txt"));
    }
}
