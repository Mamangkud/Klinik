package com.example.klinik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import database.DBmanager;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> number  = new ArrayList<>();
    private ArrayList<String> nama_pasien = new ArrayList<>();
    private ArrayList<String> jenis_kelamin = new ArrayList<>();
    private ImageView imageView;
    DBmanager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Eksekusi untuk menampilkan halaman Input pasien
        imageView = findViewById(R.id.tambah);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Input_Pasien.class);
                startActivity(intent);
            }
        });
        // Memanggil fungsi yang terdapat statement data pada aplikasi
        getData();
    }

    // Proses untuk menampilkan recylerview dengan cardview yang telah dibuat
    private void processRecycleViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        RecycleViewAdapter adapter = new RecycleViewAdapter(number,nama_pasien, jenis_kelamin);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData(){
        db = new DBmanager(this);
        ArrayList<String> nomor = new ArrayList<>();
        ArrayList<String> nama = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        Cursor data = db.getData();
        if (data.getCount() == 0){
            Toast.makeText(this, "Kosong",Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()){
                nomor.add(data.getString(0));
                nama.add(data.getString(1));
                gender.add(data.getString(2));
                RecyclerView recyclerView = findViewById(R.id.rv_list);
                RecycleViewAdapter adapter = new RecycleViewAdapter(nomor, nama,gender);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), Input_Pasien.class);
                        intent.putExtra("nomor",nomor);
                        intent.putExtra("nama",nama);
                        intent.putExtra("gender", gender);
                        v.getContext().startActivity(intent);
                        finish();
                    }

                });
            }
        }

        //Cursor cursor = db.getData();
//        db.getData();
        /*number.add("1");

        nama_pasien.add("Zam zam");
        jenis_kelamin.add("Pria");

        number.add("2");
        nama_pasien.add("Sapik1");
        jenis_kelamin.add("Pria");

        number.add("3");
        nama_pasien.add("Sapik2");
        jenis_kelamin.add("Pria");

        number.add("4");
        nama_pasien.add("Sapik3");
        jenis_kelamin.add("Pria");

        number.add("5");
        nama_pasien.add("Sapik4");
        jenis_kelamin.add("Pria");

        number.add("6");
        nama_pasien.add("Sapik5");
        jenis_kelamin.add("Pria");


        processRecycleViewAdapter();*/
    }
}