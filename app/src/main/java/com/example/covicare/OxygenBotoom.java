package com.example.covicare;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class OxygenBotoom extends BottomSheetDialogFragment {
    EditText dealer;
    EditText mail;
    EditText phone;
    EditText city;
    EditText street;
    Button submit;
    String deall_name, dealer_mail,dealer_phone,dealer_city,dealer_street;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.bottom_oxygen,container,false);
        // Inflate the layout for this fragment
        submit = (Button) view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tester","u have click the button");
                dealer = (EditText) view.findViewById(R.id.dealer_name);
                mail = (EditText) view.findViewById(R.id.dealer_mail);
                phone = (EditText) view.findViewById(R.id.dealer_phone);
                city = (EditText) view.findViewById(R.id.dealer_city);
                street = (EditText) view.findViewById(R.id.dealer_street);

                Toast.makeText(getContext(), ""+dealer.getText().toString(), Toast.LENGTH_SHORT).show();

                if(!TextUtils.isEmpty(dealer.getText().toString())) {
                    deall_name = dealer.getText().toString();
                    startActivity(new Intent(getContext(),oxygen_bottom_data.class).putExtra("name",deall_name));
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(mail.getText().toString())) {
                    dealer_mail = mail.getText().toString();
                    startActivity(new Intent(getContext(),oxygen_bottom_data.class).putExtra("name",dealer_mail));
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(phone.getText().toString())) {
                    dealer_phone = phone.getText().toString();
                    startActivity(new Intent(getContext(),oxygen_bottom_data.class).putExtra("name",dealer_phone));
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(city.getText().toString())) {
                    dealer_street = city.getText().toString();
                    startActivity(new Intent(getContext(),oxygen_bottom_data.class).putExtra("name",dealer_street));
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(street.getText().toString())) {
                    String lolname = street.getText().toString();
                    startActivity(new Intent(getContext(),oxygen_bottom_data.class).putExtra("name",lolname));
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }
}
