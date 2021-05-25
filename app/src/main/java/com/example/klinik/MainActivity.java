package com.example.klinik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> number  = new ArrayList<>();
    private ArrayList<String> nama_pasien = new ArrayList<>();
    private ArrayList<String> jenis_kelamin = new ArrayList<>();
    ImageView imageView;
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

    // Proses untuk menampilkan
    private void processRecycleViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        RecycleViewAdapter adapter = new RecycleViewAdapter(number,nama_pasien, jenis_kelamin);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData(){
        number.add("1");
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


        processRecycleViewAdapter();
    }
}