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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register_Activity extends AppCompatActivity {

    private EditText signupName,signupPhoneno,signupEmail,signupPassword,signupPrn;
    private Button signup;
    private String name, phone, email, pass, prn;
    private FirebaseAuth auth;
    private DatabaseReference reference;
    private DatabaseReference dbRef;

    private TextView openSigninPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        signupName = findViewById(R.id.signupName);
        signupPhoneno = findViewById(R.id.signupPhoneno);
        signupEmail = findViewById(R.id.signupEmail);
        signupPassword = findViewById(R.id.signupPassword);
        signupPrn = findViewById(R.id.signupPrn);
        signup = findViewById(R.id.signup);
        openSigninPage = findViewById(R.id.openSigninPage);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

        openSigninPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignIn();
            }
        });
    }

    private void openSignIn() {

        startActivity(new Intent(Register_Activity.this,Login_Activity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() != null)
        {
            openMain();
        }

    }

    private void openMain() {
        startActivity(new Intent(Register_Activity.this, MainActivity.class));
        finish();
    }


    private void validateData() {

        name = signupName.getText().toString();
        phone = signupPhoneno.getText().toString();
        email = signupEmail.getText().toString();
        pass = signupPassword.getText().toString();
        prn = signupPrn.getText().toString();

        if (name.isEmpty())
        {
            signupName.setError("Required");
            signupName.requestFocus();
        }
        else if (phone.isEmpty())
        {
            signupPhoneno.setError("Required");
            signupPhoneno.requestFocus();
        }
        else if (email.isEmpty())
        {
            signupEmail.setError("Required");
            signupEmail.requestFocus();
        }
        else if (pass.isEmpty())
        {
            signupPassword.setError("Required");
            signupPassword.requestFocus();
        }
        else if (prn.isEmpty())
        {
            signupPrn.setError("Required");
            signupPrn.requestFocus();
        }else {
            creatUser();
        }
    }

    private void creatUser() {
        auth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            uploadData();
                        }else
                        {
                            Toast.makeText(Register_Activity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register_Activity.this, "Error : "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Uploading data of user data to Firebase
    private void uploadData() {
        dbRef = reference.child("users");
        String key = dbRef.push().getKey();

        HashMap<String, String > user = new HashMap<>();
        user.put("key",key);
        user.put("name",name);
        user.put("phone",phone);
        user.put("email",email);
        user.put("password",pass);
        user.put("prn",prn);


        dbRef.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(Register_Activity.this, "Signed Up!", Toast.LENGTH_SHORT).show();
                            openMain();
                        }else {
                            Toast.makeText(Register_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}