package Techniques;

import java.util.Random;

public class iteration {
    public static String randomiseCase(String str) {
        String out = "";
        String Astr[] = str.split("");
        Random random = new Random();
        for (String s : Astr) {
            boolean r = random.nextBoolean();
            if (r) {
                out += String.valueOf(s).toUpperCase();
            } else {
                out += String.valueOf(s).toLowerCase();
            }
        }
        return out;
    }

    public static void main(String[] args) {
        for (int x=0;x < 10;x++) {
            System.out.println(x);
        }
        String[] programmingLanguages = {"python" ,"C" ,"C++" ,"java" ,"BASIC" ,"assembly" ,"php" ,"pearl"};
        for (String x : programmingLanguages) {
            System.out.println(x);
        }
        boolean done = false;
        Random random = new Random();
        while (!done) {
            int r = random.nextInt();
            if (r > -300000 && r < 300000) {
                done = true;
            }
            System.out.println(r);
        }
        final String spam = "spam";
        while (true) {
            System.out.println(randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam) + " " + randomiseCase(spam));
        }
    }
}
