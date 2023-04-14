package com.example.p_musicplayer.ui.library.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.p_musicplayer.ui.library.LibraryFragment;
import com.example.p_musicplayer.ui.library.tabs.AlbumsFragment;
import com.example.p_musicplayer.ui.library.tabs.ArtistsFragment;
import com.example.p_musicplayer.ui.library.tabs.SongsFragment;

public class LibraryViewPagerAdapter extends FragmentStateAdapter {
    private final int itemCount = 3;
    private final static int SONGS_FRAGMENT = 0;
    private final static int ARTISTS_FRAGMENT = 1;
    private final static int ALBUMS_FRAGMENT = 2;

    public LibraryViewPagerAdapter(@NonNull LibraryFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case SONGS_FRAGMENT:
                return SongsFragment.newInstance();
            case ARTISTS_FRAGMENT:
                return ArtistsFragment.newInstance();
            case ALBUMS_FRAGMENT:
                return AlbumsFragment.newInstance();
            default:
        }
        return null; // TODO: maybe throw exception?
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }
}
