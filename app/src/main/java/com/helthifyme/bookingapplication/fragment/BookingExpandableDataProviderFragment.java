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

package com.helthifyme.bookingapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.helthifyme.bookingapplication.data.AbstractExpandableDataProvider;
import com.helthifyme.bookingapplication.data.ExampleExpandableDataProvider;
import com.helthifyme.bookingapplication.dto.Day;

import java.util.ArrayList;
import java.util.List;


public class BookingExpandableDataProviderFragment extends Fragment {
    private List<Day> mDayList;
    private List<ExampleExpandableDataProvider> mDataProvider;

    public BookingExpandableDataProviderFragment(List<Day> dayList) {
        mDayList = dayList;
    }

    public BookingExpandableDataProviderFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);  // keep the mDataProvider instance

        mDataProvider = new ArrayList<>();
        for (Day day :
                mDayList) {
            mDataProvider.add(new ExampleExpandableDataProvider(day));
        }
    }

    public AbstractExpandableDataProvider getDataProvider(int position) {
        return mDataProvider.get(position);
    }
}
