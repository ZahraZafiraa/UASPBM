package com.example.literashare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kelas.zahratugas.R;
import com.kelas.zahratugas.model.BookModel;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<BookModel> bookList;
    private Context context;

    public BookAdapter(Context context, List<BookModel> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_buku, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {
        BookModel book = bookList.get(position);
        holder.txtJudul.setText(book.getJudul());
        holder.txtPenulis.setText(book.getPenulis());
        holder.txtKategori.setText("Kategori: " + book.getKategori());
        holder.txtStatus.setText("Status: " + book.getStatus());
        holder.imgBuku.setImageResource(book.getGambar());

        holder.btnDetail.setOnClickListener(v -> {
            // Tambahkan intent ke halaman detail buku
        });

        holder.btnPesan.setOnClickListener(v -> {
            // Tambahkan aksi pemesanan buku
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBuku;
        TextView txtJudul, txtPenulis, txtKategori, txtStatus;
        Button btnDetail, btnPesan;

        public ViewHolder(View itemView) {
            super(itemView);
            imgBuku = itemView.findViewById(R.id.img_buku);
            txtJudul = itemView.findViewById(R.id.txt_judul);
            txtPenulis = itemView.findViewById(R.id.txt_penulis);
            txtKategori = itemView.findViewById(R.id.txt_kategori);
            txtStatus = itemView.findViewById(R.id.txt_status);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            btnPesan = itemView.findViewById(R.id.btn_pesan);
        }
    }
}
