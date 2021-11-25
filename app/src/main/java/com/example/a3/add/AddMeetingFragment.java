package com.example.a3.add;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;


import com.example.a3.MainActivity;
import com.example.a3.Meeting;
import com.example.a3.databinding.AddMeetingFragmentBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddMeetingFragment extends Fragment {


    private AddMeetingViewModel addMeetingViewModel;
    private AddMeetingFragmentBinding binding;

    final Calendar calendar = Calendar.getInstance();
    private boolean isStartDate = false;


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

        DatePickerDialog.OnDateSetListener newDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);

                String myFormat = "MM/dd/yyyy";
                SimpleDateFormat dateF = new SimpleDateFormat(myFormat, Locale.CANADA);

                if(isStartDate){
                    binding.dateEditText1.setText(dateF.format(calendar.getTime()));
                }else{
                    binding.dateEditText2.setText(dateF.format(calendar.getTime()));
                }
            }
        };

        //functions
        binding.dateEditText1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStartDate = true;
                setDate(newDate);
            }
        });

        binding.dateEditText2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStartDate = false;
                setDate(newDate);
            }
        });

        //saving the inputs
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setting data
                    addMeetingViewModel.Meetings.add(new Meeting(binding.meetingInput.getText().toString(),
                            binding.CategorySpinner.getSelectedItem().toString(),
                            binding.descEditText.getText().toString(),
                            binding.dateEditText1.getText().toString(),
                            binding.dateEditText2.getText().toString()));
            }
        });

        return root;
    }

    public void setDate(DatePickerDialog.OnDateSetListener newDate){
        new DatePickerDialog(getActivity(),
                newDate,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}