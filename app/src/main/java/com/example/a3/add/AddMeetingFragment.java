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


import com.example.a3.MainActivity;
import com.example.a3.R;
import com.example.a3.databinding.ActivityMainBinding;
import com.example.a3.databinding.AddMeetingFragmentBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

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

        addMeetingViewModel.meetingTitle = null;

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 addMeetingViewModel.meetingTitle = binding.meetingInput.getText().toString();
            }
        });

        return root;
    }


}