package Techniques;

import java.util.Scanner;

public class printing {
    public static void print(String str) {
        System.out.println(str);
    }
    public static void print_int(int i) {
        print(String.valueOf(i));
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
        int i = Integer.parseInt(out);
        return i;
    }
    public static void main(String[] args) {
        print("hello! this is a test!");
        String name = input("what is your name? ");
        print("hello " + name + "!");
    }
}
