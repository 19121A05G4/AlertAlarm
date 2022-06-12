package com.example.alertalarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button send;
    EditText phoneNo;
    EditText Message;
    String phoneNumber;
    String messageSend;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(), "Please grant permissions to send SMS by configuring settings", Toast.LENGTH_LONG).show();

        }

        send= (Button) findViewById(R.id.buttonSend);
        phoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
        Message = (EditText) findViewById(R.id.editTextSMS);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                phoneNumber = phoneNo.getText().toString();
                messageSend = Message.getText().toString();
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, messageSend, null, null);
                Toast.makeText(getApplicationContext(), "SMS sent", Toast.LENGTH_LONG).show();
            }
        });
    }
}