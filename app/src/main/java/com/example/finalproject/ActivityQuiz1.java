package com.example.finalproject;

import static com.example.finalproject.ActivityQuiz2.TotalMarksData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityQuiz1 extends AppCompatActivity {
    static String MarkData = "From activity 1";
    RadioGroup myRadioGroup1, myRadioGroup2, myRadioGroup3;
    int marks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent myIntent = getIntent();
        MarkData = TotalMarksData;
        marks = myIntent.getIntExtra(MarkData, 0);
        myRadioGroup1 = findViewById(R.id.question1RadioGroup);
        myRadioGroup2 = findViewById(R.id.question2RadioGroup);
        myRadioGroup3 = findViewById(R.id.question3RadioGroup);
    }

    public void NextFunction(View view) {

        if (myRadioGroup1.getCheckedRadioButtonId() == R.id.question1option1) {
            marks += 5;
        }
        if (myRadioGroup2.getCheckedRadioButtonId() == R.id.question2option3) {
            marks += 5;
        }
        if (myRadioGroup3.getCheckedRadioButtonId() == R.id.question3option2) {
            marks += 5;
        }
        Intent myIntent = new Intent(this, ActivityQuiz2.class);
        myIntent.putExtra(MarkData, marks);
        startActivity(myIntent);

    }


    public void SubmitFunction(View view) {
        if (myRadioGroup1.getCheckedRadioButtonId() == R.id.question1option1) {
            marks += 5;
        }
        if (myRadioGroup2.getCheckedRadioButtonId() == R.id.question2option3) {
            marks += 5;
        }
        if (myRadioGroup3.getCheckedRadioButtonId() == R.id.question3option2) {
            marks += 5;
        }
        Intent myIntent = new Intent(this, ActivityQuiz3.class);
        myIntent.putExtra(MarkData, marks);
        startActivity(myIntent);
    }
}