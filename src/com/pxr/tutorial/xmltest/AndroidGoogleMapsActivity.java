package com.pxr.tutorial.xmltest;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


public class AndroidGoogleMapsActivity extends MapActivity {
	String cur_lat,cur_lng,loc_lat,loc_lng;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainm);
        
        Bundle b=getIntent().getExtras();
        
        cur_lat=b.getString(" cur_lat1");
        cur_lng=b.getString(" cur_lng1");
        loc_lat=b.getString("loc_lat1");
        loc_lng=b.getString("loc_lng1");
        
        // Displaying Zooming controls
        MapView mapView = (MapView) findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        
        /**
         * Changing Map Type
         * */
        // mapView.setSatellite(true); // Satellite View
        // mapView.setStreetView(true); // Street View
        // mapView.setTraffic(true); // Traffic view18.53297,73.87981
        
        /**
         * showing location by Latitude and Longitude
         * */        
        MapController mc = mapView.getController();
        double lat = Double.parseDouble(loc_lat);
        double lon = Double.parseDouble(loc_lng);
        GeoPoint geoPoint = new GeoPoint((int)(lat * 1E6), (int)(lon * 1E6));
        mc.animateTo(geoPoint);
        mc.setZoom(15);
        mapView.invalidate(); 
           
        
        /**
         * Placing Marker
         * */
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.mark_red);
        AddItemizedOverlay itemizedOverlay = 
             new AddItemizedOverlay(drawable, this);
        
        
        OverlayItem overlayitem = new OverlayItem(geoPoint, "Hello", "Sample Overlay item");
        
        itemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);
        
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}