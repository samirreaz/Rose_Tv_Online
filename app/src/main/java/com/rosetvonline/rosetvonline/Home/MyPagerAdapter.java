package com.rosetvonline.rosetvonline.Home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rosetvonline.rosetvonline.Home.Go_ogle.BlankFragment;
import com.rosetvonline.rosetvonline.RoseC.Go_Y_Fragment;
import com.rosetvonline.rosetvonline.Home.Post.Post_viewFragment;
import com.rosetvonline.rosetvonline.Home.Profile.Profile_viewFragment;
import com.rosetvonline.rosetvonline.Home.Search.Search_viewFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Post_viewFragment();
            case 1:
                return new Search_viewFragment();
           /* case 2:
                return new BlankFragment();*/
            case 2:
                return new Profile_viewFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
