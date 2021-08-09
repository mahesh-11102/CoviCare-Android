package com.example.covicare;

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

public class BottomFragment extends BottomSheetDialogFragment {
Button submit;
    EditText name, mail,phone,city,street;
     public BottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottom,container,false);
        // Inflate the layout for this fragment
        submit = v.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tester","u have click the button");
                 name = (EditText) v.findViewById(R.id.dealer_name);
                 mail = (EditText) v.findViewById(R.id.dealer_mail);
                 phone = (EditText) v.findViewById(R.id.dealer_phone);
                 city = (EditText) v.findViewById(R.id.dealer_city);
                 street = (EditText) v.findViewById(R.id.dealer_street);

                Toast.makeText(getContext(), ""+name.getText().toString(), Toast.LENGTH_SHORT).show();

                if(!TextUtils.isEmpty(name.getText().toString())) {
                    String lolname = name.getText().toString();
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(mail.getText().toString())) {
                    String lolname = mail.getText().toString();
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(phone.getText().toString())) {
                    String lolname = phone.getText().toString();
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(city.getText().toString())) {
                    String lolname = city.getText().toString();
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }

                if(!TextUtils.isEmpty(street.getText().toString())) {
                    String lolname = street.getText().toString();
                }else {
                    Toast.makeText(getContext(), "Name Required", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}