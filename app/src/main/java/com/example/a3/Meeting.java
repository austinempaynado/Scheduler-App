package com.example.a3;

public class Meeting {
    private final String meetingTitle, description, type, date1, date2;


    public Meeting(String MeetingTitle, String Type ,String Description, String Date1, String Date2){
        this.meetingTitle = MeetingTitle;
        this.type = Type;
        this.description = Description;
        this.date1 = Date1;
        this.date2 = Date2;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return meetingTitle;
    }
}
