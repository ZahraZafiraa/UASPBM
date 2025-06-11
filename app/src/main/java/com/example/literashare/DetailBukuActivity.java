package com.example.literashare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailBukuActivity extends AppCompatActivity {

    private ImageView btnBack, ivBookCover;
    private TextView tvBookTitle, tvBookAuthor, tvKategori, tvHalaman, tvStatus, tvDeskripsi;
    private Button btnPesanBuku;

    // Sample book data - in real app, this would come from database or intent extras
    private BookData currentBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        initViews();
        loadBookData();
        setupClickListeners();
    }

    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        ivBookCover = findViewById(R.id.iv_book_cover);
        tvBookTitle = findViewById(R.id.tv_book_title);
        tvBookAuthor = findViewById(R.id.tv_book_author);
        tvKategori = findViewById(R.id.tv_kategori);
        tvHalaman = findViewById(R.id.tv_halaman);
        tvStatus = findViewById(R.id.tv_status);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        btnPesanBuku = findViewById(R.id.btn_pesan_buku);
    }

    private void loadBookData() {
        // Get book data from intent extras or use default data
        String bookId = getIntent().getStringExtra("BOOK_ID");

        if (bookId != null) {
            // TODO: Load book data from database using bookId
            loadBookFromDatabase(bookId);
        } else {
            // Use sample data
            loadSampleData();
        }
    }

    private void loadBookFromDatabase(String bookId) {
        // TODO: Implement database loading
        // For now, use sample data
        loadSampleData();
    }

    private void loadSampleData() {
        currentBook = new BookData();
        currentBook.title = "Laskar Pelangi";
        currentBook.author = "Andrea Hirata";
        currentBook.kategori = "Fiksi";
        currentBook.halaman = "529";
        currentBook.status = "Tersedia";
        currentBook.deskripsi = "Buku dalam kondisi cukup baik. Sampul terdapat sedikit bekas lipatan, namun halaman dalam utuh, tidak robek, dan dapat dibaca dengan jelas. Tidak terdapat coretan atau noda pada isi buku.";
        currentBook.coverImageRes = R.drawable.book_cover_placeholder;

        displayBookData();
    }

    private void displayBookData() {
        tvBookTitle.setText(currentBook.title);
        tvBookAuthor.setText(currentBook.author);
        tvKategori.setText(currentBook.kategori);
        tvHalaman.setText(currentBook.halaman);
        tvStatus.setText(currentBook.status);
        tvDeskripsi.setText(currentBook.deskripsi);

        // Set book cover image
        if (currentBook.coverImageRes != 0) {
            ivBookCover.setImageResource(currentBook.coverImageRes);
        }

        // Update button text and availability based on status
        updateButtonStatus();
    }

    private void updateButtonStatus() {
        if (currentBook.status.equalsIgnoreCase("Tersedia")) {
            btnPesanBuku.setText("PESAN BUKU");
            btnPesanBuku.setEnabled(true);
            btnPesanBuku.setAlpha(1.0f);
        } else {
            btnPesanBuku.setText("TIDAK TERSEDIA");
            btnPesanBuku.setEnabled(false);
            btnPesanBuku.setAlpha(0.6f);
        }
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnPesanBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentBook != null && currentBook.status.equalsIgnoreCase("Tersedia")) {
                    pesanBuku();
                }
            }
        });
    }

    private void pesanBuku() {
        // TODO: Implement book ordering logic
        // This could involve:
        // 1. Check user authentication
        // 2. Add to cart or direct order
        // 3. Navigate to order confirmation
        // 4. Update book status

        Toast.makeText(this, "Pesanan untuk \"" + currentBook.title + "\" berhasil dibuat!", Toast.LENGTH_LONG).show();

        // For demo purposes, change status to "Dipesan"
        currentBook.status = "Dipesan";
        tvStatus.setText(currentBook.status);
        updateButtonStatus();
    }

    // Inner class to hold book data
    private class BookData {
        String title;
        String author;
        String kategori;
        String halaman;
        String status;
        String deskripsi;
        int coverImageRes;
        String bookId;
    }

    // Static method to start this activity with book data
    public static void startWithBookId(android.content.Context context, String bookId) {
        Intent intent = new Intent(context, DetailBukuActivity.class);
        intent.putExtra("BOOK_ID", bookId);
        context.startActivity(intent);
    }

    // Method to set book data programmatically
    public void setBookData(String title, String author, String kategori, String halaman,
                            String status, String deskripsi, int coverImageRes) {
        currentBook = new BookData();
        currentBook.title = title;
        currentBook.author = author;
        currentBook.kategori = kategori;
        currentBook.halaman = halaman;
        currentBook.status = status;
        currentBook.deskripsi = deskripsi;
        currentBook.coverImageRes = coverImageRes;

        displayBookData();
    }
}