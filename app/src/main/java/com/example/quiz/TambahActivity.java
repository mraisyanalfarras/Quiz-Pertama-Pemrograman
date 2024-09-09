package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quiz.model.Mahasiswa;

public class TambahActivity extends AppCompatActivity {

    EditText etNama, etNim, etProdi;
    Button btnSimpan;
    AppDatabase app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama_mahasiswa);
        etNim = findViewById(R.id.et_nim);
        etProdi = findViewById(R.id.et_prodi);
        btnSimpan = findViewById(R.id.button_tambah);

        //membuat objek app dari AppDatabase (agar bisa akses Produk
        app = new RoomDatabase.Builder<>(this, AppDatabase.class, "mahasiswa.db")
                .allowMainThreadQueries()
                .build();
        btnSimpan.setOnClickListener(v ->{
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.nama = etNama.getText().toString();
            mahasiswa.nim = etNim.getText().toString();
            mahasiswa.prodi = etProdi.getText().toString();

            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}