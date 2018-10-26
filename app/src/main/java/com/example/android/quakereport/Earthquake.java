package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {
    private double mMagnitude;
    private String mFullLocation;
    private String mSecondaryLocation;
    private String mPrimaryLocation;
    private long mTime;
    private String mConvertedDate;
    private String mConvertedTime;

    Earthquake(double magnitude, String location, long time){
        //Set mMagnitude to be a double with 1 decimal place

        mMagnitude = magnitude;

        mFullLocation = location;
        //Split mFullLocation into Primary and Secondary locations
        if (mFullLocation.contains("of")){
            //Find position of Primary Location by indexing "of" and adding 2
            int primaryLocationStart = mFullLocation.indexOf("of") + 3;

            mSecondaryLocation = mFullLocation.substring(0,primaryLocationStart);
            mPrimaryLocation = mFullLocation.substring(primaryLocationStart);
        } else {
            mSecondaryLocation = "Near";
            mPrimaryLocation = mFullLocation;
        }

        mTime = time;
        //Convert mTime long into standard DateTime format

        //New Date
        Date date = new java.util.Date(mTime);
        //Formatting of date
        SimpleDateFormat formattedDate = new java.text.SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat formattedTime = new java.text.SimpleDateFormat("HH:mm a");
        //Give a timezone reference for formatting (currently unused)
        // sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        mConvertedDate = formattedDate.format(date);
        mConvertedTime = formattedTime.format(date);
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getSecondaryLocation() {
        return mSecondaryLocation;
    }

    public String getPrimaryLocation() {
        return mPrimaryLocation;
    }

    public long getTime() {
        return mTime;
    }

    public String getConvertedDate() {
        return mConvertedDate;
    }

    public String getConvertedTime(){
        return mConvertedTime;
    }
}
