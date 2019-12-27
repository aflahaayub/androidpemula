package com.example.komponenelektronika;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class DetailElektronika extends Activity {
    TextView penjelasanElektronika, namaElektronika;
    ImageView imElektronika;
    int posisi, penjelasan, photo;
    String name, detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_elektronika);

        imElektronika = (ImageView) findViewById(R.id.gambar_komponen);
        namaElektronika = (TextView) findViewById(R.id.nama_komponen);
        penjelasanElektronika = (TextView) findViewById(R.id.penjelasan_komponen);
        Button btnback = findViewById(R.id.btn_back);

        detail = getIntent().getStringExtra("penjelasan");
        name = getIntent().getStringExtra("nama benda");
        photo = getIntent().getIntExtra("image", 0);

        namaElektronika.setText(name);
        penjelasanElektronika.setText(detail);
        imElektronika.setImageResource(photo);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }


    }


