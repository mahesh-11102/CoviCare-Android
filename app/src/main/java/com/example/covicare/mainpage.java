package com.example.covicare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mainpage extends AppCompatActivity {
    public String server_url ="https://api.covid19india.org/data.json";
    TextView active_cases,death_cases,recovered_cases,confirme;
    Button give;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        active_cases = findViewById(R.id.activeText);
        death_cases = findViewById(R.id.deathText);
        confirme = findViewById(R.id.confirmedCases);
        recovered_cases = findViewById(R.id.recoveredText);
        give = findViewById(R.id.button2);
        RequestQueue mQueue = Volley.newRequestQueue(this);


        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.i("demo","yo!");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("statewise");
                    Log.i("demo",jsonArray.toString());
                    JSONObject covid = jsonArray.getJSONObject(0);
                    String active = covid.getString("active");
                    Log.d("lol","the active cases are : "+covid.getString("active"));
                    String confirmed = covid.getString("confirmed");
                    String deaths = covid.getString("deaths");
                    String recovered = covid.getString("recovered");
                    String lastupdatedtime = covid.getString("lastupdatedtime");

                    active_cases.append("Active  \n \n"+active);
                    death_cases.append("Deaths: \n \n"+ deaths);
                    confirme.append("Confirmed : \n\n"+ confirmed);
                    recovered_cases.append("Recovered:\n\n"+ recovered);
                    Toast.makeText(getApplicationContext(),"Last updated :"+ lastupdatedtime,Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);


        give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainpage.this, com.example.covicare.loading2.class);
                startActivity(intent);
            }
        });

    }
}