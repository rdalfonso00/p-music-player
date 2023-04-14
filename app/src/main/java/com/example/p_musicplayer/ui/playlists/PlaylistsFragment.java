package com.example.p_musicplayer.ui.playlists;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Playlist;
import com.example.p_musicplayer.model.Song;
import com.example.p_musicplayer.ui.playlists.adapters.PlaylistsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaylistsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaylistsFragment extends Fragment {

    private Button newPlaylistButton;
    private RecyclerView recyclerView;
    private PlaylistsAdapter adapter;

    public PlaylistsFragment() {
        // Required empty public constructor
    }

    public static PlaylistsFragment newInstance() {
        PlaylistsFragment fragment = new PlaylistsFragment();
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
        View view = inflater.inflate(R.layout.fragment_playlists, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_playlists);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        List<Playlist<Song>> playlists = getPlaylists();
        adapter = new PlaylistsAdapter(playlists);
        recyclerView.setAdapter(adapter);

        newPlaylistButton = view.findViewById(R.id.new_playlist_button);

        return view;
    }

    private List<Playlist<Song>> getPlaylists() {
        // TODO: get from database instead
        List<Playlist<Song>> playlists = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String title = "Playlist  #" + i;
            int iconResId = R.drawable.box;
            Playlist album = new Playlist(iconResId, title, null);
            playlists.add(album);
        }
        return playlists;
    }
}


