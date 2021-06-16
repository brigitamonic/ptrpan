package com.example.peterpan;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {
    String nim, nama, namaDosen, matkul, tgl, sesi;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogForm(){
        this.nim = nim;
        this.nama = nama;
        this.namaDosen = namaDosen;
        this.matkul = matkul;
        this.tgl = tgl;
        this.sesi = sesi;
    }

    TextView et_nim;
    TextView et_nama;
    TextView et_namadsn;
    TextView et_matkul;
    TextView et_tgl;
    TextView et_sesi;

    Button btnSimpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.input_form, container, false);

        et_nim = view.findViewById(R.id.et_nim);
        et_nama = view.findViewById(R.id.et_nama);
        et_namadsn = view.findViewById(R.id.et_namadsn);
        et_matkul = view.findViewById(R.id.et_matkul);
        et_tgl = view.findViewById(R.id.et_tgl);
        et_sesi = view.findViewById(R.id.et_sesi);

        et_nim.setText(nim);
        et_nama.setText(nama);
        et_namadsn.setText(namaDosen);
        et_matkul.setText(matkul);
        et_tgl.setText(tgl);
        et_sesi.setText(sesi);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = et_nim.getText().toString();
                String nama = et_nama.getText().toString();
                String namaDosen = et_namadsn.getText().toString();
                String matkul = et_matkul.getText().toString();
                String tgl = et_tgl.getText().toString();
                String sesi = et_sesi.getText().toString();

                if (TextUtils.isEmpty(nim)) {
                    input((EditText) et_nim, "NIM");
                } else if (TextUtils.isEmpty(nama)) {
                    input((EditText) et_nama, "Nama");
                } else if (TextUtils.isEmpty(namaDosen)) {
                    input((EditText) et_namadsn, "Nama Dosen");
                } else if (TextUtils.isEmpty(matkul)) {
                    input((EditText) et_matkul, "Matakuliah");
                } else if (TextUtils.isEmpty(tgl)) {
                    input((EditText) et_tgl, "Tanggal");
                } else if (TextUtils.isEmpty(sesi)) {
                    input((EditText) et_sesi, "Sesi");
                } else {
                    database.child("Pengajuan").push().setValue(new Pengajuan(nim, nama, namaDosen, matkul, tgl, sesi)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Data Gagal Tersimpan", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private void input(EditText txt, String s){
    txt.setError(s+ "tidak boleh kosong");
    txt.requestFocus();
}
        }
