package com.example.presensimahasiswa;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
       super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            case 1:
                PresensiFragment presensiFragment = new PresensiFragment();
                return  presensiFragment;
            default:
        return null;
    }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
