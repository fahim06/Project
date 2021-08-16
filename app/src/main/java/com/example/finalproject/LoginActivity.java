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

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.emailID);
        password = findViewById(R.id.passwordID);
        login = findViewById(R.id.loginButtonID);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = LoginActivity.this.email.getText().toString().trim();
                String password = LoginActivity.this.password.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals(password)) {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        Toast.makeText(LoginActivity.this, "Login", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });
                }
            }
        });
    }

    public void signup_Button(View view) {
        startActivity(new Intent(getApplicationContext(), SignupActivity.class));
    }
}