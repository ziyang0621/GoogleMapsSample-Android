package com.example.hellomap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.squareup.picasso.Picasso;

public class MainActivity extends FragmentActivity {
    private GoogleMap mMap;
    private PicassoItem targetOne;
    private PicassoItem targetTwo;
    private PicassoItem targetThree;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpMapIfNeeded();

       MarkerOptions markerOne = new MarkerOptions().position(new LatLng(51.5, -0.1)).title("");
       targetOne = new PicassoItem<Marker>(mMap.addMarker(markerOne));
       Picasso.with(MainActivity.this).load("http://images.clipartpanda.com/google-map-icon-Google_Maps.png").into(targetOne);

        MarkerOptions markerTwo = new MarkerOptions().position(new LatLng(40.7, -74.0)).title("");
        targetTwo = new PicassoItem<Marker>(mMap.addMarker(markerTwo));
        Picasso.with(MainActivity.this).load("http://icons.iconarchive.com/icons/icons-land/vista-map-markers/256/Map-Marker-Marker-Outside-Chartreuse-icon.png").into(targetTwo);

        BitmapDescriptor image = BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
        GroundOverlayOptions groundOverlay = new GroundOverlayOptions().position(new LatLng(40.7, -24.0), 2000000f).transparency(0.5f).image(image);
        targetThree = new PicassoItem<GroundOverlay>(mMap.addGroundOverlay(groundOverlay));
        Picasso.with(MainActivity.this).load("http://www.fertilitycircle.com/fertilitycircle/images/MedCircle.png").into(targetThree);

        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(51.5, -0.1), new LatLng(40.7, -74.0))
                .width(5)
                .color(Color.RED));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40.7, -84.0)));


    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                return false;
            }
        });
        if (mMap == null) {
            return;
        }

    }
}
