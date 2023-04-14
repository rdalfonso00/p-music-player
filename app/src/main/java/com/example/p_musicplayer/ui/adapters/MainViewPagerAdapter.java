package com.example.p_musicplayer.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.p_musicplayer.ui.playlists.PlaylistsFragment;
import com.example.p_musicplayer.ui.library.LibraryFragment;


public class MainViewPagerAdapter extends FragmentStateAdapter {

    private final int itemCount = 2;
    public final static int LIBRARY_FRAGMENT = 0;
    public final static int PLAYLISTS_FRAGMENT = 1;

    private LibraryFragment libraryFragment;
    private PlaylistsFragment playlistsFragment;
    private ViewPager2 viewPager2Main;

    public MainViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, ViewPager2 viewPager2Main) {
        super(fragmentActivity);
        this.viewPager2Main = viewPager2Main;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case LIBRARY_FRAGMENT:
                return new LibraryFragment(viewPager2Main);
            case PLAYLISTS_FRAGMENT:
                return new PlaylistsFragment();
            default:
        }
        return null; // TODO: maybe throw exception?
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }
    public LibraryFragment getLibraryFragment() {
        return libraryFragment;
    }
}
