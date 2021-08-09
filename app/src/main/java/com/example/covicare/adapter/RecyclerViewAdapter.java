package com.example.covicare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covicare.MainActivity;
import com.example.covicare.R;
import com.example.covicare.model.Blood;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Blood> bloodList;

    public RecyclerViewAdapter(Context context, ArrayList<Blood> bloodList) {
        this.context = context;
        this.bloodList = bloodList;
    }



    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);// where to get single card as viewholder Object
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.ViewHolder holder, int position) {
//what will happen after we create the viewholer object
        Blood blood = bloodList.get(position);

        holder.name.setText(blood.getName());
        holder.phone.setText(blood.getPhonenumber());
        holder.mail.setText(blood.getMail());
        holder.city.setText(blood.getCity());
        holder.street.setText(blood.getStreet());
    }

    @Override
    public int getItemCount() {
        return bloodList.size(); // how many items
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, mail, phone,city, street;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            name = itemView.findViewById(R.id.textView);
            mail = itemView.findViewById(R.id.dealermail);
            phone = itemView.findViewById(R.id.dealerPhone);
            city = itemView.findViewById(R.id.dealercity);
            street = itemView.findViewById(R.id.dealerstreet);

        }

        @Override
        public void onClick(View view) {

        }
    }
    }
