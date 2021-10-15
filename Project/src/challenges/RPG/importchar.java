package challenges.RPG;

public class importchar extends character {
    public importchar (String name ,String type ,int health ,int power ,int specialPWR ,int speed){
        super(name ,type ,health);
        this.modify("power" ,power);
        this.modify("special-attack-power" ,specialPWR);
        this.modify("speed" ,speed);
    }
}
