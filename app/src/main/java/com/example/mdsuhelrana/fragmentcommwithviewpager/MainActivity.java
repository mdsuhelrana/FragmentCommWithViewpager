package com.example.mdsuhelrana.fragmentcommwithviewpager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    String tabFragmentB;

    public String getTabFragmentB() {
        return tabFragmentB;
    }

    public void setTabFragmentB(String tabFragmentB) {
        this.tabFragmentB = tabFragmentB;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tablayout_Id);
        viewPager=findViewById(R.id.viewPager_Id);

        tabLayout.addTab(tabLayout.newTab().setText("frag -1").setIcon(R.mipmap.ic_launcher));
        tabLayout.addTab(tabLayout.newTab().setText("frag -2").setIcon(R.mipmap.ic_launcher));

        SwipePagerAdapter adapter=new SwipePagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public class SwipePagerAdapter extends FragmentPagerAdapter{
             int tabcount;

        public SwipePagerAdapter(FragmentManager fm,int tabcount) {
            super(fm);
            this.tabcount=tabcount;
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new OneFragment();
            }else if(position==1){
                return new TwoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabcount;
        }
    }

}
