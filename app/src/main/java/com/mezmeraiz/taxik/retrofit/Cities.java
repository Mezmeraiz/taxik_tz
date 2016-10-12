package com.mezmeraiz.taxik.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pc on 11.10.2016.
 */

public class Cities {

    @SerializedName("cities")
    private List<City> mCityList;

    public Cities() {

    }

    public List<City> getCityList(){
        return mCityList;
    }

    public static class City {

        @SerializedName("city_id")
        private int mId;

        @SerializedName("city_name")
        private String mName;

        @SerializedName("city_api_url")
        private String mApiUrl;

        @SerializedName("city_domain")
        private String mDomain;

        @SerializedName("city_mobile_server")
        private String mMobileServer;

        @SerializedName("city_doc_url")
        private String mDocUrl;

        @SerializedName("city_latitude")
        private double mLatitude;

        @SerializedName("city_longitude")
        private double mLongitude;

        @SerializedName("last_app_android_version")
        private int mLastAppAndroidVersion;

        @SerializedName("android_driver_apk_link")
        private String mDriverApkLink;

        @SerializedName("inapp_pay_methods")
        private List<String> mInappPayMethods;

        @SerializedName("transfers")
        private boolean mTransfers;

        @SerializedName("experimental_econom_plus")
        private int mExperimentalEconomPlus;

        @SerializedName("experimental_econom_plus_time")
        private int mExperimentalEconomPlusTime;

        @SerializedName("registration_promocode")
        private boolean mRegistrationPromocode;

        public City(){

        }

        public int getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }

        public String getApiUrl() {
            return mApiUrl;
        }

        public String getDomain() {
            return mDomain;
        }

        public String getMobileServer() {
            return mMobileServer;
        }

        public String getDocUrl() {
            return mDocUrl;
        }

        public double getLatitude() {
            return mLatitude;
        }

        public double getLongitude() {
            return mLongitude;
        }

        public int getLastAppAndroidVersion() {
            return mLastAppAndroidVersion;
        }

        public String getDriverApkLink() {
            return mDriverApkLink;
        }

        public List<String> getInappPayMethods() {
            return mInappPayMethods;
        }

        public boolean isTransfers() {
            return mTransfers;
        }

        public int getExperimentalEconomPlus() {
            return mExperimentalEconomPlus;
        }

        public int getExperimentalEconomPlusTime() {
            return mExperimentalEconomPlusTime;
        }

        public boolean isRegistrationPromocode() {
            return mRegistrationPromocode;
        }
    }
}
