package com.example.a3;

public class Meeting {
    String meetingTitle;
    String description;

    public Meeting(String MeetingTitle, String Description){
        this.meetingTitle = MeetingTitle;
        this.description = Description;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return meetingTitle;
    }
}
