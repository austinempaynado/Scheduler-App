package com.example.a3.add;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.a3.MeetingObject;
import com.example.a3.databinding.AddMeetingFragmentBinding;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
                //setting data
                addMeetingViewModel.meetingIndex++;
                addMeetingViewModel.meetingTitle = binding.meetingInput.getText().toString();
                addMeetingViewModel.meetingDesc = binding.descEditText.getText().toString();

                try {
                    Class meetingClass = Class.forName("com.example.a3.MeetingObject");
                    Object meeting = meetingClass.getConstructor(String.class, String.class).newInstance(addMeetingViewModel.meetingTitle, addMeetingViewModel.meetingDesc);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        });

        return root;
    }


}