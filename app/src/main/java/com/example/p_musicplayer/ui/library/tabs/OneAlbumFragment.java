package com.example.p_musicplayer.ui.library.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Album;
import com.example.p_musicplayer.model.Song;
import com.example.p_musicplayer.ui.library.adapters.SongAdapter;

import java.util.ArrayList;
import java.util.List;

public class OneAlbumFragment extends Fragment {

    // parameters
    private RecyclerView recyclerViewAlbumSongs;
    private SongAdapter adapter;
    private Album album;
    public OneAlbumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment OneAlbumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneAlbumFragment newInstance() {
        OneAlbumFragment fragment = new OneAlbumFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            album = (Album) getArguments().getSerializable("albumObject");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_album, container, false);


        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        recyclerViewAlbumSongs = view.findViewById(R.id.recycler_view_one_album_songs);
        recyclerViewAlbumSongs.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Song> songs = SongsFragment.getSongs(); // TODO: songs from album instead
        adapter = new SongAdapter(songs);
        recyclerViewAlbumSongs.setAdapter(adapter);

    }
}