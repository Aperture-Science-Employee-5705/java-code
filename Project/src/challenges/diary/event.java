package challenges.diary;

public class event {
    private String EventName;//the name of the event


    private int StartMonth;//the start month of the event
    private int StartDay;//the start day of the event
    private int StartTime;//the time of the start of the event

    private int EndTime;//the time of the end of the event


    private String EventInfo;//the info for the event (what the event actually intials ,etc...)

    public event(String name ,int start_month ,int start_day ,int start_time ,int end_time ,String event_info) {
        //initialisation of object during definition
        EventName = name;
        StartMonth = start_month;
        StartDay = start_day;
        StartTime = start_time;
        EndTime = end_time;
        EventInfo = event_info;
    }

    public void setName(String name) {//allows you to set the name of the event after definition
        EventName = name;
    }
    public String getName() {//allows you to get the name of the event
        return EventName;
    }


    public void setStartMonth(int month) {//allows you to set the month of the start of the event
        StartMonth = month;
    }
    public int getStartMonth() {//allows you to get the month of the start of the event
        return StartMonth;
    }

    public void setStartDay(int day) {//allows you to set the day of the start of the event
        StartDay = day;
    }
    public int getStartDay() {//allows you to get the day of the start of the event
        return StartDay;
    }

    public void setStartTime(int time) {//allows you to set the time of the start of the event
        StartTime = time;
    }
    public int getStartTime() {//allows you to get the time of the start of the event
        return StartTime;
    }

    public void setEndTime(int time) {//allows you to set the time of the end of the event
        EndTime = time;
    }
    public int getEndTime() {//allows you to get the time of the end of the event
        return EndTime;
    }


    public void setInfo(String info) {//allows you to set the info regarding the event
        EventInfo = info;
    }
    public String getInfo() {//allows you to get the info regarding the event
        return EventInfo;
    }


    public String save(){
        return EventName + "`" + String.valueOf(StartMonth) + "`" + String.valueOf(StartDay) + "`" + String.valueOf(StartTime) + "`" + String.valueOf(EndTime) + "`" + EventInfo;
        //returns a string containing all the internal data that can be parsed when read back from a file
    }
    public void load(String data) {
        //parses the string that the above function outputs and stores the data in the object
        String[] values = data.split("`");
        EventName = values[0];
        StartMonth = Integer.parseInt(values[1]);
        StartDay = Integer.parseInt(values[2]);
        StartTime = Integer.parseInt(values[3]);
        EndTime = Integer.parseInt(values[4]);
        EventInfo = values[5];
    }
}
