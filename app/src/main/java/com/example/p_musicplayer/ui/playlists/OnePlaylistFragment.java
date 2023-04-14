package com.example.p_musicplayer.ui.playlists;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Playlist;
import com.example.p_musicplayer.model.Song;
import com.example.p_musicplayer.ui.library.adapters.SongAdapter;
import com.example.p_musicplayer.ui.library.tabs.SongsFragment;
import com.example.p_musicplayer.ui.playlists.adapters.PlaylistsAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnePlaylistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnePlaylistFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PLAYLIST = "playlist";

    // TODO: Rename and change types of parameters
    private RecyclerView recyclerView;
    private SongAdapter songsAdapter;
    private Playlist<Song> playlist;
    private ConstraintLayout emptyPlaylistMessageLayout;

    public OnePlaylistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment OnePlaylistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OnePlaylistFragment newInstance() {
        OnePlaylistFragment fragment = new OnePlaylistFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            playlist = (Playlist<Song>) getArguments().getSerializable(ARG_PLAYLIST);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_playlist, container, false);
        emptyPlaylistMessageLayout = view.findViewById(R.id.layout_empty_message_one_playlist);
        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_one_playlist_songs);
        List<Song> songs = playlist.getSongs();
        songsAdapter = new SongAdapter(songs);

        songsAdapter.unregisterAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                checkIfEmpty();
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                checkIfEmpty();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                checkIfEmpty();
            }

            private void checkIfEmpty() {
                // Show empty view if RecyclerView is empty, hide it otherwise
                if (recyclerView.getAdapter().getItemCount() == 0) {
                    emptyPlaylistMessageLayout.setVisibility(View.VISIBLE);
                } else {
                    emptyPlaylistMessageLayout.setVisibility(View.GONE);
                }
            }
        });

        recyclerView.setAdapter(songsAdapter);
    }
}