package Techniques;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class writing {
    public static void write(String file ,String data) {
        try {
            FileWriter writeF = new FileWriter(file);
            BufferedWriter buffW = new BufferedWriter(writeF);
            buffW.write(data);
            buffW.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        write("resources/file2.txt" ,"hello ,this is a test\nhow are you doing today?\n\n\n\n\ngood!");
    }
}
