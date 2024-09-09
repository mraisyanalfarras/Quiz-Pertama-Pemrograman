package com.example.quiz.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quiz.model.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {
    @Insert
    void insert(Mahasiswa mahasiswa);
    @Delete
    void delete(Mahasiswa mahasiswa);
    @Update
    void update(Mahasiswa mahasiswa);
    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> GetAll();
}
