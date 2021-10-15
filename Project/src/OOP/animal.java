package OOP;

public class animal {
    private String name;
    private int legs;
    private String sound;
    private int[][] cols;
    private boolean tail;
    private String species;
    private double age;


    public animal(String name ,int legs ,String sound ,int[][] cols ,boolean tail ,String species ,double age) {
        this.name = name;
        this.legs = legs;
        this.sound = sound;
        this.cols = cols;
        this.tail = tail;
        this.species = species;
        this.age = age;
    }
    public void speak() {
        System.out.println(name + " : \"" + sound + "\"");
    }
    public void getName() {
        System.out.println("name : " + name);
    }
    public void getAge() {
        System.out.println(age + " years old");
    }
    public void getSpecies() {
        System.out.println("species : " + species);
    }
    public void move() {
        System.out.println("moves 1 space");
    }
}
