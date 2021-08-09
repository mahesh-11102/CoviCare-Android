package com.example.covicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.example.covicare.adapter.RecyclerViewAdapter;
import com.example.covicare.data.Blood_db;
import com.example.covicare.model.Blood;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton submit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Blood> bloodArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        details = findViewById(R.id.listView);

        Blood_db db1 = new Blood_db(MainActivity.this);

        submit = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.fragment_bottom);

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimaion;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });


        //creating
        Blood demo = new Blood();
        demo.setName("mahesh");
        demo.setMail("demomailid@gmail.com");
        demo.setPhonenumber("1234567890");
        demo.setCity("vij");
        demo.setStreet("lol");

        //adding
        db1.addDetails(demo);


        Blood demo2 = new Blood();
        demo2.setName("random");
        demo2.setMail("demomailid@gmail.com");
        demo2.setPhonenumber("123456789");
        demo2.setCity("vij");
        demo2.setStreet("lol");

        db1.addDetails(demo2);


        Blood demo3 = new Blood();
        demo3.setName("demo2");
        demo3.setMail("demomailid@gmail.com");
        demo3.setPhonenumber("123456789");
        demo3.setCity("vij");
        demo3.setStreet("lol");

        db1.addDetails(demo3);

        demo3.setId(98);
        int changedRows = db1.updateBloodDetails(demo3);


        bloodArrayList = new ArrayList<Blood>();


        //get all blood details
        List<Blood> allBloodDeatails = db1.getAllBloodDeatails();
        Log.d("test", "yes I have entered "+ changedRows );

        for(Blood bloodDupli : allBloodDeatails){
            Log.d("test", "yes I have entered");
            for(int i=180;i<203;i++)
                db1.deleteBloodDetailsbyid(i);
//                db1.deleteBloodDetailsbyid(185);
            Log.d("detailslol  ",
                    " Id: "+ bloodDupli.getId()
                            + " Name: "+ bloodDupli.getName()
                            + " Mail: "+ bloodDupli.getMail()
                            + " Phonenumber: "+ bloodDupli.getPhonenumber()
                            + " City: "+ bloodDupli.getCity()
                            + " Street: "+ bloodDupli.getStreet()
            ) ;

            // use your recylerView

            bloodArrayList.add(bloodDupli);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, bloodArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}