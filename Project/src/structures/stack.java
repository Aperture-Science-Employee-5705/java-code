package structures;
import java.*;
import java.util.LinkedList;

public class stack<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public stack() {
    }

    public void push(T item) {
        list.add(item);
    }
    public T pop() {
        return list.remove(this.size()-1);
    }
    public boolean ifEmpty() {
        return list.size() == 0;
    }
    public int size() {
        return list.size();
    }
}
