package com.example.trafficenquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class policeCheck extends AppCompatActivity {
    TextView click,AadhaarCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_check);



        click = findViewById(R.id.click);
        AadhaarCheck = findViewById(R.id.AadharCheck);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FingerPrint.class));
            }
        });
        AadhaarCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AdharVerification.class));
            }
        });
    }
}