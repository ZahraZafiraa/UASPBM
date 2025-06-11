package com.example.literashare;

public class BookModel {
    private String judul;
    private String penulis;
    private String kategori;
    private String status;
    private int gambar; // resource ID gambar

    public BookModel(String judul, String penulis, String kategori, String status, int gambar) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.status = status;
        this.gambar = gambar;
    }

    // Getter
    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public String getKategori() { return kategori; }
    public String getStatus() { return status; }
    public int getGambar() { return gambar; }
}
