package com.example.literashare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kelas.zahratugas.adapter.BookAdapter;
import com.kelas.zahratugas.model.BookModel;

import java.util.ArrayList;
import java.util.List;

public class CariBukuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BookAdapter adapter;
    List<BookModel> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_buku);

        recyclerView = findViewById(R.id.recycler_buku);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookList = new ArrayList<>();
        bookList.add(new BookModel("Laskar Pelangi", "Andrea Hirata", "Fiksi", "Tersedia", R.drawable.laskar_pelangi));
        bookList.add(new BookModel("Sejarah Indonesia", "Djokaryah", "Sejarah", "Tersedia", R.drawable.sejarah_indonesia));
        bookList.add(new BookModel("Bahasa Arab MI", "Siti Muslikhah", "Buku Pelajaran", "Tersedia", R.drawable.bahasa_arab));
        bookList.add(new BookModel("B.J. Habibie", "Weda S. Atma", "Non Fiksi", "Tersedia", R.drawable.habibie));

        adapter = new BookAdapter(this, bookList);
        recyclerView.setAdapter(adapter);
    }
}
