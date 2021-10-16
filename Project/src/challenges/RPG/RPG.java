package challenges.RPG;

import java.io.*;
import java.util.*;


public class RPG {
    public static String nameGen() {
        Random rand = new Random();
        String[] sylables = {"en" ,"da" ,"fu" ,"el" ,"kar" ,"tuk" ,"rar" ,"log" ,"dan" ,"a" ,"e" ,"i" ,"o" ,"u" ,"su" ,"se" ,"z" ,"guh" ,"ö" ,"ocr" ,"cer" ,"edig" ,"calli"};
        String out = sylables[rand.nextInt(18)];
        for (int x=0;x < rand.nextInt(6)+2;x++) {
            out += sylables[rand.nextInt(sylables.length)];
            if (rand.nextInt(4) == 0) {
                out += "-";
            }
        }
        /*    good names ive had so far :
        log-ukar
        eldan-tuk
        dani-aotuk
        kar-elloge
        logdaalog
        daniel
        */
        out += sylables[rand.nextInt(14)];
        return out;
    }
    public static String read(String file) {
        try {
            String out = "";
            FileReader readF = new FileReader(file);
            BufferedReader buffR = new BufferedReader(readF);
            Scanner scan = new Scanner(buffR);
            while (scan.hasNextLine()) {
                out += scan.nextLine();
            }
            return out;
        } catch (Exception e) {
            System.out.println(e);
            return e.getMessage();
        }
    }
    public static void write(String file ,String data) {
        try {
            FileWriter writeF = new FileWriter(file);
            BufferedWriter buffW = new BufferedWriter(writeF);
            buffW.write(data);
            buffW.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        List<character> characters = new LinkedList<character>();
        Scanner scan = new Scanner(System.in);

        boolean done = false;
        System.out.println("welcome to the team customisation menu! (type \"help\" to see the commands)\nonce you are done type \"done\" and if you have 10 characters in your team the program will exit\n\n");
        while (!done) {
            System.out.print(">>> ");
            String command = scan.nextLine() + " null";
            if (command.split(" ")[0].equals("add")) {
                if (characters.size() == 10) {
                    System.out.println("you cannot do that! you may only have 10 characters on your team!");
                } else {
                    String name = nameGen();
                    switch (command.split(" ")[1]) {
                        case "barbarian" :
                            characters.add(new barbarian(name ,rand.nextInt(20)+5));
                            System.out.println("successfully added " + name + "!");
                            break;
                        case "elf" :
                            characters.add(new elf(name ,rand.nextInt(20)+5));
                            System.out.println("successfully added " + name + "!");
                            break;
                        case "wizard" :
                            characters.add(new wizard(name ,rand.nextInt(20)+5));
                            System.out.println("successfully added " + name + "!");
                            break;
                        case "dragon" :
                            characters.add(new dragon(name ,rand.nextInt(20)+5));
                            System.out.println("successfully added " + name + "!");
                            break;
                        case "knight" :
                            characters.add(new knight(name ,rand.nextInt(20)+5));
                            System.out.println("successfully added " + name + "!");
                            break;
                        default :
                            System.out.print("error! type not found!\n");
                            scan.nextLine();
                    }
                }
            } else {
                if (command.split(" ")[0].equals("rem")) {
                    boolean contains = false;
                    int index = 0;
                    int c = 0;
                    for (character x : characters) {
                        if (x.getInfo()[0].equals(command.split(" ")[1])) {
                            index = c;
                            contains = true;
                            break;
                        }
                        c++;
                    }
                    if (contains) {
                        characters.remove(index);
                        System.out.println("successfully removed " + command.split(" ")[1] + "!");
                    } else {
                        System.out.println("error! character not found!\n");
                        scan.nextLine();
                    }
                } else {
                    if (command.split(" ")[0].equals("mod")) {
                        boolean contains = false;
                        int c = 0;
                        for (character x : characters) {
                            if (x.getInfo()[0].equals(command.split(" ")[1])) {
                                contains = true;
                                break;
                            }
                            c++;
                        }
                        if (contains) {
                            String stat = command.split(" ")[2];
                            int amnt = Integer.valueOf(command.split(" ")[3]);
                            String[] stats = {"health" ,"power" ,"special attack power" ,"speed"};
                            if (characters.get(c).modify(stat ,amnt)) {
                                System.out.println("successfully modified \"" + stat + "\" stat in character " + command.split(" ")[1] +  "!");
                            } else {
                                System.out.println("error ,this action failed!");
                            }
                        } else {
                            System.out.println("error! character not found!\n");
                            scan.nextLine();
                        }
                    } else {
                        if (command.split(" ")[0].equals("team")) {
                            for (character x : characters) {
                                x.info();
                            }
                        } else {
                            if (command.split(" ")[0].equals("help")) {
                                System.out.println("commands : \nadd  - adds a new character                             (add <character type>)\nrem  - removes a character from the team                (rem <character name>)\nmod  - modifies a character's stat                      (mod <character name> <stat> <amnt>)\ngen  - generates characters for your team until its full\nteam - displays entire team\nexp  - exports data to a file                          (exp <filename>)\nimp  - imports data from a file                        (imp <filename>)\nhelp - displays commands\ndone  - exits program\n\n");
                            } else {
                                if (command.split(" ")[0].equals("gen")) {
                                    String[] types = {"barbarian" ,"elf" ,"wizard" ,"dragon" ,"knight"};
                                    String name;
                                    String type;
                                    while (characters.size() < 10) {
                                        name = nameGen();
                                        type = types[rand.nextInt(5)];
                                        characters.add(new character(name ,type ,rand.nextInt(20)+5));
                                        System.out.println("successfully added " + type + " \"" + name + "\"!");
                                    }
                                } else {
                                    if (command.split(" ")[0].equals("done")) {
                                        if (characters.size() == 10) {
                                            done = true;
                                        } else {
                                            System.out.println("you do not yet have 10 characters!");
                                        }
                                    } else {
                                        if (command.split(" ")[0].equals("exp")) {
                                            String file = command.split(" ")[1];
                                            String out = "";
                                            for (character x : characters) {
                                                out += x.export();
                                            }
                                            write(file ,out.substring(0 ,out.length()-1));
                                        } else {
                                            if (command.split(" ")[0].equals("imp")) {
                                                String file = command.split(" ")[1];
                                                String in = read(file);
                                                characters = new LinkedList<character>();
                                                for (String ln : in.split(";")) {
                                                    String[] params = ln.split(":");
                                                    characters.add(new importchar(params[0] ,params[1] ,Integer.valueOf(params[2]) ,Integer.valueOf(params[3]) ,Integer.valueOf(params[4]) ,Integer.valueOf(params[5])));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.print("\f");
            System.out.flush();
        }
        System.out.println("done!");
    }
}
