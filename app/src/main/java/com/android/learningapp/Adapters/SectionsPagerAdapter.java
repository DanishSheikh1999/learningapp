package com.android.learningapp.Adapters;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.android.learningapp.Fragment.FragmentHome;
import com.android.learningapp.Fragment.FragmentSocial;
import com.android.learningapp.Fragment.FragmentTask;
import com.android.learningapp.R;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentHome fragmentHome = new FragmentHome();
                return fragmentHome;
            case 1:
                FragmentTask fragmentTask = new FragmentTask();
                return fragmentTask;
            case 2:
                FragmentSocial fragmentSocial = new FragmentSocial();
                return fragmentSocial;
            default:
                FragmentHome fragmentHomeDefault = new FragmentHome();
                return fragmentHomeDefault;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 3;
    }
}