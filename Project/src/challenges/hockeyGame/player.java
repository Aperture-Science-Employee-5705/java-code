package challenges.hockeyGame;

import java.util.*;

public class player {
    private String name;
    private int attack;
    private int defence;

    public player(String name ,int att ,int def) {
        this.name = name;
        this.attack = att;
        this.defence = def;
    }

    public String name() {
        return this.name;
    }

    public int[] stats() {
        int[] s = {this.attack ,this.defence};
        return s;
    }
}
