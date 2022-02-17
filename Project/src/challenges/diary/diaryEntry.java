package challenges.diary;

public class diaryEntry {
    private int month;//the month of the diary entry
    private int day;//the day of the diary entry
    private int time;//the time of the diary entry
    private String entry;//the actual diary entry

    public diaryEntry(int Month ,int Day ,int Time ,String Entry) {
        month = Month;
        day = Day;
        time = Time;
        entry = Entry;
    }

    public void setMonth(int Month){//allows you to set the month of the diary entry
        month = Month;
    }
    public int getMonth(){//allows you to get the month of the diary entry
        return month;
    }


    public void setDay(int Day){//allows you to set the day of the diary entry
        day = Day;
    }
    public int getDay(){//allows you to get the day of the diary entry
        return day;
    }


    public void setTime(int Time){//allows you to set the time of the diary entry
        time = Time;
    }
    public int getTime(){//allows you to get the time of the diary entry
        return time;
    }


    public void setEntry(String Entry){//allows you to set the entry for that 
        entry = Entry;
    }
    public String getEntry(){//allows you to get the enrty for that day
        return entry;
    }

    public String save(){
        return String.valueOf(month) + "`" + String.valueOf(day) + "`" + String.valueOf(time) + "`" + entry;
        //returns a string containing all the internal data that can be parsed when read back from a file
    }
    public void load(String data) {
        //parses the string that the above function outputs and stores the data in the object
        String[] values = data.split("`");
        month = Integer.parseInt(values[0]);
        day = Integer.parseInt(values[1]);
        time = Integer.parseInt(values[2]);
        entry = values[3];
    }
}
