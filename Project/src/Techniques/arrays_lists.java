package Techniques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

public class arrays_lists {
    public static void main(String[] args) {
        String[] s = {"hoi" ,"boi"};
        int[] primes = {2 ,3 ,5 ,7 ,13};
        LinkedList<Integer> nums = new LinkedList<Integer>();
        ArrayList<String> sl = new ArrayList<String>();

        Scanner scan = new Scanner(System.in);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(primes));

        nums.add(Integer.parseInt(scan.nextLine()));
        System.out.println(nums);
        nums.add(Integer.parseInt(scan.nextLine()));
        System.out.println(nums);
        nums.add(Integer.parseInt(scan.nextLine()));
        System.out.println(nums);
        nums.add(Integer.parseInt(scan.nextLine()));
        System.out.println(nums);
        nums.add(Integer.parseInt(scan.nextLine()));
        System.out.println(nums);

        sl.add(scan.nextLine());
        System.out.println(sl);
        sl.add(scan.nextLine());
        System.out.println(sl);
        sl.add(scan.nextLine());
        System.out.println(sl);
        sl.add(scan.nextLine());
        System.out.println(sl);
        sl.add(scan.nextLine());
        System.out.println(sl);
        sl.add(scan.nextLine());
        System.out.println(sl);
    }
}
