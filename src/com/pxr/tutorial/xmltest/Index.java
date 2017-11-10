package com.pxr.tutorial.xmltest;


import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
//import com.pxr.tutorial.xmltest.AndroidGoogleMapsActivity.java;

public class Index extends ListActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listplaceholder);
        
       
        
        
      
        Bundle b=getIntent().getExtras();
        
          String s=b.getString("flag");
          String s1=b.getString("ra");
         String  lat1=b.getString("lat");
         String lng1=b.getString("lng");
         if(lat1==null)
        {
        	lat1="18.52043";
        }
        
        if(lng1==null)
        {
        	lng1="73.85674";
        }
       final String  lat11=lat1;
        final String  lng11=lng1;
        int r=Integer.parseInt(s1);
        
        
        
      
        
//          double lat=18.5339;
//        double lng=71.57999;
        //int r=Integer.parseInt(s1);
       
      // double lat=Double.parseDouble("lat1");
       //duble lng=Double.parseDouble("lng1");
      
        //lng=Double.parseDouble("lng1");
        
        new XMLfunctions(s,r,lat1,lng1);
        
        
       ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        String xml = XMLfunctions.getXML();
        Document doc = XMLfunctions.XMLfromString(xml);
                
      /*  int numResults = XMLfunctions.numResults(doc);
        
        if((numResults <= 0)){
        	Toast.makeText(Index.this, "Geen resultaten gevonden "+numResults, Toast.LENGTH_LONG).show();  
        	finish();
        }*/
                
		NodeList nodes = doc.getElementsByTagName("result");
					
		for (int i = 0; i < nodes.getLength(); i++)
		{							
			HashMap<String, String> map = new HashMap<String, String>();	
			Element e = (Element)nodes.item(i);
			map.put("id", XMLfunctions.getValue(e, "id"));
        	map.put("name", "Name: " + XMLfunctions.getValue(e, "name")+"\nLocation:" + XMLfunctions.getValue(e, "vicinity"));
        	map.put("latitude", XMLfunctions.getValue(e, "lat"));
        	map.put("longitude", XMLfunctions.getValue(e, "lng"));
        	//map.put("name", "Location:" + XMLfunctions.getValue(e, "vicinity"));
        	mylist.add(map);			
		}		
       
		
		
		
		
        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.main,new String[] { "name", "vicinity" },
        		new int[] {R.id.item_title, R.id.item_subtitle});
        
        setListAdapter(adapter);
        
        final ListView lv = getListView();
        lv.setTextFilterEnabled(true);	
        
        lv.setOnItemClickListener(new OnItemClickListener()
        {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        	{ 
        		HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	
        			
    			Bundle b=new Bundle();
    			Intent i=new Intent(Index.this,AndroidGoogleMapsActivity.class);
    			b.putString("loc_lat1",o.get("latitude"));
    			b.putString("loc_lng1", o.get("longitude"));
    			b.putString("cur_lat1", lat11);
    			b.putString("cur_lng1", lng11);
    			i.putExtras(b);
    			startActivity(i);
        		//@SuppressWarnings("unchecked")
				//HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
        		//Toast.makeText(Index.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_LONG).show(); 
        		//Toast.makeText(Index.this, "latitude '" + o.get("latitude") + "longitude '" + o.get("longitude") + "' was clicked.", Toast.LENGTH_LONG).show(); 
        		
			}
		});
    }
}