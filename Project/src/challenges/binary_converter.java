package challenges;
import java.util.Scanner;

public class binary_converter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        boolean done = false;
        while (true) {
            try {
                System.out.print("denary number : ");
                num = scan.nextInt();
                String Byte = "";
                while (!done) {
                    if (num == 0) {
                        done = true;
                    } else {
                        Byte = String.valueOf(num % 2) + Byte;
                        num = Math.floorDiv(num ,2);
                    }
                }
                while (Byte.length() < 8) {
                    Byte = "0" + Byte;
                }
                System.out.println(Byte);
            } catch (Exception e) {
                System.out.println("error : " + e);
                num = 0;
                done = false;
            }
        }
    }
}
