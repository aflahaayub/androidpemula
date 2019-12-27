package com.example.komponenelektronika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listElektronika;
    Adapter adapter;
    private Button btnAboutMe;

    private RecyclerView rvKomponen;
    private ArrayList<Komponen> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKomponen = findViewById(R.id.rv_komponen);
        rvKomponen.setHasFixedSize(true);

        btnAboutMe = findViewById(R.id.btn_person);
        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movetoAboutMe = new Intent (MainActivity.this, AboutMe.class);
                startActivity(movetoAboutMe);
            }
        });

        list.addAll(DataElektronika.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvKomponen.setLayoutManager(new LinearLayoutManager(this));
        ListKomponenAdapter listKomponenAdapter = new ListKomponenAdapter(list);
        rvKomponen.setAdapter(listKomponenAdapter);

        listKomponenAdapter.setOnItemClickCallback(new ListKomponenAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Komponen data) {
                showSelectedKomponen(data);
            }
        });
    }

    private void showSelectedKomponen (Komponen komponen){
        Intent moveToKomponenDetail = new Intent(MainActivity.this, DetailElektronika.class);
        moveToKomponenDetail.putExtra("nama benda", komponen.getName());
        moveToKomponenDetail.putExtra("penjelasan", komponen.getDetail());
        moveToKomponenDetail.putExtra("image", komponen.getPhoto());
        startActivity(moveToKomponenDetail);
    }


}
