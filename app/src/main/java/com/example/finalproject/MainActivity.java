package com.example.finalproject;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] Options;
    Spinner mySpinner;
    Fragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Options = getResources().getStringArray(R.array.Options);
        mySpinner = findViewById(R.id.spinnerID);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.Options, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String name = parent.getItemAtPosition(position).toString();
        switch (name) {
            case "Calculator":
                myFragment = new CalculatorFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentID, myFragment).commit();
                break;
            case "BMI Calculator":
                myFragment = new BmiFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentID, myFragment).commit();
                break;
            case "Quiz app":
                myFragment = new QuizFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentID, myFragment).commit();
                break;
            default:
                myFragment = new DefaultFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentID, myFragment).commit();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}