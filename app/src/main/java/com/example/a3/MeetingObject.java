package com.example.a3;

public class MeetingObject {
    String MeetingTitle;
    String Description;

    public MeetingObject(String MeetingTitle, String Description){
        MeetingTitle = MeetingTitle;
        Description = Description;
    }

    public String getTitle(){
        return this.MeetingTitle;
    }
}
