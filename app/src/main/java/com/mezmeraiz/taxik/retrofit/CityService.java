package com.mezmeraiz.taxik.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pc on 11.10.2016.
 */

public interface CityService {

    @GET("query_cities")
    Call<Cities> cities();
}
