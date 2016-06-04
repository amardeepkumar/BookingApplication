package com.helthifyme.bookingapplication.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.helthifyme.bookingapplication.R;
import com.helthifyme.bookingapplication.adapter.LauncherPagerAdapter;
import com.helthifyme.bookingapplication.data.AbstractExpandableDataProvider;
import com.helthifyme.bookingapplication.dto.Day;
import com.helthifyme.bookingapplication.fragment.BookingExpandableDataProviderFragment;
import com.helthifyme.bookingapplication.network.NetworkManager;
import com.helthifyme.bookingapplication.util.DateUtils;
import com.helthifyme.bookingapplication.util.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<String> {
    private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
    private static final String TAG = MainActivity.class.getSimpleName();
    private TabLayout tabLayout;
    private ViewPager pager;
    private ArrayList<Day> mDayList;
    private TextView monthTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDayList = new ArrayList<>();

        monthTextView = (TextView) findViewById(R.id.month);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        pager = (ViewPager) findViewById(R.id.viewpager);

        fetchBookingDetails();
    }

    private void fetchBookingDetails() {
        if (NetworkUtil.isConnectionAvailable(this)) {
            NetworkManager.requestBooking(this);
        } else {
            Toast.makeText(this, "No Internet.", Toast.LENGTH_SHORT).show();
        }
    }


    public AbstractExpandableDataProvider getDataProvider(int position) {
        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
        return ((BookingExpandableDataProviderFragment) fragment).getDataProvider(position);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            try {
                JSONObject slots = new JSONObject(response.body());
                JSONObject days = new JSONObject(slots.getString("slots"));
                Iterator keys = days.keys();

                Gson gson = new GsonBuilder().create();
                while(keys.hasNext()) {
                    // loop to get the dynamic key
                    String currentDynamicKey = (String)keys.next();

                    // get the value of the dynamic key
                    JSONObject currentDynamicValue = days.getJSONObject(currentDynamicKey);
                    Day day = gson.fromJson(currentDynamicValue.toString(), Day.class);
                    DateUtils.formatDay(currentDynamicKey, day);
                    mDayList.add(day);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            monthTextView.setText(mDayList.get(0).getMonth());

            getSupportFragmentManager().beginTransaction()
                    .add(new BookingExpandableDataProviderFragment(mDayList), FRAGMENT_TAG_DATA_PROVIDER)
                    .commit();
            pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    monthTextView.setText(mDayList.get(position).getMonth());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            pager.setAdapter(new LauncherPagerAdapter(getSupportFragmentManager(), mDayList));
            tabLayout.setupWithViewPager(pager);
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(this, "Server error", Toast.LENGTH_SHORT).show();
    }
}

