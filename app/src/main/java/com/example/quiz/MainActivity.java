package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quiz.adapter.MahasiswaAdapter;
import com.example.quiz.model.Mahasiswa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMahasiswa;
    FloatingActionButton fabTambah;
    MahasiswaAdapter adapter;
    AppDatabase app;
    List<Mahasiswa> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMahasiswa = findViewById(R.id.lv_mahasiswa);
        fabTambah = findViewById(R.id.fab_Tambah);

        //membuat objek app dari AppDatabase (agar bisa akses Produk
        app = new RoomDatabase.Builder<>(this, AppDatabase.class, "mahasiswa.db")
                .allowMainThreadQueries()
                .build();

        tampilkanData();
        fabTambah.setOnClickListener(v -> {
            Intent intent = new Intent(this, TambahActivity.class);
            startActivity(intent);


        });
        lvMahasiswa.setOnItemClickListener((parent, view, position, id) -> {
            Mahasiswa item = mahasiswaList.get(position);

            //kirim data "item" ke UpdateActivity
            Toast.makeText(this, item.nama, Toast.LENGTH_SHORT).show();

        });
    }

    private void tampilkanData() {
        //tampilkan data
        mahasiswaList = app.mahasiswaDao().GetAll(); //ambil data
        MahasiswaAdapter MahasiswaAdapter = new MahasiswaAdapter(this, mahasiswaList);//konversi
        lvMahasiswa.setAdapter(MahasiswaAdapter); //tampilkan
    }
}