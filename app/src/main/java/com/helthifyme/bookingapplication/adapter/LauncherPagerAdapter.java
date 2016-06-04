/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.helthifyme.bookingapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.helthifyme.bookingapplication.dto.Day;
import com.helthifyme.bookingapplication.fragment.BookingExpandableFragment;

import java.util.List;

public class LauncherPagerAdapter extends FragmentPagerAdapter {
    private final List<Day> mDayList;

    public LauncherPagerAdapter(FragmentManager fm, List<Day> dayList) {
        super(fm);
        mDayList = dayList;
    }

    @Override
    public int getCount() {
        return mDayList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return BookingExpandableFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDayList.get(position).getDay() + "\n" + mDayList.get(position).getDayOfWeek();
    }
}
