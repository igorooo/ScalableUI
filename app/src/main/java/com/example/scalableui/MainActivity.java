package com.example.scalableui;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;


import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.FrameLayout;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity implements
        CameraFragment.OnCameraFragmentInteractionListener,
        PhotoFragment.OnPhotoFragmentInteractionListener {

    private Bitmap mPhoto;

    private static final String TAG = "MainActivity";

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FrameLayout mFrameFrag1, mFrameFrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameFrag1 = (FrameLayout) findViewById(R.id.fl1);
        mFrameFrag2 = (FrameLayout) findViewById(R.id.fl2);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.fl1, new CameraFragment());
        ft.add(R.id.fl2, new PhotoFragment());

        ft.commit();

    }

    @Override
    public void onCameraFragmentInteraction(Bitmap bitmap) {
        mPhoto = bitmap;
    }

    @Override
    public Bitmap onPhotoFragmentInteraction() {
        return mPhoto;
    }
}