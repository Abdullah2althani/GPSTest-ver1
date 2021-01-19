package com.moveriospectacles.testforgp.gpstest;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class myLocationLis implements LocationListener {
    Context context;

    public myLocationLis(Context context){
        this.context=context;
    }

    @Override
    public void onLocationChanged(Location location) {
        String string ="Log:" + String.valueOf(location.getAltitude()) + ",Lat:" + String.valueOf(location.getLatitude());
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(context, "GPS status change", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(context, "GPS Enabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(context, "GPS disabled", Toast.LENGTH_SHORT).show();
    }
}
