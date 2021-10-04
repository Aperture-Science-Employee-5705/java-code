package Techniques;

import java.util.Scanner;

public class casting {
    public static String input(String message) {
        System.out.print(message);
        Scanner scan = new Scanner(System.in);
        String out = scan.nextLine();
        return out;
    }
    public static int input_int(String message) {
        String in = input(message);
        try {
            int out = Integer.parseInt(in);
            return out;
        } catch (NumberFormatException e) {
            System.out.println("error NumberFormatException");
            return Integer.MAX_VALUE;
        }
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

    public static void main(String[] args) {
        System.out.println(input("enter string : "));
        System.out.println(input_int("enter number : "));
        System.out.println(input_double("enter floating point number : "));
    }
}
