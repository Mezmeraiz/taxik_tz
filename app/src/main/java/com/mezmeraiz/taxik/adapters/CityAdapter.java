package com.mezmeraiz.taxik.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mezmeraiz.taxik.AdapterListener;
import com.mezmeraiz.taxik.R;
import com.mezmeraiz.taxik.retrofit.Cities;
import java.util.List;

/**
 * Created by pc on 12.10.2016.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    List<Cities.City> mCityList;
    Context mContext;
    AdapterListener mAdapterListener;

    public CityAdapter(Context context, List<Cities.City> cityList, AdapterListener adapterListener) {
        mCityList = cityList;
        mContext = context;
        mAdapterListener = adapterListener;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        return new CityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.mCityNameTextView.setText(mCityList.get(position).getName());
        holder.mClickView.setTag(position);
        holder.mClickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                String cityName = mCityList.get(position).getName();
                double longitude = mCityList.get(position).getLongitude();
                double latitude = mCityList.get(position).getLatitude();
                mAdapterListener.onClickCity(cityName, longitude, latitude);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder{

        TextView mCityNameTextView;
        View mClickView;

        public CityViewHolder(View itemView) {
            super(itemView);
            mCityNameTextView = (TextView) itemView.findViewById(R.id.textViewCityName);
            mClickView = itemView.findViewById(R.id.clickView);
        }
    }
}
