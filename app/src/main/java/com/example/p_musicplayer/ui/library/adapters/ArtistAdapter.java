package com.example.p_musicplayer.ui.library.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Artist;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {
    private List<Artist> artists;

    public ArtistAdapter(List<Artist> artists) {
        this.artists = artists;
    }

    @NonNull
    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.ViewHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.icon.setImageResource(artist.getIcon());
        holder.artistName.setText(artist.getName());

    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView artistName;

        public ViewHolder(@NonNull View view) {
            super(view);
            icon = view.findViewById(R.id.iconArtist_item);
            artistName = view.findViewById(R.id.artist_name_item);

            // behaviour
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked artist" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
