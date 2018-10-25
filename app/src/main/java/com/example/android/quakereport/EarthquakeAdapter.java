package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context,0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if reusable view exists, else inflate view
        View earthquakeView = convertView;
        if (earthquakeView == null) {
            earthquakeView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent,false);
        }

        //Get current earthquake item
        Earthquake currentEarthquake = getItem(position);

        //Set data for earthquake item
        TextView magnitude = earthquakeView.findViewById(R.id.magnitude_view);
        magnitude.setText(currentEarthquake.getMagnitude());

        TextView location = earthquakeView.findViewById(R.id.location_view);
        location.setText(currentEarthquake.getLocation());

        TextView time = earthquakeView.findViewById(R.id.time_view);
        time.setText(currentEarthquake.getTime());


        return earthquakeView;
    }
}