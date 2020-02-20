package com.example.firebaseapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListaViewHolder extends RecyclerView.ViewHolder {

    ImageView authorPhotoImageView;
    TextView authorTextView, contentTextView;


    public ListaViewHolder(@NonNull View itemView) {
        super(itemView);

        authorPhotoImageView = itemView.findViewById(R.id.teamPhotoImageView);
        authorTextView = itemView.findViewById(R.id.teamTextView);
        contentTextView = itemView.findViewById(R.id.contentTextView);
    }
}
