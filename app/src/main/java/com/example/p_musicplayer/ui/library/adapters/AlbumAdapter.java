package com.example.p_musicplayer.ui.library.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.example.p_musicplayer.R;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p_musicplayer.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> albums;
    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.iconAlbum.setImageResource(album.getIcon());
        holder.albumName.setText(album.getAlbumName());
        holder.artistNameAlbum.setText(album.getArtistName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("myObject", album);
                Navigation.findNavController(view).
                        navigate(R.id.action_artistsFragment_to_oneArtistFragment, bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView iconAlbum;
        public TextView albumName, artistNameAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconAlbum = itemView.findViewById(R.id.iconAlbumItem);
            albumName = itemView.findViewById(R.id.album_name);
            artistNameAlbum = itemView.findViewById(R.id.artist_name_album);

        }
    }
}
