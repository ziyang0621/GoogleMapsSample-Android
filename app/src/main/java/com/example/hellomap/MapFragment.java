package com.example.hellomap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by ziyang0621 on 3/20/15.
 */
public class MapFragment extends SupportMapFragment {

    private GoogleMap mMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMap = ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap = ((SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
