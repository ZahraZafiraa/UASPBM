package com.example.literashare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PesananSayaActivity extends AppCompatActivity {

    private ImageView btnBack;
    private TextView tabDonasi, tabPesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_saya);

        initViews();
        setListeners();
    }

    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        tabDonasi = findViewById(R.id.tab_donasi);
        tabPesanan = findViewById(R.id.tab_pesanan);
    }

    private void setListeners() {
        // Back button listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Tab Donasi listener
        tabDonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Donasi Saya Activity
                Intent intent = new Intent(PesananSayaActivity.this, DonasiSayaActivity.class);
                startActivity(intent);
                // Add transition animation
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // Tab Pesanan listener (already selected)
        tabPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on Pesanan tab, do nothing or refresh
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Add transition animation when going back
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}