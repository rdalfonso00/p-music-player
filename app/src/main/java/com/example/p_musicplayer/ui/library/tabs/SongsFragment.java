package com.example.p_musicplayer.ui.library.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Song;
import com.example.p_musicplayer.ui.library.adapters.SongAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SongsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SongsFragment extends Fragment {


    private RecyclerView recyclerView;
    private SongAdapter adapter;

    public SongsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SongsFragment newInstance() {
        SongsFragment fragment = new SongsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_songs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Song> songs = getSongs();
        adapter = new SongAdapter(songs);
        recyclerView.setAdapter(adapter);


        return view;
    }

    public static List<Song> getSongs() {
        // TODO: get from database instead
        List<Song> songs = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String title = "Song  #" + i;
            String artist = "Artist #" + i;
            String album = "Album :))))))))";
            int iconResId = R.drawable.box;
            boolean isFavorite = false;

            Song song = new Song(iconResId, title, artist, album, isFavorite);
            songs.add(song);
        }
        return songs;
    }
}