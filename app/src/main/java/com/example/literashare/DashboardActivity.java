package com.example.literashare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private LinearLayout btnDonasiBuku, btnCariBuku, btnBukuSaya, btnJejak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initViews();
        setupBottomNavigation();
        setupFeatureButtons();
    }

    private void initViews() {
        // Inisialisasi BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Inisialisasi tombol fitur
        btnDonasiBuku = findViewById(R.id.btn_donasi_buku);
        btnCariBuku = findViewById(R.id.btn_cari_buku);
        btnBukuSaya = findViewById(R.id.btn_buku_saya);
        btnJejak = findViewById(R.id.btn_jejak_kontribusi);
    }

    private void setupBottomNavigation() {
        // Set item yang dipilih default
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        // Listener untuk navigasi bottom
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                // Sudah di halaman home, tidak perlu pindah
                return true;

            } else if (itemId == R.id.nav_search) {
                startActivity(new Intent(DashboardActivity.this, SearchActivity.class));
                overridePendingTransition(0, 0);
                return true;

            } else if (itemId == R.id.nav_books) {
                startActivity(new Intent(DashboardActivity.this, BooksActivity.class));
                overridePendingTransition(0, 0);
                return true;

            } else if (itemId == R.id.nav_stats) {
                startActivity(new Intent(DashboardActivity.this, StatsActivity.class));
                overridePendingTransition(0, 0);
                return true;
            }

            return false;
        });
    }

    private void setupFeatureButtons() {
        // Tombol Donasi Buku
        btnDonasiBuku.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, DonasiActivity.class);
            startActivity(intent);
        });

        // Tombol Cari Buku
        btnCariBuku.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SearchActivity.class);
            startActivity(intent);
        });

        // Tombol Buku Saya
        btnBukuSaya.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, MyBooksActivity.class);
            startActivity(intent);
        });

        // Tombol Jejak Kontribusi
        btnJejak.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ContributionActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Pastikan item home tetap terpilih saat kembali ke dashboard
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        // Konfirmasi keluar aplikasi
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        // Atau bisa menggunakan dialog konfirmasi
        // showExitConfirmationDialog();

        super.onBackPressed();
    }

    // Method tambahan untuk konfirmasi keluar (opsional)
    /*
    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Keluar Aplikasi")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya", (dialog, which) -> finish())
                .setNegativeButton("Tidak", null)
                .show();
    }
    */
}