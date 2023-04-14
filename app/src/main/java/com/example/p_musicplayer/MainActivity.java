package com.example.p_musicplayer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.p_musicplayer.ui.adapters.MainViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2Main;
    private MainViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.libraryFragment:
                        viewPager2Main.setCurrentItem(MainViewPagerAdapter.LIBRARY_FRAGMENT);
                        break;
                    case R.id.playlistsFragment:
                        viewPager2Main.setCurrentItem(MainViewPagerAdapter.PLAYLISTS_FRAGMENT);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
        //bottomNavigationView.setSelectedItemId(R.id.libraryFragment);

        // viewpager(s)
        viewPager2Main = findViewById(R.id.main_view_pager);
        pagerAdapter = new MainViewPagerAdapter(this, viewPager2Main);
        viewPager2Main.setAdapter(pagerAdapter);
        viewPager2Main.setUserInputEnabled(false);
        viewPager2Main.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == (pagerAdapter.getItemCount() - 1)){
                    viewPager2Main.setUserInputEnabled(true);
                }else {
                    viewPager2Main.setUserInputEnabled(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

    }
}