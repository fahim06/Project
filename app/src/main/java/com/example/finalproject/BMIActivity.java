package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    EditText inputHeight, inputWeight;
    RadioGroup radioGroup;
    double height, weight, result;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputHeight = findViewById(R.id.heightID);
        inputWeight = findViewById(R.id.weightID);
        radioGroup = findViewById(R.id.radioGroupID);
        output = findViewById(R.id.outputID);
    }

    public void Calculation(View view) {
        height = Double.parseDouble(inputHeight.getText().toString());
        weight = Double.parseDouble(inputWeight.getText().toString());

        if (radioGroup.getCheckedRadioButtonId() == R.id.inputCmID) {
            height = height / 100;
            result = weight / (height * height);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.inputInchID) {
            height = height / 39.37;
            result = weight / (height * height);
        }
        output.setText("BMI is: " + String.format("%.3f", result));
        if (result >= 18.5 && result <= 24.9) {
            Toast.makeText(BMIActivity.this, "You are Healthy", Toast.LENGTH_LONG).show();
        } else if (result >= 25) {
            Toast.makeText(BMIActivity.this, "You are Overweight", Toast.LENGTH_LONG).show();
        }
    }


    public void next3(View view) {
        Intent myIntent = new Intent(this, ActivityQuiz1.class);
        startActivity(myIntent);
    }


}
