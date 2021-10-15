package challenges;
import sun.awt.image.ImageWatched;

import java.util.HashSet;
import java.util.Stack;
import java.util.*;
import java.io.*;

public class sodoku_solver {
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
    public static void printArrayofIntArrays(int[][] input) {
        for (int[] a : input) {
            System.out.println(Arrays.toString(a));
        }
    }
    public static boolean checker(int[][] grid ,boolean IgnoreZeros) {
        //printArrayofIntArrays(grid);
        for (int[] l : grid) {
            HashSet<Integer> h = new HashSet<Integer>();
            int last = 0;
            for (int i : l) {
                h.add(i);
                if (h.size() == last && (i != 0 && IgnoreZeros)) {
                    //System.out.println("failed on horizontal check");
                    //System.out.println(Arrays.toString(l));
                    return false;
                }
                last = h.size();
            }
        }
        int[][] grid2 = {{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0}};
        int ln = 0;
        for (int[] l : grid) {
            for (int c = 0;c < 9;c++) {
                grid2[c][ln] = l[c];
            }
            ln++;
        }
        for (int[] l : grid2) {
            HashSet<Integer> h = new HashSet<Integer>();
            int last = 0;
            for (int i : l) {
                h.add(i);
                if (h.size() == last && (i != 0 && IgnoreZeros)) {
                    //System.out.println("failed on vertical check");
                    //System.out.println(Arrays.toString(l));
                    return false;
                }
                last = h.size();
            }
        }
        for (int sx=0;sx < 3;sx++) {
            for (int sy=0;sy<3;sy++) {
                int[] box = {grid[(3*sx)][(3*sy)] ,grid[(3*sx)+1][(3*sy)] ,grid[(3*sx)+2][(3*sy)] ,grid[(3*sx)][(3*sy)+1] ,grid[(3*sx)+1][(3*sy)+1] ,grid[(3*sx)+2][(3*sy)+1] ,grid[(3*sx)][(3*sy)+2] ,grid[(3*sx)+1][(3*sy)+2] ,grid[(3*sx)+2][(3*sy)+2]};
                HashSet<Integer> h = new HashSet<Integer>();
                int last = 0;
                for (int i : box) {
                    h.add(i);
                    if (h.size() == last && (i != 0 && IgnoreZeros)) {
                        //System.out.println("failed on vertical check");
                        //System.out.println(Arrays.toString(box));
                        return false;
                    }
                    last = h.size();
                }
            }
        }
        return true;
    }
    /*
    NOTES / CHECKLIST :

    //solver will use a stack of game states and a stack of coords
    //checker needs to ignore duplicates of 0
    at each step ,the solver systematically picks a 0 and pushes its coords to the coords stack
    it then sets it to a number starting at 1 ,this game state is then pushed to the stack
    if the checker returns false ,the solver pops the previous value off of the stack and increments the number
    this repeats until either the checker returns true or the solver runs out of options ,in this case it pops TWO states and continues from there
    */
    public static int[][] importGrid(String grid) {
        int[][] out = {{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0} ,{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0}};
        int ln = 0;
        int c = 0;
        for (String x : grid.split(";")) {
            c = 0;
            for (String y : x.split(" ")) {
                out[ln][c] = Integer.parseInt(y);
                c++;
            }
            ln++;
        }
        return out;
    }
    public static int[][] solver(int[][] grid) {
        int[][] out = {{}};
        //temporary note : imitate recursion for now


        return out;
    }
    public static void main(String[] args) throws Exception {
        String gridstring = read("resources/Soduko2.txt");
        int[][] grid1 = importGrid(gridstring);
        System.out.println("starting... ");
        int[][] grid2 = solver(grid1);
        System.out.println("done");
        printArrayofIntArrays(grid2);
    }
}
