package com.example.a3.add;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.a3.Meeting;
import com.example.a3.databinding.AddMeetingFragmentBinding;

public class AddMeetingFragment extends Fragment {


    private AddMeetingViewModel addMeetingViewModel;
    private AddMeetingFragmentBinding binding;


    public static AddMeetingFragment newInstance() {
        return new AddMeetingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        addMeetingViewModel =
                new ViewModelProvider(getActivity()).get(AddMeetingViewModel.class);

        binding = AddMeetingFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setting data
                addMeetingViewModel.Meetings.add(new Meeting(binding.meetingInput.getText().toString(), binding.descEditText.getText().toString()));
            }
        });

        return root;
    }


}