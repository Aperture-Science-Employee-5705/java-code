package challenges;

import java.util.*;
import java.io.*;

public class arithmetic_tst {
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
        FileReader readF = new FileReader("resources/results.txt");
        BufferedReader buffR = new BufferedReader(readF);
        Scanner scan = new Scanner(buffR);
        int lc = 0;
        while (scan.hasNextLine()) {
            String l = scan.nextLine();
            if (lc < line) {
                linesbefore.push(l);
            } else {
                if (lc > line) {
                    linesafter.push(l);
                } else {
                    onLine = l;
                }
            }
            lc++;
        }
        int[] scores = {0 ,0 ,0};
        int c = 0;
        String[] ID_scores = onLine.split(";");
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
    }

    public static int findln(String name ,String Class) {
        try {
            int ln = 0;
            FileReader readF = new FileReader("resources/results.txt");
            BufferedReader buffR = new BufferedReader(readF);
            Scanner scan = new Scanner(buffR);
            while (scan.hasNextLine()) {
                String name_class = (scan.nextLine().split(";"))[0];
                if (name_class.equals(name + ":" + Class)) {
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
    public static String input(String message) {
        System.out.print(message);
        Scanner scan = new Scanner(System.in);
        String out = scan.nextLine();
        return out;
    }
    public static double input_double(String message) {
        String in = input(message);
        try {
            double out = Double.parseDouble(in);
            return out;
        } catch (NumberFormatException e) {
            System.out.println("error NumberFormatException");
            return Double.POSITIVE_INFINITY;
        }
    }
    public static void report() throws Exception {
        String full = "----------------------------------------------------------------------------------\n\n";
        FileReader readF = new FileReader("resources/results.txt");
        BufferedReader buffR = new BufferedReader(readF);
        Scanner scan = new Scanner(buffR);
        String ln = "";
        while (scan.hasNextLine()) {
            String[] ln1 = scan.nextLine().split(";");
            if (ln1.length != 2) {
                continue;
            }
            String scores[] = ln1[1].split(",");
            int iscores[] = {0 ,0 ,0};
            int c = 0;
            for (String str : scores) {
                iscores[c] = Integer.parseInt(str);
                c++;
            }
            Arrays.sort(iscores);
            c = 0;
            for (int i : iscores) {
                scores[c] = String.valueOf(i);
                c++;
            }
            ln1[1] = String.join("," ,scores);
            String[] classname = ln1[0].split(":");
            ln1[0] = "Class " + classname[1] + " \"" + classname[0] + "\"";
            ln = String.join(" : " ,ln1);
            full += ln + "\n";
        }
        System.out.println(full);
    }
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("welcome to the arithmetic program! (type done at the name prompt to end the program)");
        boolean done = false;
        while (!done) {
            int score = 0;
            System.out.print("enter name : ");
            String name = scan.nextLine();
            if (name.equals("done")) {
                done = true;
                System.out.print("view report? (y/n) : ");
                String view = scan.nextLine();
                if (view.toLowerCase().equals("y")) {
                    System.out.print("enter password : ");
                    String pass = scan.nextLine();
                    if (pass.equals("teacher_password0001")) {
                        report();
                    } else {
                        System.out.println("you are unauthorised!");
                    }
                }
                break;
            }
            System.out.print("enter class : ");
            String Class = scan.nextLine();
            for (int q=0;q < 10;q++) {
                int operation = rand.nextInt(4);
                double a = rand.nextInt(200)+1;
                double b = rand.nextInt(200)+1;
                double result = 0;
                System.out.print(a + " ");
                switch (operation) {
                    case 0:
                        result = a + b;
                        System.out.print("+ ");
                        break;
                    case 1:
                        result = a - b;
                        System.out.print("- ");
                        break;
                    case 2:
                        result = a * b;
                        System.out.print("* ");
                        break;
                    case 3:
                        result = a / b;
                        System.out.print("/ ");
                }
                System.out.print(b + " = ");
                double out = input_double("");
                if (out == result) {
                    System.out.println("correct!");
                    score++;
                } else {
                    System.out.println("incorrect :( ,the answer was  : " + result + "   (not " + out + ")");
                }
            }
            store(name ,Class ,score);
        }
    }
}
