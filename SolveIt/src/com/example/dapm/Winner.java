package com.example.dapm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Winner extends Activity {

	Button menu,exit;
	TextView test ;
	final Context context = this;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winner);
		menu=(Button)findViewById(R.id.menu);
		exit=(Button)findViewById(R.id.exit);
		test=(TextView)findViewById(R.id.cong);
		
		long ms=(getIntent().getLongExtra("time", 0))/1000;
		String s = String.valueOf(ms);
		test.setText("Congratulations! Your time: "+s+"s");
		
		menu.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Winner.this,MainActivity.class);
				startActivity(i);
			}
		});
		
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		        alertDialogBuilder.setTitle("Exit Application?");
		        alertDialogBuilder
		                .setMessage("Click yes to exit!")
		                .setCancelable(false)
		                .setPositiveButton("Yes",
		                        new DialogInterface.OnClickListener() {
		                            public void onClick(DialogInterface dialog, int id) {
		                                moveTaskToBack(true);
		                                android.os.Process.killProcess(android.os.Process.myPid());
		                                System.exit(1);
		                            }
		                        })

		                .setNegativeButton("No", new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog, int id) {

		                        dialog.cancel();
		                    }
		                });

		        AlertDialog alertDialog = alertDialogBuilder.create();
		        alertDialog.show();
	            
			}
		});
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.winner, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	

	@Override
	public void onBackPressed()
	{

	   // super.onBackPressed(); // Comment this super call to avoid calling finish()
	}
	
	
}
