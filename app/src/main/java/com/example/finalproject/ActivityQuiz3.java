package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityQuiz3 extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        resultView = findViewById(R.id.resultID);
        Intent myGetIntent = getIntent();
        int number = myGetIntent.getIntExtra(ActivityQuiz2.TotalMarksData, 0);
        resultView.setText("You got " + number + " out of 30");
    }

    public void tryAgainFunction(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

}