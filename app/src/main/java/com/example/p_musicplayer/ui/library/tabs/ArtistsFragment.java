package com.example.p_musicplayer.ui.library.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_musicplayer.R;
import com.example.p_musicplayer.model.Artist;
import com.example.p_musicplayer.ui.library.adapters.ArtistAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArtistsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArtistsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArtistAdapter adapter;

    public ArtistsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ArtistsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArtistsFragment newInstance() {
        ArtistsFragment fragment = new ArtistsFragment();
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
        View view = inflater.inflate(R.layout.fragment_artists, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_artists);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        List<Artist> artistList = getArtists();
        adapter = new ArtistAdapter(artistList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String artistName = "Artist #" + i;
            int iconResId = R.drawable.box;

            Artist artist = new Artist(iconResId, artistName);
            artists.add(artist);
        }
        return artists;
    }
}