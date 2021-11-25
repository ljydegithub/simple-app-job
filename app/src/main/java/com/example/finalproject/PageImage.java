package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class PageImage extends Fragment {
    private ViewPager viewPager;
    List<Fragment> fragments=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_image, null);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        fragments.add(new Frag01());
        fragments.add(new Frag02());
        fragments.add(new Frag03());
        fragments.add(new Frag04());
        fragments.add(new Frag05());
        fragments.add(new Frag06());
        fragments.add(new Frag07());
        fragments.add(new Frag08());
        fragments.add(new Frag09());
        fragments.add(new Frag10());
        fragments.add(new Frag11());
        fragments.add(new Frag12());
        fragments.add(new Frag13());

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        return view;
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
