package com.example.literashare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DonasiSayaActivity extends AppCompatActivity {

    private ImageView btnBack;
    private TextView tabDonasi, tabPesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_saya);

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

        // Tab Donasi listener (already selected)
        tabDonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on Donasi tab, do nothing or refresh
            }
        });

        // Tab Pesanan listener
        tabPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Pesanan Saya Activity
                Intent intent = new Intent(DonasiSayaActivity.this, PesananSayaActivity.class);
                startActivity(intent);
                // Add transition animation
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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