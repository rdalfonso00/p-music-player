package com.example.p_musicplayer.ui.playlists.adapters;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Playlist;
import com.example.p_musicplayer.model.Song;

import java.util.List;

public class PlaylistsAdapter extends RecyclerView.Adapter<PlaylistsAdapter.ViewHolder> {

    private static final String ARG_PLAYLIST = "playlist";

    private List<Playlist<Song>> playlists;

    public PlaylistsAdapter(List<Playlist<Song>> playlists) {
        this.playlists = playlists;
    }

    @NonNull
    @Override
    public PlaylistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistsAdapter.ViewHolder holder, int position) {
        Playlist<Song> playlist = playlists.get(position);
        holder.icon.setImageResource(playlist.getIcon());
        holder.playlistName.setText(playlist.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(ARG_PLAYLIST, playlist);
                findNavController(view).
                        navigate(R.id.action_playlistsFragment_to_onePlaylistFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView playlistName;

        public ViewHolder(@NonNull View view) {
            super(view);
            icon = view.findViewById(R.id.iconPlaylist_item);
            playlistName = view.findViewById(R.id.playlist_name_item);
        }
    }
}
