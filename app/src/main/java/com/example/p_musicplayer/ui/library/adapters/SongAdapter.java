package com.example.p_musicplayer.ui.library.adapters;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Song;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private List<Song> songs;

    public SongAdapter(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.icon.setImageResource(song.getIcon());
        holder.songName.setText(song.getTitle());
        holder.artistName.setText(song.getArtistName());

        // bottomsSheetDialog behaviour
        ImageView songImage;
        TextView songName, authorsName, albumName;
        songImage = holder.sheetDialog.findViewById(R.id.image_song_opt);
        songName = holder.sheetDialog.findViewById(R.id.opt_song_name);
        authorsName = holder.sheetDialog.findViewById(R.id.opt_authors);
        albumName = holder.sheetDialog.findViewById(R.id.opt_album_name);
        songImage.setImageResource(song.getIcon());
        songName.setText(song.getTitle());
        authorsName.setText(song.getArtistName());
        albumName.setText(song.getAlbumName());

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView songName;
        public TextView artistName;
        public ImageButton favouritesButton, optionsButton;
        public BottomSheetDialog sheetDialog;

        public ViewHolder(@NonNull View view) {
            super(view);
            icon = view.findViewById(R.id.icon);
            songName = view.findViewById(R.id.song_name);
            artistName = view.findViewById(R.id.artist_name);
            favouritesButton = view.findViewById(R.id.favourite_button);
            optionsButton = view.findViewById(R.id.options_button);
            setupBottomSheetDialog();

            // behaviour
            favouritesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    favouritesButton.setImageResource(R.drawable.ic_favorite);
                }
            });

            optionsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // create new sheetdialog for options
                    // set the icons correspondant to the view
                    Log.i("poncho", "options dialog showing!!" + getAdapterPosition()+1);
                    sheetDialog.show();
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked song" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        // setup
        public void setupBottomSheetDialog() {
            sheetDialog = new BottomSheetDialog(itemView.getContext());
            View contentView = LayoutInflater.from(itemView.getContext()).inflate(R.layout.fragment_options_bottom, null);
            sheetDialog.setContentView(contentView);
            //contentView.requestFocus();
            sheetDialog.getBehavior().setPeekHeight(700, true);
            contentView.setBackgroundColor(Color.TRANSPARENT);
            // show the sheet only when button pressed
        }
    }
}
