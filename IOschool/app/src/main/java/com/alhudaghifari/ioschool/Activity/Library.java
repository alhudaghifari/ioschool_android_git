package com.alhudaghifari.ioschool.Activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.alhudaghifari.ioschool.Fragment.FragmentBahasa;
import com.alhudaghifari.ioschool.Fragment.FragmentBiologi;
import com.alhudaghifari.ioschool.Fragment.FragmentEkonomi;
import com.alhudaghifari.ioschool.Fragment.FragmentFisika;
import com.alhudaghifari.ioschool.Fragment.FragmentGeografi;
import com.alhudaghifari.ioschool.Fragment.FragmentKimia;
import com.alhudaghifari.ioschool.Fragment.FragmentLainlain;
import com.alhudaghifari.ioschool.Fragment.FragmentMatematika;
import com.alhudaghifari.ioschool.Fragment.FragmentSeni;
import com.alhudaghifari.ioschool.Fragment.FragmentSosiologi;
import com.alhudaghifari.ioschool.R;

public class Library extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private static final int PAGE_FISIKA = 0;
    private static final int PAGE_BIOLOGI = 1;
    private static final int PAGE_KIMIA = 2;
    private static final int PAGE_EKONOMI = 3;
    private static final int PAGE_SOSIOLOGI = 4;
    private static final int PAGE_GEOGRAFI = 5;
    private static final int PAGE_MATEMATIKA = 6;
    private static final int PAGE_BAHASA = 7;
    private static final int PAGE_SENI = 8;
    private static final int PAGE_LAINLAIN = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_library, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        FragmentFisika fragmentFisika = new FragmentFisika();
        FragmentBiologi fragmentBiologi = new FragmentBiologi();
        FragmentKimia fragmentKimia = new FragmentKimia();
        FragmentEkonomi fragmentEkonomi = new FragmentEkonomi();
        FragmentSosiologi fragmentSosiologi = new FragmentSosiologi();
        FragmentGeografi fragmentGeografi = new FragmentGeografi();
        FragmentMatematika fragmentMatematika = new FragmentMatematika();
        FragmentBahasa fragmentBahasa = new FragmentBahasa();
        FragmentSeni fragmentSeni = new FragmentSeni();
        FragmentLainlain fragmentLainlain = new FragmentLainlain();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return fragmentFisika;
                case 1:
                    return fragmentBiologi;
                case 2:
                    return fragmentKimia;
                case 3:
                    return fragmentEkonomi;
                case 4:
                    return fragmentSosiologi;
                case 5:
                    return fragmentGeografi;
                case 6:
                    return fragmentMatematika;
                case 7:
                    return fragmentBahasa;
                case 8:
                    return fragmentSeni;
                case 9:
                    return fragmentLainlain;
                default:
                    return fragmentFisika;
            }
        }

        @Override
        public int getCount() {
            // Show 10 total pages.
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case PAGE_FISIKA:
                    return "Fisika";
                case PAGE_BIOLOGI:
                    return "Biologi";
                case PAGE_KIMIA:
                    return "Kimia";
                case PAGE_EKONOMI:
                    return "Ekonomi";
                case PAGE_SOSIOLOGI:
                    return "Sosiologi";
                case PAGE_GEOGRAFI:
                    return "Geografi";
                case PAGE_MATEMATIKA:
                    return "Matematika";
                case PAGE_BAHASA:
                    return "Bahasa";
                case PAGE_SENI:
                    return "Seni";
                case PAGE_LAINLAIN:
                    return "Lain-lain";
            }
            return null;
        }
    }
}
