package structures;

public class test {
    public static void main(String[] args) {
        stack<String> Stack = new stack<String>();

        Stack.push("pog");
        Stack.push("poggers");
        Stack.push("boggers");
        Stack.push("coggers");
        Stack.push("foggers");
        Stack.push("eggnoggers");
        Stack.push("log");
        Stack.push("loggers");
        Stack.push("cloggers");
        Stack.push("joggers");

        for (int x=0;x<10;x++) {
            System.out.println(Stack.pop());
        }
    }
}