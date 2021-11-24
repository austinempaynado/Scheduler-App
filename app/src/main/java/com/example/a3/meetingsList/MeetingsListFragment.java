package com.example.a3.meetingsList;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.a3.R;
import com.example.a3.add.AddMeetingViewModel;
import com.example.a3.databinding.MeetingsListFragmentBinding;

import java.util.ArrayList;

public class MeetingsListFragment extends Fragment {

    private MeetingsListViewModel mViewModel;
    private MeetingsListFragmentBinding binding;

    //add meeting constants
    private AddMeetingViewModel addMeetingViewModel;

    public static MeetingsListFragment newInstance() {
        return new MeetingsListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //Declarations
        addMeetingViewModel =
                new ViewModelProvider(getActivity()).get(AddMeetingViewModel.class);
        mViewModel =
                new ViewModelProvider(getActivity()).get(MeetingsListViewModel.class);

        binding = MeetingsListFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //end of declarations

        if(addMeetingViewModel.meetingTitle !=null){
            //Add meeting
            mViewModel.listItems.add(addMeetingViewModel.meetingTitle);
            addMeetingViewModel.meetingIndex++;
        }

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1,
                mViewModel.listItems);


        binding.MeetingsListView.setAdapter(adapter);



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MeetingsListViewModel.class);
        // TODO: Use the ViewModel
    }

}