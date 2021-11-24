package com.example.a3.add;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a3.R;
import com.example.a3.databinding.AddMeetingFragmentBinding;

public class AddMeetingFragment extends Fragment {

    private AddMeetingViewModel mViewModel;
    private AddMeetingFragmentBinding binding;

    private EditText MeetingTitle;
    private String MeetingTitleText;
    private Button SaveButton;

    public static AddMeetingFragment newInstance() {
        return new AddMeetingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = AddMeetingFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SaveButton = binding.saveButton;

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 MeetingTitleText = MeetingTitle.getText().toString();
                 mViewModel.meetingTitle= MeetingTitleText;
            }
        });

        return root;
    }


}