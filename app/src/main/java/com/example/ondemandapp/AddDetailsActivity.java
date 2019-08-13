package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.arsy.maps_library.MapRipple;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AddDetailsActivity extends AppCompatActivity implements LocationListener, OnMapReadyCallback {
    GoogleMap map;
    TextView tv_location,tv_save_address;
    double latitude, longitude;
    SharedPreferences sp_location;
    Marker marker;
    Context context;
    private MapRipple mapRipple;
    SharedPreferences.Editor ed_location;
    LatLng latLng;
    ImageView iv_details_back;
    private final int ANIMATION_TYPE_RIPPLE = 0;
    Spinner spinner_gender;
    ArrayAdapter genderadapter;
    List<String> gender = new ArrayList<>();
    private ScrollView mScrollView;
    private int whichAnimationWasRunning = ANIMATION_TYPE_RIPPLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);
        tv_location = findViewById(R.id.tv_location);
        spinner_gender = findViewById(R.id.spinner_gender);
        iv_details_back = findViewById(R.id.iv_details_back);
        tv_save_address = findViewById(R.id.tv_save_address);
        context = this;


        sp_location = getSharedPreferences("SAVELOCATIONCURRENT", MODE_PRIVATE);
        ed_location = sp_location.edit();

        if (sp_location.getString("address", "").equals("")) {
        } else {
            tv_location.setText(sp_location.getString("address", ""));
        }

        if (!isGooglePlayServicesAvailable()) {
            finish();
        }
        SupportMapFragment supportMapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        supportMapFragment.getMapAsync(this);



        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                50,
                1, this);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            onLocationChanged(location);


        }

        gender.add("Mr");
        gender.add("Mrs");
        gender.add("Miss");

        genderadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(genderadapter);

        iv_details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_save_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddDetailsActivity.this,SaveAddressActivity.class));
            }
        });


    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }

    @Override
    public void onLocationChanged(final Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        latLng = new LatLng(latitude, longitude);
        // Marker marker = map.addMarker(new MarkerOptions().position(latLng));


        map.addMarker(new MarkerOptions().position(latLng).title("Current Location"))
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));


//animation
        mapRipple = new MapRipple(map, latLng, context);
        startMarkerAnimation();


        // MarkerAnimation.animateMarkerToGB(marker, latLng, new LatLngInterpolator.Spherical());

        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
            //map.addMarker(new MarkerOptions().title(address));
            ed_location.putString("address", address);
            ed_location.commit();
            tv_location.setText(address);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void startMarkerAnimation() {
        mapRipple.withNumberOfRipples(1);
        mapRipple.withFillColor(Color.parseColor("#FFA3D2E4"));
        mapRipple.withStrokewidth(1);      //0dp
        mapRipple.startRippleMapAnimation();
        whichAnimationWasRunning = ANIMATION_TYPE_RIPPLE;

        if (mapRipple.isAnimationRunning()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mapRipple.stopRippleMapAnimation();
                    mapRipple.withLatLng(latLng);
                    startMarkerAnimation();
                }
            }, 3000);
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setZoomGesturesEnabled(true);
        map.getUiSettings().setCompassEnabled(true);
    }
}
