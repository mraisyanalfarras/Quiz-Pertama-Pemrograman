package com.example.quiz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.model.Mahasiswa;

import java.util.List;

public class MahasiswaAdapter extends BaseAdapter {
    Context context;
    List<Mahasiswa> mahasiswaList;

    public MahasiswaAdapter(Context context, List<Mahasiswa> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }


    @Override
    public int getCount() {
        return mahasiswaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mahasiswaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        TextView tvNama = view.findViewById(R.id.tv_nama);
        TextView tvDeskripsi = view.findViewById(R.id.tv_prodi);
        TextView tvNim = view.findViewById(R.id.tv_nim);


        tvNama.setText(mahasiswaList.get(position).nama);
        tvDeskripsi.setText(mahasiswaList.get(position).prodi);
        tvNim.setText(mahasiswaList.get(position).nim);
        return view;
    }
}
