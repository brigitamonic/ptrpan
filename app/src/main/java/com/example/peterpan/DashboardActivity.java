package com.example.peterpan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
    Button recylerviewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recylerviewbtn = findViewById(R.id.btnDosen);
        recylerviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DashboardActivity.this, DosenList.class);
                startActivity(i);
            }
        });
        recylerviewbtn = findViewById(R.id.button2);
        recylerviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DashboardActivity.this, KonsultasiList.class);
                startActivity(i);
            }
        });

    }
}
