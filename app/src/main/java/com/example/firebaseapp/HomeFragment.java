package com.example.firebaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HomeFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        RecyclerView listaRecyclerView = view.findViewById(R.id.noticiasRecyclerView);

        Query query = FirebaseFirestore.getInstance().collection("Equipos").limit(50);

        FirestoreRecyclerOptions<Equipo> options = new FirestoreRecyclerOptions.Builder<Equipo>()
                .setQuery(query, Equipo.class)
                .setLifecycleOwner(this)
                .build();


        listaRecyclerView.setAdapter(new ListaEquiposAdapter(options));
    }

    class ListaEquiposAdapter extends FirestoreRecyclerAdapter<Equipo, ListaEquiposAdapter.EquipoViewHolder> {
        public ListaEquiposAdapter(@NonNull FirestoreRecyclerOptions<Equipo> options) {super(options);}

        @Override
        protected void onBindViewHolder(@NonNull EquipoViewHolder holder, int position, @NonNull final Equipo equipo) {
            Glide.with(requireContext()).load(equipo.teamPhotoUrl).circleCrop().into(holder.teamPhotoImageView);
            holder.teamTextView.setText(equipo.team);
            holder.contentTextView.setText(equipo.content);
        }

        @NonNull
        @Override
        public EquipoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EquipoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_post, parent, false));
        }


        public class EquipoViewHolder extends RecyclerView.ViewHolder {
            ImageView teamPhotoImageView;
            TextView teamTextView, contentTextView;

            public EquipoViewHolder(@NonNull View itemView) {
                super(itemView);

                teamPhotoImageView = itemView.findViewById(R.id.teamPhotoImageView);
                teamTextView = itemView.findViewById(R.id.teamTextView);
                contentTextView = itemView.findViewById(R.id.contentTextView);
            }
        }
    }
}