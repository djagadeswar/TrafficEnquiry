package com.example.trafficenquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class policeLogin extends AppCompatActivity {
   private EditText stationCode,stationPassword;
   private Button policelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);



        stationCode = findViewById(R.id.stationCode);
        stationPassword = findViewById(R.id.stationPassword);
        policelogin = findViewById(R.id.policeLogin);

        policelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(stationCode.getText().toString(),stationPassword.getText().toString());
            }
        });
    }
    private void validate(String policecode, String policePassword){
        if ((policecode.equals("station1")&&(policePassword.equals("1111")))){

            Intent intent = new Intent(policeLogin.this,policeCheck.class);
            startActivity(intent);
        }else {
            Toast.makeText(policeLogin.this,"invalid username/password",Toast.LENGTH_LONG).show();
        }
    }
}
