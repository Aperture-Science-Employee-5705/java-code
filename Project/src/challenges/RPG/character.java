package challenges.RPG;

import java.util.Locale;
import java.util.Arrays;

public class character {
    private String name;
    private String type;
    private int health;
    private int power;
    private int specialAttackPower;
    private int speed;

    public character(String name ,String type ,int health) {
        this.name = name;
        this.type = type.toLowerCase(Locale.ROOT);
        this.health = health;

        String[] types = {"barbarian" ,"elf" ,"wizard" ,"dragon" ,"knight"};
        int[][] ratings = {{70 ,30 ,50 ,90 ,60} ,{20 ,60 ,70 ,40 ,10} ,{50 ,10 ,30 ,50 ,60}};
        int i = Arrays.asList(types).indexOf(type);

        this.power = ratings[0][i];
        this.specialAttackPower = ratings[1][i];
        this.speed = ratings[2][i];
    }
    public String[] getInfo() {
        String[] out = {name ,type ,String.valueOf(health) ,String.valueOf(power) ,String.valueOf(specialAttackPower) ,String.valueOf(speed)};
        return out;
    }
    public void info() {
        System.out.println("--------------------------------------------\n" + name + "\n\ntype : " + type + "\nhealth : " + health + "\n\npower : " + power + "\nspecial attack power : " + specialAttackPower + "\nspeed : " + speed + "\n--------------------------------------------\n");
    }
    public String export() {
        return name + ":" + type + ":" + health + ":" + power + ":" + specialAttackPower + ":" + speed + ";";
    }
    public boolean modify(String stat ,int amnt) {
        if (amnt > 0) {
            switch (stat) {
                case "health" :
                    health = amnt;
                    break;
                case "power" :
                    power = amnt;
                    break;
                case "special-attack-power" :
                    specialAttackPower = amnt;
                    break;
                case "speed" :
                    speed = amnt;
                    break;
                default :
                    return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
