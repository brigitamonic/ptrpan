package com.example.peterpan;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Dosen> list;

    public MyAdapter(Context context, ArrayList<Dosen> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        Dosen dosen = list.get(position);
        holder.nama.setText(dosen.getNama());
        holder.matkul.setText(dosen.getMatkul());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama, matkul;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tvnama);
            matkul = itemView.findViewById(R.id.tvmatkul);

        }
    }
}
