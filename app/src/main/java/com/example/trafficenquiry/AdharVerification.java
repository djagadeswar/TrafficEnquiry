package com.example.trafficenquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdharVerification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhar_verification);


        final EditText editText =(EditText)findViewById(R.id.AadhaarNumber);
        Button button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num =editText.getText().toString();

                boolean result = Verhoeff.validateVerhoeff(num);
                String mag =String.valueOf(result);


                if (mag == "true"){
                    startActivity(new Intent(getApplicationContext(),KYCverfied.class));

                    Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_LONG).show();
                }else {
                    startActivity(new Intent(getApplicationContext(),KYCnotVerfied.class));

                    Toast.makeText(getApplicationContext(),"Enter valid adhar Number" +
                            "",Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}
