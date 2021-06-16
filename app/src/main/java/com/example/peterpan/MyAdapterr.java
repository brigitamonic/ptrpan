package com.example.peterpan;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterr extends RecyclerView.Adapter<MyAdapterr.MyViewHolder> {
    Context context;
    ArrayList<Konsultasi> listt;

    public MyAdapterr(Context context, ArrayList<Konsultasi> listt) {
        this.context = context;
        this.listt = listt;
    }
    @NonNull
    @Override
    public MyAdapterr.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View w = LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
        return new MyAdapterr.MyViewHolder(w);
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapterr.MyViewHolder holder, int position) {

        Konsultasi konsultasi = listt.get(position);
        holder.nama.setText(konsultasi.getNama());
        holder.matkul.setText(konsultasi.getMatkul());
        holder.tgl.setText(konsultasi.getTgl());
        holder.sesi.setText(konsultasi.getSesi());
        holder.status.setText(konsultasi.getStatus());
    }

    @Override
    public int getItemCount() {
        return listt.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama, matkul, tgl, sesi, status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tvnama);
            matkul = itemView.findViewById(R.id.tvmatkul);
            tgl = itemView.findViewById(R.id.tvtgl);
            sesi = itemView.findViewById(R.id.tvsesi);
            status = itemView.findViewById(R.id.tvstatus);

        }
    }
}
