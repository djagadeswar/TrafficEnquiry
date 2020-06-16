package com.example.trafficenquiry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mcreateBtn,forgotPassword;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail  = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        mcreateBtn = findViewById(R.id.createText);

        //reset password

        forgotPassword   =  findViewById(R.id.forgotPassword);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        String email=mEmail.getText().toString().trim();
        String password=mPassword.getText().toString().trim();

        if(TextUtils.isEmpty((email))){

        mEmail.setError("Email is required");
        return;
        }

        if (TextUtils.isEmpty(password)) {
        mPassword.setError("password is required");
        return;
        }
        if (password.length()  <  6){
        mPassword.setError("enter more than 6 Characters");
        return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // verifying from the database

        fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {

        if(task.isSuccessful()){
        Toast.makeText(Login.this, "logged sucessfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }else {
        Toast.makeText(Login.this, "ERROR !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
        }
        }
        });

        }
        });

        mcreateBtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),Register.class));
        }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

final EditText resetMail = new EditText(v.getContext());
        AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
        passwordResetDialog.setTitle("Reset Pasword");
        passwordResetDialog.setMessage("Enter your email to reset password");
        passwordResetDialog.setView(resetMail);

        passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {

        //take email adress and send the link to register email

        String mail = resetMail.getText().toString();
        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
@Override
public void onSuccess(Void aVoid) {
        Toast.makeText(Login.this,"Reset link Sent to Your Email",Toast.LENGTH_SHORT).show();

        }
        }).addOnFailureListener(new OnFailureListener() {
@Override
public void onFailure(@NonNull Exception e) {
        Toast.makeText(Login.this,"enter vaild Email" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        });


        }
        });
        passwordResetDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        //nothing(close the dialog)
        }
        });
        passwordResetDialog.create().show();
        }
        });

        }
        }
