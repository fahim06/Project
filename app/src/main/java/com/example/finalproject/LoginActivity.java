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
    EditText txtemail, txtpassword;
    Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtemail = (EditText) findViewById(R.id.email);
        txtpassword = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.btnlogin);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtemail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (password.length() < 6) {

                    Toast.makeText(LoginActivity.this, "Password too short", Toast.LENGTH_SHORT).show();

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

    public void btn_signup(View view) {
        startActivity(new Intent(getApplicationContext(), SignupActivity.class));
    }
}