package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        magnitude.setText(Double.toString(currentEarthquake.getMagnitude()));

        TextView secondaryLocation = earthquakeView.findViewById(R.id.secondary_location_view);
        secondaryLocation.setText(currentEarthquake.getSecondaryLocation());

        TextView primaryLocation = earthquakeView.findViewById(R.id.primary_location_view);
        primaryLocation.setText(currentEarthquake.getPrimaryLocation());

        TextView date = earthquakeView.findViewById(R.id.date_view);
        date.setText(currentEarthquake.getConvertedDate());

        TextView time = earthquakeView.findViewById(R.id.time_view);
        time.setText(currentEarthquake.getConvertedTime());


        return earthquakeView;
    }
}
