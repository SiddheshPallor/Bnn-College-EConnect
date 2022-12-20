package com.example.bnncollegee_connect.eBook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bnncollegee_connect.R;

import java.util.ArrayList;
import java.util.List;

public class eBookAdapter extends RecyclerView.Adapter<eBookAdapter.eBookViewHolder> {

    private Context context;
    private List<ebookData> list;


    public eBookAdapter(Context context, List<ebookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public eBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent,false);
        return new eBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull eBookViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.ebookTitle.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(context,pdfViewerActivity.class);
                    intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        holder.ebookDownloadPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void FilteredList(ArrayList<ebookData> filterList) {
        list = filterList;
        notifyDataSetChanged();
    }

    public class eBookViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookTitle;
        private ImageView ebookDownloadPdf;

        public eBookViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookTitle = itemView.findViewById(R.id.ebookTitle);
            ebookDownloadPdf = itemView.findViewById(R.id.ebookDownloadPdf);
        }
    }

}
