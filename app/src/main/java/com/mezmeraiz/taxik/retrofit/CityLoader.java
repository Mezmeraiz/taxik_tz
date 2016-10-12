package com.mezmeraiz.taxik.retrofit;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 12.10.2016.
 */

public class CityLoader extends AsyncTaskLoader<List<Cities.City>> {

    private static String BASE_URL = "http://beta.taxistock.ru/taxik/api/client/";

    public CityLoader(Context context) {
        super(context);
    }

    @Override
    public List<Cities.City> loadInBackground() {
        try {
            return apiCall();
        } catch (IOException e) {
            return null;
        }
    }

    private List<Cities.City> apiCall() throws IOException {
        CityService cityService = getCityService();
        Call<Cities> call = cityService.cities();
        return call.execute().body().getCityList();
    }

    private CityService getCityService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CityService.class);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
