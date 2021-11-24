package com.example.a3.meetingsList;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.example.a3.R;
import com.example.a3.add.AddMeetingViewModel;
import com.example.a3.databinding.MeetingsListFragmentBinding;

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

        addMeetingViewModel =
                new ViewModelProvider(getActivity()).get(AddMeetingViewModel.class);

        binding = MeetingsListFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MeetingsListViewModel.class);
        // TODO: Use the ViewModel
    }

}