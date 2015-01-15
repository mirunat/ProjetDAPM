package com.example.dapm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button newGame,howToPlay,showRecords,about;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		newGame = (Button)findViewById(R.id.newGame);
		howToPlay = (Button)findViewById(R.id.howToPlay);
		about = (Button)findViewById(R.id.about);
		
		newGame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(MainActivity.this,Intro.class);
				startActivity(intent);
				
			}
		});
		
		howToPlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(MainActivity.this,HowToPlay.class);
				startActivity(intent);
				
			}
		});
		
		
		
		
		about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(MainActivity.this,About.class);
				startActivity(intent);
				
			}
		});
		
		
	}
}
