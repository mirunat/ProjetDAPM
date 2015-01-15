package com.example.dapm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;

public class Logo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logo);
		
		new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
               
            }

            public void onFinish() {
            	Intent i = new Intent(Logo.this, MainActivity.class);
            	startActivity(i);  
            }
         }.start();
	}
		
		
	}

