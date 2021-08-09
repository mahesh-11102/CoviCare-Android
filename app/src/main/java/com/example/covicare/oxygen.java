package com.example.covicare;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covicare.adapter.OxygenRecyclerAdapter;
import com.example.covicare.data.Oxygen_db;
import com.example.covicare.model.Oxygen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class oxygen extends AppCompatActivity {
    FloatingActionButton submit;
    RecyclerView recyclerView;
    OxygenRecyclerAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Oxygen_db db2 = new Oxygen_db(oxygen.this);
        submit = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(oxygen.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottom_oxygen);

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimaion;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });

        Oxygen demo = new Oxygen();
        demo.setdealer_name("mahesh");
        demo.setMail("demomail@gmail.com");
        demo.setPhonenumber("1234567890");
        demo.setCity("vij");
        demo.setStreet("lol");

        db2.addDetails(demo);

        Oxygen demo2 = new Oxygen();
        demo2.setdealer_name("random");
        demo2.setMail("demomail@gmail.com");
        demo2.setPhonenumber("123456789");
        demo2.setCity("vij");
        demo2.setStreet("lol");

        db2.addDetails(demo2);


        Oxygen demo3 = new Oxygen();
        demo3.setdealer_name("unknowm");
        demo3.setMail("demomail@gmail.com");
        demo3.setPhonenumber("123456789");
        demo3.setCity("vij");
        demo3.setStreet("lol");

        db2.addDetails(demo3);

        ArrayList<Oxygen> arrayList2 = new ArrayList<Oxygen>();


        //get all oxygen details
        List<Oxygen> allOxygenDeatails = db2.getAllOxygenDeatails();
        //Log.d("test", "yes I have entered "+ changedRows );

        for(Oxygen oxygenDupli : allOxygenDeatails){
            Log.d("test", "yes I have entered");
            Log.d("detailslol  ",
                    " Id: "+ oxygenDupli.getId()
                            + " DealerName: "+ oxygenDupli.getdealer_name()
                            + " Mail: "+ oxygenDupli.getMail()
                            + " Phonenumber: "+ oxygenDupli.getPhonenumber()
                            + " City: "+ oxygenDupli.getCity()
                            + " Street: "+ oxygenDupli.getStreet()
            ) ;

            // use your recylerView

            arrayList2.add(oxygenDupli);
        }

        recyclerViewAdapter = new OxygenRecyclerAdapter(oxygen.this, arrayList2);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}