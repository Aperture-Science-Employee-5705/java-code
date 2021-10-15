package OOP;

public class blob {
    private String name;
    private int[] coords = {0,0,0};
    private int[] size = {1,1,1};

    public blob(String name ,int[] coords ,int[] size) {
        this.name = name;
        this.coords = coords;
        this.size = size;
    }
}
