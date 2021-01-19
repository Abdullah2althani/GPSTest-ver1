package com.moveriospectacles.testforgp.gpstest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").snippet("here im live"));
        mMap.addCircle(new CircleOptions()
                .center(sydney)
                .radius(500)
                .strokeColor(Color.GRAY)
                .fillColor(Color.BLUE)
        );


        LatLng sydney2 = new LatLng(-34.01, 151.01);
        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").snippet("here im live").icon((BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone))));
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Marker in Sydney2").snippet("here im live"));

        mMap.addPolyline(new PolylineOptions()
                .add(sydney, sydney2)
                .width(10)
                .color(Color.GRAY)
                .geodesic(true));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Added by clicked").snippet("here im live"));
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14));
    }
}
