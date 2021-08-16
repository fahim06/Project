package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class BmiFragment extends Fragment {
    Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        nextButton = getView().findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), BMIActivity.class);
                startActivity(myIntent);
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }
}