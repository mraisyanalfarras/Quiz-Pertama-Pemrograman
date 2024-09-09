package com.example.quiz.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mahasiswa")
public class Mahasiswa {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "nim")
    public String nim;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "prodi")
    public String prodi;
}
