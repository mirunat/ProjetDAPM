package com.example.dapm;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Joc extends Activity {
	
		ArrayList<Integer> imagini=new ArrayList<Integer>();
		ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
		ArrayList<Integer> test=new ArrayList<Integer>();
		Chronometer time;
		


	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_joc);
		
		time = (Chronometer)findViewById(R.id.chronometer1);
		time.setBase(SystemClock.elapsedRealtime());
		time.start();
		
		
		
		imagini.add(R.drawable.p1);
		imagini.add(R.drawable.p2);
		imagini.add(R.drawable.p3);
		imagini.add(R.drawable.p4);
		imagini.add(R.drawable.p5);
		imagini.add(R.drawable.p6);
		imagini.add(R.drawable.p7);
		imagini.add(R.drawable.p8);
		imagini.add(R.drawable.p9);
		imagini.add(R.drawable.p10);
		imagini.add(R.drawable.p11);
		imagini.add(R.drawable.p12);
		imagini.add(R.drawable.p13);
		imagini.add(R.drawable.p14);
		imagini.add(R.drawable.p15);
		imagini.add(R.drawable.p16);
		
		test.add(R.drawable.p1);
		test.add(R.drawable.p2);
		test.add(R.drawable.p3);
		test.add(R.drawable.p4);
		test.add(R.drawable.p5);
		test.add(R.drawable.p6);
		test.add(R.drawable.p7);
		test.add(R.drawable.p8);
		test.add(R.drawable.p9);
		test.add(R.drawable.p10);
		test.add(R.drawable.p11);
		test.add(R.drawable.p12);
		test.add(R.drawable.p13);
		test.add(R.drawable.p14);
		test.add(R.drawable.p15);
		test.add(R.drawable.p16);
		



		
		for(int i=0;i<=10;i++)
		{Random r=new Random();
	int r1=	Math.abs(r.nextInt())%16;
	int r2= Math.abs(r.nextInt())%16;
	int aux;
	if(r1!=r2) {
	if(r2 < r1) {aux = r2; r2 = r1; r1 = aux;}
	aux= imagini.get(r1);
	imagini.remove(r1); imagini.add(r1, imagini.get(r2-1));
	imagini.remove(r2); imagini.add(r2, aux);
	}
		}
		
		imageViews.add((ImageView)findViewById(R.id.p1));
		imageViews.add((ImageView)findViewById(R.id.p2));
		imageViews.add((ImageView)findViewById(R.id.p3));
		imageViews.add((ImageView)findViewById(R.id.p4));
		imageViews.add((ImageView)findViewById(R.id.p5));
		imageViews.add((ImageView)findViewById(R.id.p6));
		imageViews.add((ImageView)findViewById(R.id.p7));
		imageViews.add((ImageView)findViewById(R.id.p8));
		imageViews.add((ImageView)findViewById(R.id.p9));
		imageViews.add((ImageView)findViewById(R.id.p10));
		imageViews.add((ImageView)findViewById(R.id.p11));
		imageViews.add((ImageView)findViewById(R.id.p12));
		imageViews.add((ImageView)findViewById(R.id.p13));
		imageViews.add((ImageView)findViewById(R.id.p14));
		imageViews.add((ImageView)findViewById(R.id.p15));
		imageViews.add((ImageView)findViewById(R.id.p16));
		
	redrawAll();
		
	}
	
	int lastClicked = -1;
	
	public void Click(View v) {
		int clicked = Integer.parseInt(v.getTag().toString())-1;
		if (lastClicked == -1) {
		lastClicked = clicked;
		}
		else {
			int aux=imagini.get(lastClicked);
			
			imagini.remove(lastClicked);
			if(clicked>lastClicked)
			imagini.add(lastClicked, imagini.get(clicked-1));
			else
				imagini.add(lastClicked, imagini.get(clicked));
			imagini.remove(clicked); imagini.add(clicked, aux);
			lastClicked = -1;
			redrawAll();
			verify();
		}
	
	}
	
	public void redrawAll()
	{	for(int i=0;i<=15;i++)
	{imageViews.get(i).setImageResource(imagini.get(i));}}

	
	
	
	public void verify(){
		int ok=1;
		for(int k=0;k<16;k++)
			if(!imagini.get(k).equals(test.get(k))) ok=0;
		if(ok==1) {
			
			time.stop();
			long elapsedMillis = SystemClock.elapsedRealtime() - time.getBase();
			Intent i=new Intent(Joc.this,Winner.class);
			i.putExtra("time", elapsedMillis);
			startActivity(i);
		}
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
