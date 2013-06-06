package com.droidschools.mapsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.droischools.mapsample.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		LatLng koratty = new LatLng(10.26127,76.35465);
		LatLng trichurRound = new LatLng(10.527549,76.214487);
		LatLng infopark = new LatLng(10.268992,76.354183);
		GoogleMap map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		//map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		map.addMarker(new MarkerOptions().position(koratty).title(
				"Koratty zodiac bar").snippet("best drinks available ").anchor(0, 0));
		map.addMarker(new MarkerOptions().position(infopark).title("Infopark koratty"));
		map.addPolyline(new PolylineOptions().add(koratty, infopark , trichurRound).width(5).color(Color.RED));
		// Shows my point on map
		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(koratty, 15));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}
