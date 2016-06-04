package com.helthifyme.bookingapplication.network;



import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Amardeep.
 */
public class NetworkManager {

    private static ApiService apiService;
    private static Retrofit getRetroFit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return  new Retrofit.Builder()
                .baseUrl(ApiService.REQUEST_BASE_URL)
                .client(client)
                .addConverterFactory(new ToStringConverterFactory())
                .build();
    }

    private static ApiService getApiService() {
        if (apiService == null) {
            apiService = getRetroFit().create(ApiService.class);
        }
        return apiService;
    }

    public static void requestBooking(Callback<String> callback) {
        ApiService service = getApiService();
        Call<String> model = service.requestBooking();
        model.enqueue(callback);
    }
}
