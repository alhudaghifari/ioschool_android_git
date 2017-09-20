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

import com.alhudaghifari.ioschool.Fragment.FragmentAcademic;
import com.alhudaghifari.ioschool.Fragment.FragmentAchievement;
import com.alhudaghifari.ioschool.Fragment.FragmentBahasa;
import com.alhudaghifari.ioschool.Fragment.FragmentBiologi;
import com.alhudaghifari.ioschool.Fragment.FragmentEkonomi;
import com.alhudaghifari.ioschool.Fragment.FragmentEvent;
import com.alhudaghifari.ioschool.Fragment.FragmentExtra;
import com.alhudaghifari.ioschool.Fragment.FragmentFisika;
import com.alhudaghifari.ioschool.Fragment.FragmentGeografi;
import com.alhudaghifari.ioschool.Fragment.FragmentHariJumat;
import com.alhudaghifari.ioschool.Fragment.FragmentHariKamis;
import com.alhudaghifari.ioschool.Fragment.FragmentHariRabu;
import com.alhudaghifari.ioschool.Fragment.FragmentHariSabtu;
import com.alhudaghifari.ioschool.Fragment.FragmentHariSelasa;
import com.alhudaghifari.ioschool.Fragment.FragmentHariSenin;
import com.alhudaghifari.ioschool.Fragment.FragmentKimia;
import com.alhudaghifari.ioschool.Fragment.FragmentLainlain;
import com.alhudaghifari.ioschool.Fragment.FragmentMatematika;
import com.alhudaghifari.ioschool.Fragment.FragmentSeni;
import com.alhudaghifari.ioschool.Fragment.FragmentSosiologi;
import com.alhudaghifari.ioschool.R;

public class ScheduleReguler extends AppCompatActivity {

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

    private static final int PAGE_SENIN = 0;
    private static final int PAGE_SELASA = 1;
    private static final int PAGE_RABU = 2;
    private static final int PAGE_KAMIS = 3;
    private static final int PAGE_JUMAT = 4;
    private static final int PAGE_SABTU = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_reguler);

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
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        FragmentHariSenin fragmentHariSenin = new FragmentHariSenin();
        FragmentHariSelasa fragmentHariSelasa = new FragmentHariSelasa();
        FragmentHariRabu fragmentHariRabu = new FragmentHariRabu();
        FragmentHariKamis fragmentHariKamis = new FragmentHariKamis();
        FragmentHariJumat fragmentHariJumat = new FragmentHariJumat();
        FragmentHariSabtu fragmentHariSabtu = new FragmentHariSabtu();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case PAGE_SENIN:
                    return fragmentHariSenin;
                case PAGE_SELASA:
                    return fragmentHariSelasa;
                case PAGE_RABU:
                    return fragmentHariRabu;
                case PAGE_KAMIS:
                    return fragmentHariKamis;
                case PAGE_JUMAT:
                    return fragmentHariJumat;
                case PAGE_SABTU:
                    return fragmentHariSabtu;
                default:
                    return fragmentHariSenin;
            }
        }

        @Override
        public int getCount() {
            // Show 10 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case PAGE_SENIN:
                    return "Senin";
                case PAGE_SELASA:
                    return "Selasa";
                case PAGE_RABU:
                    return "Rabu";
                case PAGE_KAMIS:
                    return "Kamis";
                case PAGE_JUMAT:
                    return "Jumat";
                case PAGE_SABTU:
                    return "Sabtu";
            }
            return null;
        }
    }
}
