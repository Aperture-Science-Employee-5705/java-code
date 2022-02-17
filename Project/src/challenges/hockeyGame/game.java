package challenges.hockeyGame;

import java.awt.*;
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
                Teams[tm].save("team 1", "resources/hockey teams/");
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
                Teams[tm].load(Tname, "resources/hockey teams/");
            }
            System.out.println("Team created!\n\n");
            System.out.println(Teams[tm].summary());
        }

        play();
    }
    public static void play() {
        int user = 0;
        int[] score = {0 ,0};
        boolean done = false;
        boolean valid = false;
        int c = 0;

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String name;
        while (!done) {
            done = false;
            while (!done) {
                done = true;
                try {
                    System.out.print("User " + (user+1) + "! select a player to attack : ");
                    name = scan.nextLine();
                    player player1 = Teams[user].getPlayer(name);
                } catch (Exception e) {
                    done = false;
                    System.out.print("would you like to see a list of the players in this team? (y/n) : ");
                    if (scan.nextLine().equals("y")) {
                        System.out.println(Teams[user].summary());
                    }
                }
            }
            done = false;
            while (!done) {
                done = true;
                try {
                    System.out.print("User " + ((user==0? 1:0)+1) + "! select a player to defend : ");
                    name = scan.nextLine();
                    player player2 = Teams[(user==0? 1:0)].getPlayer(name);
                } catch (Exception e) {
                    done = false;
                    System.out.print("would you like to see a list of the players in this team? (y/n) : ");
                    if (scan.nextLine().equals("y")) {
                        System.out.println(Teams[(user==0? 1:0)].summary());
                    }
                }
            }
            done = false;
            //code

            //code
            user = (user==0? 1:0);
        }
    }
}
