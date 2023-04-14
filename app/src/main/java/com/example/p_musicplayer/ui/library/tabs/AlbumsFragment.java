package com.example.p_musicplayer.ui.library.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Album;
import com.example.p_musicplayer.ui.library.adapters.AlbumAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlbumsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumsFragment extends Fragment {

    private RecyclerView recyclerView;
    private AlbumAdapter adapter;

    public AlbumsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param
     * @return A new instance of fragment AlbumsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlbumsFragment newInstance() {
        AlbumsFragment fragment = new AlbumsFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_albums, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_albums);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        List<Album> albums = getAlbums();
        adapter = new AlbumAdapter(albums);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Album> getAlbums() {
        // TODO: get from database instead
        List<Album> songs = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String title = "Album  #" + i;
            String artist = "Artist #" + i;
            int iconResId = R.drawable.box;

            Album album = new Album(iconResId, title, artist, 2023);
            songs.add(album);
        }
        return songs;
    }
}