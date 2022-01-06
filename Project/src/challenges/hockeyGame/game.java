package challenges.hockeyGame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class game {
    static team[] Teams = {new team() ,new team()};
    public static void main(String[] args) {

        String msg = "";
        String name = "";
        int att = 0;
        int def = 0;
        boolean valid = false;
        int c = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("view saved game reports? (y/n) : ");
        if (scan.nextLine().equals("y")) {
            System.out.print("enter team name : ");
            String team = scan.nextLine();
            String data = "";
            try {
                data = "";
                FileReader readF = new FileReader("resources/hockey/results.txt");
                BufferedReader buffR = new BufferedReader(readF);
                Scanner scan2 = new Scanner(buffR);
                while (scan.hasNextLine()) {
                    data += scan.nextLine();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            for (String ln : data.split("\\n")) {
                String[] tms = ln.split(" : ")[0].split(" vs ");
                if (tms[0].equals(team) || tms[1].equals(team)) {
                    System.out.println(ln);
                }
            }
        } else {

            String teamNames[] = {"" ,""};
            for (int tm=0;tm<2;tm++) {
                System.out.println("Team " + tm+1 + " : ");

                String LC = "";
                while ((!valid)) {
                    System.out.print("Load an existing team or Create a new one? (L/C) : ");
                    LC = scan.nextLine();
                    valid = ((LC.equals("L")) || (LC.equals("C")));
                }

                if (LC.equals("C")) {
                    while (!(msg.split("\\.")[0].equals("no remaining slots"))) {
                        // \\. works because the input to the .ssplit is a regex and the . means everything in regex ,so i have to show its not a normal space with an escape character ,but java doesnt recognise it and throws an error so i have to put 2 ,but it works
                        System.out.print("Team member [" + c + "] : \nenter player name : ");
                        name = scan.nextLine();
                        System.out.print("enter player attack level : ");
                        att = Integer.parseInt(scan.nextLine());//TODO handle errors here
                        System.out.print("enter player defence level : ");
                        def = Integer.parseInt(scan.nextLine());

                        if (att < 0 || att > 10) {
                            System.out.println("error! attack must be an integer between 0 and 10 ,not " + att + "!");
                            valid = false;
                        }
                        if (def < 0 || def > 7) {
                            System.out.println("error! defence must be an integer between 0 and 7 ,not " + att + "!");
                            valid = false;
                        }

                        if (valid) {
                            msg = Teams[tm].addPlayer(name, att, def);
                            System.out.println(msg);
                            if (!(msg.split("\\.")[0].equals("no remaining slots"))) {
                                c++;
                            }
                        }
                    }
                    System.out.print("enter team name : ");
                    Teams[tm].save("team 1", "resources/hockey/");
                } else {
                    valid = false;
                    String Tname = "";
                    while (!(valid)) {
                        System.out.print("enter team name : ");
                        Tname = scan.nextLine();
                        if (Tname.equals(teamNames[0])) {
                            System.out.println("error ,you cannot load the same team twice!");
                        } else {
                            valid = true;
                        }
                    }
                    teamNames[tm] = Tname;
                    Teams[tm].load(Tname, "resources/hockey/");
                }
                System.out.println("Team created!\n\n");
                System.out.println(Teams[tm].summary());
            }

            play();

            System.out.print("view leaderboards? (y/n) : ");
            if (scan.nextLine().equals("y")) {
                String data = "";
                try {
                    data = "";
                    FileReader readF = new FileReader("resources/hockey/results.txt");
                    BufferedReader buffR = new BufferedReader(readF);
                    Scanner scan2 = new Scanner(buffR);
                    while (scan.hasNextLine()) {
                        data += scan.nextLine();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }                    
                //TODO sort by num of goals (top 3) (ascending)
                int team1goals = 0;//i only have two teams right now ("team1" and "team2") and as it says below im hardcoding it because ive run out of time
                int team2goals = 0;
                for (String ln : data.split("\\n")) {//dont have time to do this the right way ,so im gonna have to hardcode it
                    if (ln.split(" : ")[0].split(" vs ")[0].equals("team1")) {
                        team1goals += Integer.parseInt(ln.split(" : ")[1].split(" - ")[0]);
                        team2goals += Integer.parseInt(ln.split(" : ")[1].split(" - ")[1]);
                    } else {
                        team1goals += Integer.parseInt(ln.split(" : ")[1].split(" - ")[1]);
                        team2goals += Integer.parseInt(ln.split(" : ")[1].split(" - ")[0]);
                    }
                }
                String out = ((team1goals>team2goals)?"team1":"team2") + " : " ((team1goals>team2goals)?team1goals:team2goals) + "\n" + ((team1goals>team2goals)?"team2":"team1") + " : " ((team1goals>team2goals)?team2goals:team1goals);
                System.out.println(out);
                System.out.print("save file? (y/n) : ");
                if (scan.nextLine().equals("y")) {
                    System.out.print("filename : ");
                    fn = scan.nextLine();
                    try {
                        FileWriter writeF = new FileWriter("resources/hockey/" + fn + ".txt");
                        BufferedWriter buffW = new BufferedWriter(writeF);
                        buffW.write(data + "\n" + (Teams[0].name + " vs " + Teams[1].name + " : " + score[0] + " - " + score[1]));
                        buffW.close();
                        System.out.println("file saved!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                //TODO sort by num of conceded goals (top 3) (descending)
                
            }
        }
    }
    public static void play() {
        boolean player1attack = false;
        int[] score = {0 ,0};
        boolean done = false;
        boolean valid = false;
        int c = 0;

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        player player1 = new player("" ,0 ,0);
        player player2 = new player("" ,0 ,0);

        Set<String> takenPenalties1 = new HashSet<String>();
        Set<String> takenPenalties2 = new HashSet<String>();
        while (!done) {
            while (!valid) {
                valid = true;
                try {
                    System.out.print("user 1 ,enter name of " + (player1attack? "attacking":"defending") + " player : ");
                    player1 = Teams[0].getPlayer(scan.nextLine());
                } catch (Exception e) {
                    valid = false;
                }
            }
            valid = false;
            while (!valid) {
                valid = true;
                try {
                    System.out.print("user 2 ,enter name of " + (player1attack? "defending":"attacking") + " player : ");
                    player2 = Teams[1].getPlayer(scan.nextLine());
                } catch (Exception e) {
                    valid = false;
                }
            }
            valid = false;

            if (player1attack) {
                int r = rand.nextInt(3);
                if (player2.stats()[1]-player1.stats()[0]+r < 0) {
                    System.out.println("saved!");
                } else {
                    System.out.println("scored!");
                    score[0]++;
                }
            } else {
                int r = rand.nextInt(3);
                if (player1.stats()[1]-player2.stats()[0]+r < 0) {
                    System.out.println("saved!");
                } else {
                    System.out.println("scored!");
                    score[1]++;
                }
            }

            System.out.println("score is now : [ " + score[0] + " - " + score[1] + " ] !\n");
            player1attack = !player1attack;

            takenPenalties1.add(player1.name());
            takenPenalties2.add(player2.name());
            //a set can only contain 1 copy of each unique item ,trying to add the same item twice will not add anything
            //therefore ,if both have a length of 6 ,ll players on each team have taken penalties ,therefore the game is over

            done = ((takenPenalties1.size() == 6) && (takenPenalties2.size() == 6));
        }

        if (score[0] == score[1]) {
            System.out.println("Draw!");
        } else {
            System.out.println(((score[0]>score[1])? "user 1 won!":"user 2 won!"));
        }

        //messy code i copied from elsewhere ; it gets the job done.
        String data = "";
        try {
            data = "";
            FileReader readF = new FileReader("resources/hockey/results.txt");
            BufferedReader buffR = new BufferedReader(readF);
            Scanner scan2 = new Scanner(buffR);
            while (scan.hasNextLine()) {
                data += scan.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            FileWriter writeF = new FileWriter("resources/hockey/results.txt");
            BufferedWriter buffW = new BufferedWriter(writeF);
            buffW.write(data + "\n" + (Teams[0].name + " vs " + Teams[1].name + " : " + score[0] + " - " + score[1]));
            buffW.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
