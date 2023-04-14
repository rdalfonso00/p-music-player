package com.example.p_musicplayer.ui.library.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Artist;
import com.example.p_musicplayer.model.Song;
import com.example.p_musicplayer.ui.library.adapters.SongAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneArtistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneArtistFragment extends Fragment {

    // parameters
    private RecyclerView recyclerViewAlbumSongs;
    private SongAdapter adapter;
    // Bundled args
    private Artist artist;

    public OneArtistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static OneArtistFragment newInstance() {
        OneArtistFragment fragment = new OneArtistFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            artist = (Artist) getArguments().getSerializable("artistObject");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_artist, container, false);

        recyclerViewAlbumSongs = view.findViewById(R.id.recycler_view_one_artist_songs);
        recyclerViewAlbumSongs.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Song> songs = SongsFragment.getSongs();
        adapter = new SongAdapter(songs);
        recyclerViewAlbumSongs.setAdapter(adapter);

        return view;
    }


}