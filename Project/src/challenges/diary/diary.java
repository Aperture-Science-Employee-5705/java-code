package challenges.diary;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.StandardSocketOptions;
import java.util.*;

public class diary {
    private static ArrayList<event> events = new ArrayList<>();//creates an array list of events
    private static ArrayList<diaryEntry> entries = new ArrayList<>();//creates an array list of entries
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the diary/event calendar menu!\nuse the \"help\" command to see a list of all the availiable commands!\n\n");
        boolean done = false;
        int month = 0;
        int day = 0;
        int time = 0;
        int counter = 0;
        int currentYear = 22;
        String filename;
        String input = "";
        while(!done) {
            System.out.print("enter command! >>> ");
            input = scan.nextLine();

            switch (input) {
                case "create"://creates an entry
                    System.out.print("create diary entry or event? (diary/event) : ");
                    boolean Return = false;
                    switch (scan.nextLine()) {
                        case "event"://create event
                            System.out.print("enter name : ");//get relavant information
                            String name = scan.nextLine();
                            System.out.print("enter start month : ");
                            int start_month = Integer.parseInt(scan.nextLine());//i was getting a glitch with .nextInt where it would basically skip the next .nextLine ,not allowing you to enter the final piece of information
                            System.out.print("enter start day : ");
                            int start_day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter start hour : ");
                            int start_time = Integer.parseInt(scan.nextLine());
                            System.out.print("enter end hour : ");
                            int end_time = Integer.parseInt(scan.nextLine());
                            System.out.print("enter event info : ");
                            String info = scan.nextLine();
                            System.out.println("got all event info!");

                            //check that no other event with the same timestamp exists
                            Return = false;
                            for (event e : events) {
                                if ((e.getStartMonth() == start_month) && (e.getStartDay() == start_day) && (e.getStartTime() == start_time)) {//if the timestamp is the same
                                    Return = true;
                                    System.out.println("error : another entry with the same timestamp already exists!");
                                    break;
                                }
                            }
                            if (Return) {
                                break;
                            }

                            event e = new event(name ,start_month ,start_day ,start_time ,end_time ,info);//create event object
                            events.add(e);//add event
                            System.out.println("event added!");
                            break;
                        case "diary"://create diary entry
                            //get relavant information
                            System.out.print("enter month : ");
                            month = Integer.parseInt(scan.nextLine());
                            System.out.print("enter day : ");
                            day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter hour : ");
                            time = Integer.parseInt(scan.nextLine());
                            System.out.print("enter diary entry : ");
                            String entry = scan.nextLine();

                            //check that no other event with the same timestamp exists
                            Return = false;
                            for (diaryEntry d : entries) {
                                if ((d.getMonth() == month) && (d.getDay() == day) && (d.getTime() == time)) {//if the timestamp is the same
                                    Return = true;
                                    System.out.println("error : another entry with the same timestamp already exists!");
                                    break;
                                }
                            }
                            if (Return) {
                                break;
                            }

                            diaryEntry d = new diaryEntry(month ,day ,time ,entry);//create entry object
                            entries.add(d);//add event
                            System.out.println("entry added!");
                            break;
                        default:
                            System.out.println("unknown option!");
                    }
                    break;
                case "delete"://deletes an entry
                    System.out.print("delete diary entry or event? (diary/event) : ");
                    switch (scan.nextLine()) {

                        case "event"://delete event
                            if (events.size() == 0) {
                                System.out.println("No entries!");
                                break;
                            }
                            System.out.print("enter month : ");
                            month = Integer.parseInt(scan.nextLine());
                            System.out.print("enter day : ");
                            day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter hour : ");
                            time = Integer.parseInt(scan.nextLine());

                            counter = 0;
                            for (event e : events) {
                                if ((e.getStartMonth() == month) && (e.getStartDay() == day) && (e.getStartTime() == time)) {//if the timestamp is the same
                                    events.remove(counter);//delete item and end for loop
                                    break;
                                }
                                counter ++;
                            }
                            break;
                        case "diary"://delete diary entry
                            if (events.size() == 0) {
                                System.out.println("No entries!");
                                break;
                            }
                            System.out.print("enter month : ");
                            month = Integer.parseInt(scan.nextLine());
                            System.out.print("enter day : ");
                            day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter hour : ");
                            time = Integer.parseInt(scan.nextLine());

                            counter = 0;
                            for (diaryEntry d : entries) {
                                if ((d.getMonth() == month) && (d.getDay() == day) && (d.getTime() == time)) {//if the timestamp is the same
                                    entries.remove(counter);//delete item and end for loop
                                    break;
                                }
                                counter ++;
                            }
                            break;
                    }
                    break;
                case "modify"://modifies an entry
                    System.out.print("modify diary entry or event? (diary/event) : ");
                    switch (scan.nextLine()) {
                        case "event"://modify event
                            if (events.size() == 0) {
                                System.out.println("No entries!");
                                break;
                            }
                            System.out.print("enter month : ");
                            month = Integer.parseInt(scan.nextLine());
                            System.out.print("enter day : ");
                            day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter hour : ");
                            time = Integer.parseInt(scan.nextLine());

                            counter = 0;
                            for (event x : events) {
                                if ((x.getStartMonth() == month) && (x.getStartDay() == day) && (x.getStartTime() == time)) {//if the timestamp is the same
                                    event e = x;
                                    String timestamp = String.valueOf(x.getStartDay()) + "/" + String.valueOf(x.getStartMonth()) + "/" + String.valueOf(currentYear) + " " + String.valueOf(x.getStartTime()) + ":00 until " + String.valueOf(x.getEndTime()) + ":00";
                                    //constructs a timestamp in the format : "<day>/<month>/<currentYear> <StartTime>:00 until <EndTime>:00"
                                    System.out.println("[" + timestamp + "]\t:\t" + x.getName() + " : " + x.getInfo());//prints the event and its information
                                    break;
                                }
                                counter ++;
                            }
                            System.out.print("enter new name : ");//get relavant information
                            String name = scan.nextLine();
                            System.out.print("enter new start month : ");
                            int start_month = Integer.parseInt(scan.nextLine());
                            System.out.print("enter new start day : ");
                            int start_day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter new start hour : ");
                            int start_time = Integer.parseInt(scan.nextLine());
                            System.out.print("enter new end hour : ");
                            int end_time = Integer.parseInt(scan.nextLine());
                            System.out.print("enter new event info : ");
                            String info = scan.nextLine();

                            events.get(counter).setName(name);//reset values
                            events.get(counter).setStartMonth(start_month);
                            events.get(counter).setStartDay(start_day);
                            events.get(counter).setStartTime(start_time);
                            events.get(counter).setEndTime(end_time);
                            events.get(counter).setInfo(info);

                            break;
                        case "diary"://modify event
                            if (events.size() == 0) {
                                System.out.println("No entries!");
                                break;
                            }
                            System.out.print("enter month : ");
                            month = Integer.parseInt(scan.nextLine());
                            System.out.print("enter day : ");
                            day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter hour : ");
                            time = Integer.parseInt(scan.nextLine());

                            counter = 0;
                            for (diaryEntry x : entries) {
                                if ((x.getMonth() == month) && (x.getDay() == day) && (x.getTime() == time)) {//if the timestamp is the same
                                    diaryEntry d = x;
                                    String timestamp = String.valueOf(x.getDay()) + "/" + String.valueOf(x.getMonth()) + "/" + String.valueOf(currentYear) + " " + String.valueOf(x.getTime()) + ":00";
                                    //constructs a timestamp in the format : "<day>/<month>/<currentYear> <StartTime>:0"
                                    System.out.println("[" + timestamp + "]\t:\t" + x.getEntry());//prints the diaey entry and its information
                                    break;
                                }
                                counter ++;
                            }
                            //get relavant information
                            System.out.print("enter new month : ");
                            month = Integer.parseInt(scan.nextLine());
                            System.out.print("enter new day : ");
                            day = Integer.parseInt(scan.nextLine());
                            System.out.print("enter new hour : ");
                            time = Integer.parseInt(scan.nextLine());
                            System.out.print("enter new diary entry : ");
                            String entry = scan.nextLine();

                            //reset values
                            entries.get(counter).setMonth(month);
                            entries.get(counter).setDay(day);
                            entries.get(counter).setTime(time);
                            entries.get(counter).setEntry(entry);

                            break;
                    }
                    break;
                case "view"://views the events
                    System.out.print("view diary or events? (diary/events) : ");
                    switch (scan.nextLine()) {
                        case "events"://view all events
                            if (events.size() == 0){
                                System.out.println("No entries!");
                                break;
                            }
                            for (event x : events) {//loops over all the events
                                String timestamp = String.valueOf(x.getStartDay()) + "/" + String.valueOf(x.getStartMonth()) + " " + String.valueOf(x.getStartTime()) + ":00 until " + String.valueOf(x.getEndTime()) + ":00";
                                //constructs a timestamp in the format : "<day>/<month>/<currentYear> <StartTime>:00 until <EndTime>:00"
                                System.out.println("[" + timestamp + "]\t:\t" + x.getName() + " : " + x.getInfo());//prints the event and its information
                            }
                            System.out.println("\n");
                            break;
                        case "diary":
                            if (entries.size() == 0){
                                System.out.println("No entries!");
                                break;
                            }
                            for (diaryEntry x : entries) {//loops over all the diary entries
                                String timestamp = String.valueOf(x.getDay()) + "/" + String.valueOf(x.getMonth()) + "/" + String.valueOf(currentYear) + " " + String.valueOf(x.getTime()) + ":00";
                                //constructs a timestamp in the format : "<day>/<month>/<currentYear> <StartTime>:00 until <EndTime>:00"
                                System.out.println("[" + timestamp + "]\t:\t" + x.getEntry());//prints the diary entry and its information
                            }
                            System.out.println("\n");
                            break;
                        default:
                            System.out.println("error! invalid option! (was expecting either \"diary\" or \"events\" !)");
                    }
                    break;
                case "help"://prints the help menu
                    System.out.println("----------------------------------------------------------------------------\nHelp menu!\n\nhelp  : prints the help menu\ncreate : opens the create menu\ndelete : opens the deletion menu\nmodify : opens the modification menu\nview  : views calendar or diary entries\nsave  : allows you to save all events or diary entries to a file\nload  : allows you to load events and diary entries back from a file\n\n");
                    break;
                case "save":
                    filename = "";
                    String savestring = "";
                    System.out.print("save diary or events? (diary/events) : ");
                    switch (scan.nextLine()) {
                        case "diary":
                            System.out.print("enter filepath : ");
                            filename = scan.nextLine();
                            for (diaryEntry d : entries) {
                                savestring += d.save() + "¬";//build up a string of encoded data that can be spilt back up and reloaded later
                            }
                            savestring = savestring.substring(0 ,savestring.length()-1);
                            write(filename ,savestring);
                            break;
                        case "events":
                            System.out.print("enter filepath : ");
                            filename = scan.nextLine();
                            for (event e : events){
                                savestring += e.save() + "¬";//build up a string of encoded data that can be spilt back up and reloaded later
                            }
                            savestring = savestring.substring(0 ,savestring.length()-1);
                            break;
                        default:
                            System.out.println("error ,invalid option!");
                    }
                    break;
                case "load":
                    filename = "";
                    String file;
                    System.out.print("save diary or events? (diary/events) : ");
                    switch (scan.nextLine()) {
                        case "diary":
                            System.out.print("enter filepath : ");
                            filename = scan.nextLine();
                            file = read(filename);
                            for (String code : file.split("¬")) {//run over each individual code in the file for each object
                                diaryEntry d = new diaryEntry(0,0,0,"empty");
                                d.load(code);//create an empty object and load in the code
                                entries.add(d);
                            }
                            break;
                        case "events":
                            System.out.print("enter filepath : ");
                            filename = scan.nextLine();
                            file = read(filename);
                            for (String code : file.split("¬")) {//run over each individual code in the file for each object
                                event e = new event("none",0,0,0,0,"empty");
                                e.load(code);//create an empty object and load in the code
                                events.add(e);
                            }
                            break;
                        default:
                            System.out.println("error ,invalid option!");
                    }
                    break;
                default://unknown command
                    System.out.println("unknown command!");
            }
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
}


