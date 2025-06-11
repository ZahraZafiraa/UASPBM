package com.example.literashare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DonasiBukuActivity extends AppCompatActivity {

    private EditText etJudulBuku, etPenulis, etDeskripsi;
    private Spinner spinnerKategori;
    private LinearLayout btnLocation, btnCamera;
    private Button btnKirimDonasi;
    private ImageView btnBack;

    private String[] kategoriList = {
            "pilih kategori",
            "Fiksi",
            "Non-Fiksi",
            "Buku Pelajaran",
            "Anak-anak",
            "Sains & Teknologi",
            "Sejarah",
            "Seni & Desain",
            "Bahasa & Sastra",
            "Self-Development",
            "Lainnya"
    };

    private String selectedKategori = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_buku);

        initViews();
        setupSpinner();
        setupClickListeners();
    }

    private void initViews() {
        etJudulBuku = findViewById(R.id.et_judul_buku);
        etPenulis = findViewById(R.id.et_penulis);
        etDeskripsi = findViewById(R.id.et_deskripsi);
        spinnerKategori = findViewById(R.id.spinner_kategori);
        btnLocation = findViewById(R.id.btn_location);
        btnCamera = findViewById(R.id.btn_camera);
        btnKirimDonasi = findViewById(R.id.btn_kirim_donasi);
        btnBack = findViewById(R.id.btn_back);
    }

    private void setupSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                kategoriList
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKategori.setAdapter(adapter);

        spinnerKategori.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedKategori = kategoriList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedKategori = "";
            }
        });
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement location picker
                Toast.makeText(DonasiBukuActivity.this, "Pilih lokasi penjemputan", Toast.LENGTH_SHORT).show();
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement camera or gallery picker
                Toast.makeText(DonasiBukuActivity.this, "Upload foto buku", Toast.LENGTH_SHORT).show();
            }
        });

        btnKirimDonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitDonasi();
            }
        });
    }

    private void submitDonasi() {
        String judulBuku = etJudulBuku.getText().toString().trim();
        String penulis = etPenulis.getText().toString().trim();
        String deskripsi = etDeskripsi.getText().toString().trim();

        // Validation
        if (judulBuku.isEmpty()) {
            etJudulBuku.setError("Judul buku harus diisi");
            etJudulBuku.requestFocus();
            return;
        }

        if (penulis.isEmpty()) {
            etPenulis.setError("Nama penulis harus diisi");
            etPenulis.requestFocus();
            return;
        }

        if (selectedKategori.isEmpty() || selectedKategori.equals("pilih kategori")) {
            Toast.makeText(this, "Silakan pilih kategori buku", Toast.LENGTH_SHORT).show();
            return;
        }

        if (deskripsi.isEmpty()) {
            etDeskripsi.setError("Deskripsi buku harus diisi");
            etDeskripsi.requestFocus();
            return;
        }

        // TODO: Implement actual submission logic
        // For now, just show success message
        Toast.makeText(this, "Donasi berhasil dikirim!", Toast.LENGTH_LONG).show();

        // Clear form
        clearForm();
    }

    private void clearForm() {
        etJudulBuku.setText("");
        etPenulis.setText("");
        etDeskripsi.setText("");
        spinnerKategori.setSelection(0);
    }
}