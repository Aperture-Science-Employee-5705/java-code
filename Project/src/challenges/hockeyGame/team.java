package challenges.hockeyGame;

import java.util.*;
import java.math.*;
import java.io.*;
import java.util.concurrent.ExecutionException;

public class team {
    private String name;
    private player[] players = {new player("None" ,0 ,0) ,new player("None" ,0 ,0) ,new player("None" ,0 ,0) ,new player("None" ,0 ,0) ,new player("None" ,0 ,0) ,new player("None" ,0 ,0)};

    public team() {
    }

    public String addPlayer(String name ,int att ,int def) {
        for (int x=0;x<6;x++) {
            if (players[x].name() == "None") {
                //System.out.println("found empty slot for " + name + "! ,index : " + x);
                int a = 0;
                int d = 0;
                for (int y=0;y<6;y++) {
                    int[] s = players[y].stats();
                    a += s[0];
                    d += s[1];
                }
                a += att;
                d += def;
                //System.out.println("total attack : " + a + "\ntotal defence : " + d);
                if (a+d > 35) {
                    return "attack/defence overload. ";
                }
                players[x] = new player(name ,att ,def);
                return "success. added player \"" + name + "\"!";
            }
        }
        return "no remaining slots. ";
    }

    private String dupeStr(String str ,int num) {
        return String.join("", Collections.nCopies(num, str));
    }

    public void save(String teamname ,String fpth) {
        String data = teamname + ":";
        for (player p : this.players) {
            data += p.name() + "-" + p.stats()[0] + "-" + p.stats()[1] + "/";
        }

        try {
            FileWriter myWriter = new FileWriter(fpth + teamname + ".txt");
            myWriter.write(data);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void load(String teamname ,String fpth) {
        String data = "";
        try {
            File myObj = new File(fpth + teamname + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        String Data = data.split(":")[1];
        this.name = data.split(":")[0];
        String[] teamdata = Data.split("/");
        int c = 0;
        for (String d : teamdata) {
            String name = d.split("-")[0];
            int att = Integer.valueOf(d.split("-")[1]);
            int def = Integer.valueOf(d.split("-")[2]);
            players[c] = new player(name ,att ,def);
            c++;
        }
    }

    public player getPlayer(String name) throws Exception{
        Scanner scan = new Scanner(System.in);
        player Cplayer = new player("" ,0 ,0);

        for (player p : players) {
            if (p.name().equals(name)) {
                return Cplayer;
            }
        }
        System.out.println("could not find player!");
        throw new Exception();
    }

    public void editPlayer(String name ,player Player) {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;

        int c = 0;
        for (player p : this.players) {
            if (p.name().equals(name)) {
                this.players[c] = Player;
            }
            c++;
        }
    }

    public String summary() {
        String out = "Team summary : \n";
        out += dupeStr("-" ,40) + "\n";//40 "-"'s and a newline1
        out += "Name :          Attack :      Defence :  \n";
        for (player p : this.players) {

            String Name = p.name();
            if (Name.length() > 12) {
                Name = Name.substring(0 ,5) + "...  ";//if name is too long ,keep only the first 5 characters and add a "... " on the end
            }
            int ws = (12-Name.length());
            if (ws < 0) {
                ws = 0;
            }
            Name += "\"" + dupeStr(" " ,ws);//adds the appropriate amount of whitespace after the name

            String attk = String.valueOf(p.stats()[0]);
            ws = (12-attk.length());
            if (ws < 0) {
                ws = 0;
            }
            attk +=  dupeStr(" " ,ws);//adds the appropriate amount of whitespace after the attack

            out += "  \"" + Name + "  " + attk + "  " + p.stats()[1] + "\n";
        }
        int Ta = 0;
        int Td = 0;
        for (int y=0;y<6;y++) {
            int[] s = players[y].stats();
            Ta += s[0];
            Td += s[1];
        }
        int ws = (14-(String.valueOf(Ta)).length());
        if (ws < 0) {
            ws = 0;
        }

        out += "\nTotal : " + dupeStr(" " ,10) + Ta + dupeStr(" " ,ws) + Td + "\n";
        return out;
    }

    public player[] players() {
        return this.players;
    }
}
