package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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


        TextView magnitudeView = earthquakeView.findViewById(R.id.magnitude_view);
        double magnitude = currentEarthquake.getMagnitude();
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(magnitude);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        magnitudeView.setText(magnitudeFormat.format(magnitude));




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

    public int getMagnitudeColor(double magnitudeDouble) {
        int magnitude = (int) magnitudeDouble;
        switch (magnitude) {
            case 0:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }


    }
}
