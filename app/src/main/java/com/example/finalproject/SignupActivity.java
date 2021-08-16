package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    EditText txtemail, txtpassword, txtconfirmPassword;
    Button signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtemail = (EditText) findViewById(R.id.email);
        txtpassword = (EditText) findViewById(R.id.password);
        txtconfirmPassword = (EditText) findViewById(R.id.cpassword);
        signup = (Button) findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtemail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();
                String cpassword = txtconfirmPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(SignupActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(SignupActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(cpassword)) {

                    Toast.makeText(SignupActivity.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (password.length() < 6) {

                    Toast.makeText(SignupActivity.this, "Password too short", Toast.LENGTH_SHORT).show();

                }

                if (password.equals(cpassword)) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        Toast.makeText(SignupActivity.this, "Sign UP Successful", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(SignupActivity.this, "Error", Toast.LENGTH_SHORT).show();

                                    }


                                }
                            });
                }
            }
        });

    }
}