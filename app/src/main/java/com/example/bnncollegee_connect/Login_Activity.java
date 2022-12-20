package com.example.bnncollegee_connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login_Activity extends AppCompatActivity {

    private TextView openSignUpPage,openForgetPassword;
    private EditText loginEmail, loginPassword;
    private Button loginBtn;

    private String email,pass;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        openSignUpPage = findViewById(R.id.openSignUpPage);
        loginBtn = findViewById(R.id.loginBtn);
        openForgetPassword = findViewById(R.id.openForgetPassword);



        openSignUpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpPage();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validteData();
            }
        });

        openForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,ForgetPasswordActivity.class));

            }
        });
    }

    private void validteData() {
        email = loginEmail.getText().toString();
        pass = loginPassword.getText().toString();

        if (email.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(this, "Please provide all fields", Toast.LENGTH_SHORT).show();
        }
        else {
            loginUser();
        }
    }

    private void loginUser() {
        auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            openMain();
                        }
                        else
                        {
                            Toast.makeText(Login_Activity.this, "Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login_Activity.this, "Error : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openMain() {
        startActivity(new Intent(Login_Activity.this,MainActivity.class));
        finish();
    }

    private void openSignUpPage() {
        startActivity(new Intent(Login_Activity.this,Register_Activity.class));
        finish();
    }


}