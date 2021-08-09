package com.example.covicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covicare.data.Oxygen_db;
import com.example.covicare.model.Oxygen;


public class oxygen_bottom_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Oxygen_db db2 = new Oxygen_db(oxygen_bottom_data.this);

        Intent intent = getIntent();

        if(intent.getExtras() != null) {
            String itemName = intent.getStringExtra("name");
            String itemmail = intent.getStringExtra("mail");
            String itemPhone = intent.getStringExtra("phone");
            String itemStreet = intent.getStringExtra("street");
            String itemcity = intent.getStringExtra("city");


            Oxygen demo = new Oxygen();
            demo.setdealer_name(itemName);
            demo.setMail(itemmail);
            demo.setPhonenumber(itemPhone);
            demo.setCity(itemcity);
            demo.setStreet(itemStreet);

            db2.addDetails(demo);
        }
    }
}
