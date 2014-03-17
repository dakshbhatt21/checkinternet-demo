package com.dakshbhatt21.checkinternet;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isNetworkAvailable())	{
					Toast.makeText(MainActivity.this, "Internet is available.", Toast.LENGTH_LONG).show();
				}
				else	{
					Toast.makeText(MainActivity.this, "Internet is not available.", Toast.LENGTH_LONG).show();
				}
			}
		});
		
	}

	public boolean isNetworkAvailable() {
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		return ni != null && ni.getState() == NetworkInfo.State.CONNECTED;
	}

}
