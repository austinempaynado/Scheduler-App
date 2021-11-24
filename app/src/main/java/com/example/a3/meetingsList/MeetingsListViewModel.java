package com.example.a3.meetingsList;

import android.app.Application;
import android.widget.ArrayAdapter;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MeetingsListViewModel extends ViewModel {
    ArrayList<String> listItems = new ArrayList<String>();
}