package OOP;

public class cat extends animal{
    public cat(String name ,int[][] cols ,int age) {
        super(name ,4 ,"meow" ,cols ,true ,"cat" ,age);
    }
    @Override
    public void move() {
        System.out.println("moves 2 spaces");
    }
}
