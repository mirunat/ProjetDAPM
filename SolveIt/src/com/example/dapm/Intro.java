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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Intro extends Activity implements OnItemSelectedListener{

	Button start,exit;
	EditText nume;
	String player="";
	Spinner spinner;
	final Context context = this;
	int dif;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		start = (Button)findViewById(R.id.Start);
		exit = (Button)findViewById(R.id.Exit);
		nume= (EditText)findViewById(R.id.editName);
		String player=nume.getText().toString();
	
		spinner = (Spinner) findViewById(R.id.diff_spinner);
		spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.diff_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		//spinner.setPrompt("Difficulty");
		spinner.setAdapter(adapter);
		
		
		
		
		
	
	start.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			if(dif==0)Toast.makeText(getApplicationContext(), "You did not choose any difficulty",
					   Toast.LENGTH_LONG).show();
			else
			{
			String player=nume.getText().toString();
			Intent intent = new Intent(Intro.this,NewGame.class);
			intent.putExtra("nume_jucator", player);
			intent.putExtra("dificultate", dif);
			startActivity(intent);
			}
			
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
		getMenuInflater().inflate(R.menu.intro, menu);
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
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if(parent.getItemAtPosition(position).equals("Easy"))dif=15000;
		else if(parent.getItemAtPosition(position).equals("Medium"))dif=10000;
		else dif=5000;
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "You did not choose any difficulty",
				   Toast.LENGTH_LONG).show();
		dif=0;
	}
}
