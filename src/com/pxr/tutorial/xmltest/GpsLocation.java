package com.pxr.tutorial.xmltest;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class GpsLocation extends Activity implements OnClickListener
{
Button atm,uni,hps,rail;
EditText e;
String flg;
Bundle b;
String lat,lng;
@Override
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.index);

	e=(EditText)findViewById(R.id.rds);
	
	 
    Bundle b=getIntent().getExtras();
    
    lat=b.getString("lat");
    lng=b.getString("lng");
	
	
	atm=(Button)findViewById(R.id.button1);
	atm.setOnClickListener(this);
	
	uni=(Button)findViewById(R.id.uni);
	uni.setOnClickListener(this);
	
	hps=(Button)findViewById(R.id.hps);
	hps.setOnClickListener(this);
	
	rail=(Button)findViewById(R.id.rail);
	rail.setOnClickListener(this);
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	
	if(v.equals(atm))
	{
		Bundle b=new Bundle();
		
		flg=e.getText().toString();
		
		Intent i=new Intent(GpsLocation.this,Index.class);
	
		b.putString("flag", "atm");
		b.putString("ra", flg);
		b.putString("lat", lat);
		b.putString("lng", lng);
		i.putExtras(b);
		startActivity(i);
	}
	
	else if(v.equals(uni))
	{
		Bundle b1=new Bundle();
		
		flg=e.getText().toString();
		
		Intent i1=new Intent(GpsLocation.this,Index.class);
	
		b1.putString("flag", "university");
		b1.putString("ra", flg);
		b1.putString("lat", lat);
		b1.putString("lng", lng);
		
		i1.putExtras(b1);
		startActivity(i1);
	}
	
	else if(v.equals(hps))
	{
		Bundle b=new Bundle();
		
		flg=e.getText().toString();
		
		Intent i=new Intent(GpsLocation.this,Index.class);
	
		b.putString("flag", "hospital");
		b.putString("ra", flg);
		b.putString("lat", lat);
		b.putString("lng", lng);
		
		i.putExtras(b);
		startActivity(i);
	}
	
	else if(v.equals(rail))
	{
		Bundle b=new Bundle();
		
		flg=e.getText().toString();
		
		Intent i=new Intent(GpsLocation.this,Index.class);
	
		b.putString("flag", "train_station");
		b.putString("ra", flg);
		b.putString("lat", lat);
		b.putString("lng", lng);
		i.putExtras(b);
		startActivity(i);
	}
	
	
	
}

}


