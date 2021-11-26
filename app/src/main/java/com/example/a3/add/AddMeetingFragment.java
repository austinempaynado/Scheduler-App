package com.example.a3.add;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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
    private boolean isStartTime = false;


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



        //Date picker
        binding.dateEditText1.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                isStartDate = true;
                setDate();
            }
        });

        binding.dateEditText2.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                isStartDate = false;
                setDate();
            }
        });


        //Time picker
        binding.timeEditText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStartTime = true;
                setTime();
            }
        });

        binding.timeEditText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStartTime = false;
                setTime();
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
                            binding.dateEditText2.getText().toString(),
                            binding.timeEditText1.getText().toString(),
                            binding.timeEditText2.getText().toString()
                            ));
            }
        });

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setDate(){
        new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);

                String myFormat = "MM/dd/yyyy";
                SimpleDateFormat dateF = new SimpleDateFormat(myFormat, Locale.CANADA);

                if(isStartDate){
                    binding.dateEditText1.setText(dateF.format(calendar.getTime()));
                    binding.dateEditText2.setText(dateF.format(calendar.getTime()));
                }else{
                    binding.dateEditText2.setText(dateF.format(calendar.getTime()));
                }
            }
        },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void setTime(){
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePicker;
        timePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                if(isStartTime){
                    binding.timeEditText1.setText(i + ":" + i1);
                }else{
                    binding.timeEditText2.setText(i +":" + i1);
                }
            }
        }, hour, minute, true);
        timePicker.setTitle("Select Time");
        timePicker.show();
    }


}