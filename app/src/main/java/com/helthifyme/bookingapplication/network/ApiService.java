package com.helthifyme.bookingapplication.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Amardeep.
 */
public interface ApiService {

    String BOOKING_URL = "booking/slots/all?username=alok%40x.coz&api_key=a4aeb4e27f27b5786828f6cdf00d8d2cb44fe6d7&vc=276&expert_username=neha%40healthifyme.com&format=json";
    String REQUEST_BASE_URL = "http://108.healthifyme.com/api/v1/";

    @GET(BOOKING_URL)
    Call<String> requestBooking();
}
