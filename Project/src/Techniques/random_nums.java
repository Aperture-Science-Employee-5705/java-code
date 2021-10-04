package Techniques;

import java.util.Random;

public class random_nums {
    public static void main(String[] args) {
        Random randgen = new Random();
        while (true) {
            System.out.println(randgen.nextInt(6)+1);
        }
    }
}
