package com.example.quiz;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quiz.dao.MahasiswaDao;
import com.example.quiz.model.Mahasiswa;

@Database(entities = Mahasiswa.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MahasiswaDao mahasiswaDao();

}
