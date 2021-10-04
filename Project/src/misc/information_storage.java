package misc;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;


public class information_storage {
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
    public static void store(String name ,String Class ,int score) throws FileNotFoundException {
        int line = findln(name ,Class);
        String onLine = "";
        LinkedList<String> linesbefore = new LinkedList<String>();
        LinkedList<String> linesafter = new LinkedList<String>();
        //try {
        FileReader readF = new FileReader("resources/results.txt");
        BufferedReader buffR = new BufferedReader(readF);
        Scanner scan = new Scanner(buffR);
        int lc = 0;
        while (scan.hasNextLine()) {
            String l = scan.nextLine();
            //System.out.print(l);
            if (lc < line) {
                //System.out.println("  -- " + 0 + ":" + line + ":" + lc);
                linesbefore.push(l);
            } else {
                if (lc > line) {
                    //System.out.println("  -- " + 2);
                    linesafter.push(l);
                } else {
                    //System.out.println("  -- " + 1);
                    onLine = l;
                }
            }
            lc++;
        }
        int[] scores = {0 ,0 ,0};
        int c = 0;
        String[] ID_scores = onLine.split(";");
        //System.out.println(Arrays.toString(ID_scores));
        for (String str : ID_scores[1].split(",")) {
            scores[c] = Integer.parseInt(str);
            c++;
        }
        scores[0] = scores[1];
        scores[1] = scores[2];
        scores[2] = score;
        c = 0;
        String[] Sscores = {"" ,"" ,""};
        for (int x : scores) {
            Sscores[c] = String.valueOf(x);
            c++;
        }
        onLine = ID_scores[0] + ";" + String.join("," ,Sscores);
        String full = String.join("\n" ,linesbefore) + "\n" + onLine + "\n" + String.join("\n" ,linesafter);
        write("resources/results.txt" ,full);
        //} catch (Exception e) {
        //    System.out.println(e);
        //}
    }

    public static int findln(String name ,String Class) {
        try {
            int ln = 0;
            FileReader readF = new FileReader("resources/results.txt");
            BufferedReader buffR = new BufferedReader(readF);
            Scanner scan = new Scanner(buffR);
            while (scan.hasNextLine()) {
                String name_class = (scan.nextLine().split(";"))[0];
                if (name_class.equals(Class + ":" + name)) {
                    scan.close();
                    return ln;
                }
                ln++;
            }
            scan.close();
            return -1;
        } catch (Exception e) {
            System.out.println(e);
            return -2;
        }
    }
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        store("nick" ,"a" ,rand.nextInt(10));
        store("fin" ,"b" ,rand.nextInt(10));
    }
}
