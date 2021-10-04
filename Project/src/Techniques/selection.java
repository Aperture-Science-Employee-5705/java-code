package Techniques;

import java.util.Scanner;
import java.util.LinkedList;

public class selection {
    public static void print(String str) {
        System.out.println(str);
    }
    public static String input(String message) {
        String out;
        print(message);
        Scanner scan = new Scanner(System.in);
        out = scan.nextLine();
        return out;
    }
    public static int input_int(String message) {
        String out;
        print(message);
        Scanner scan = new Scanner(System.in);
        out = scan.nextLine();
        return Integer.parseInt(out);
    }
    public static void main(String[] args) {
        print("welcome to the speeding ticked issue database!");
        print("");

        LinkedList<String> vehicles = new LinkedList<String>();
        LinkedList<Integer> speeds = new LinkedList<Integer>();

        String username = input("username : ");
        String password = input("password : ");
        boolean done = false;
        if ((username.equals("jeff") && (password.equals("Pa55word1234567890")))) {
            while (!done) {
                String reg = input("vehicle registration : ");
                if (reg.equals("done")) {
                    done = true;
                    break;
                }
                int speed = input_int("enter vehicle speed : ");
                if (speed > 70) {
                    print("issue speeding ticket");
                    vehicles.addLast(reg);
                    speeds.addLast(speed);
                } else {
                    print("no ticket issuing needed!");
                }
            }
            print("program ended!");
            for (int x=0;x < vehicles.size();x++) {
                System.out.println(vehicles.get(x) + " : " + speeds.get(x));
            }
        }
    }
}
