package OOP;

import OOP.*;

public class test {
    public static void main(String[] args) {
        int[] a = {1 ,1 ,1};
        blob b1 = new blob("blob1" ,a ,a);

        int[][] col = {{206 ,168 ,98}};
        int[][] col2 = {{182 ,150 ,135}};
        int[][] col3 = {{252 ,192 ,218}};
        int[][] col4 = {{252 ,192 ,218}};
        int[][] col5 = {{10 ,10 ,10}};

        animal bubba = new animal("bubba" ,4 ,"woof!" ,col ,true ,"dog" ,5.0d);
        animal mumei = new animal("nanashi mumei" ,2 ,"i forgor..." ,col2 ,false ,"owl" ,12020.0d);
        animal calliope = new animal("calliope mori" ,2 ,"hey! listen!" ,col3 ,false ,"death personified" ,Double.POSITIVE_INFINITY);
        animal gura = new animal("gawr gura" ,2 ,"a" ,col3 ,true ,"shark" ,9000.0d);

        animal[] creatures = {bubba ,mumei ,calliope ,gura};
        for (animal e : creatures) {
            e.getName();
            e.speak();
            e.getAge();
            e.getSpecies();
            e.move();
            System.out.println();
        }

        cat felix = new cat("felix" ,col5 ,5);

        felix.getName();
        felix.speak();
        felix.move();
        felix.getAge();
    }
}
