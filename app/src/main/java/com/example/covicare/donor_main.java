package com.example.covicare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class donor_main extends AppCompatActivity {
    Button blood,oxygen ;
    //   #BD3F32
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_main);

        oxygen = findViewById(R.id.oxygen); blood = findViewById(R.id.blood);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.blood_donation_vid);
        videoview.setVideoURI(uri);
        videoview.start();

        oxygen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donor_main.this, loadingoxygen.class);
                startActivity(intent);
            }
        });

        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donor_main.this, loading_after_main.class);
                startActivity(intent);
            }
        });

    }
}