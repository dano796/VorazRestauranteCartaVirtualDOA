package com.upb.myrestaurant;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.upb.myrestaurant.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng upbMedellin = new LatLng(6.200587, -75.564498);
        LatLng laureles = new LatLng(6.244459, -75.595805);
        LatLng upb = new LatLng(6.240456, -75.590576);
        LatLng provenza = new LatLng(6.206918, -75.565589);
        LatLng palmas = new LatLng(6.153926, -75.532666);

        mMap.addMarker(new MarkerOptions()
                .position(laureles)
                .title("Voraz Laureles")
                .snippet("Cq 74 #39-18, Laureles - Estadio, Medellín")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo_mapa)));

        mMap.addMarker(new MarkerOptions()
                .position(upb)
                .title("Voraz U.P.B")
                .snippet("Cq. 1 #70 01, Laureles - Estadio, Medellín")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo_mapa)));

        mMap.addMarker(new MarkerOptions()
                .position(provenza)
                .title("Voraz Provenza")
                .snippet("Cra. 35 #7-108, El Poblado, Medellín")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo_mapa)));

        mMap.addMarker(new MarkerOptions()
                .position(palmas)
                .title("Voraz Palmas")
                .snippet("Km 17, Av. Las Palmas")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo_mapa)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(upbMedellin, 13));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Set the custom info window adapter
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
    }
}
