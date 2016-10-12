package com.mezmeraiz.taxik.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.mezmeraiz.taxik.AdapterListener;
import com.mezmeraiz.taxik.R;
import com.mezmeraiz.taxik.adapters.CityAdapter;
import com.mezmeraiz.taxik.retrofit.Cities;
import com.mezmeraiz.taxik.retrofit.CityLoader;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Cities.City>>, AdapterListener{

    RecyclerView mRecyclerView;
    public static final int CITY_LOADER_ID = 1;
    public static final String LATITUDE_KEY = "LATITUDE_KEY";
    public static final String LONGITUDE_KEY = "LONGITUDE_KEY";
    public static final String NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        getSupportLoaderManager().initLoader(CITY_LOADER_ID, null, this);
    }

    private void initRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public Loader<List<Cities.City>> onCreateLoader(int id, Bundle args) {
        return new CityLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Cities.City>> loader, List<Cities.City> data) {
        findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        if(data != null)
            mRecyclerView.setAdapter(new CityAdapter(this, data, this));
    }

    @Override
    public void onLoaderReset(Loader<List<Cities.City>> loader) {

    }

    @Override
    public void onClickCity(String cityName, double longitude, double latitude) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(NAME, cityName);
        intent.putExtra(LATITUDE_KEY, latitude);
        intent.putExtra(LONGITUDE_KEY, longitude);
        startActivity(intent);
    }
}