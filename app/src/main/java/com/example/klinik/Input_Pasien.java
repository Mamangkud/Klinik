package com.example.klinik;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import database.DBmanager;

public class Input_Pasien extends AppCompatActivity {
    TextView addnama, addjeniskelamin;
    Button button;
    DBmanager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_pasien);

        addnama = findViewById(R.id.addNama);
        addjeniskelamin = findViewById(R.id.addJenisKelamin);

        button = findViewById(R.id.button);
        db = new DBmanager(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama_pasienTXT = addnama.getText().toString();
                String jenis_kelaminTXT = addjeniskelamin.getText().toString();

                Boolean check = db.insert(nama_pasienTXT, jenis_kelaminTXT);
                if(check== true){
                    Toast.makeText(Input_Pasien.this, "Insert Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Input_Pasien.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Input_Pasien.this, "Insert Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
