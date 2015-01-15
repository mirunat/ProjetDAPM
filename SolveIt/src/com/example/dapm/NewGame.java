package com.example.dapm;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class NewGame extends Activity {

	ImageView pozaPuzzle;
	Button exit;
    TextView countDown,welcome;
    int time;
    String player;
    int difficulty;
    final Context context = this;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);
		
		pozaPuzzle=(ImageView)findViewById(R.id.pozaPuzzle);
        countDown=(TextView)findViewById(R.id.countDown);
        welcome=(TextView)findViewById(R.id.welcome);
        player = getIntent().getStringExtra("nume_jucator");
        exit = (Button)findViewById(R.id.Exit);
        welcome.setText("Welcome," +player);
        
        difficulty=getIntent().getIntExtra("dificultate", 0);
        System.out.println(difficulty);
        
        
        
      
        new CountDownTimer(difficulty, 1000) {

            public void onTick(long millisUntilFinished) {
                countDown.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
            	Intent i = new Intent(NewGame.this, Joc.class);
            	startActivity(i);  
            }
         }.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.poza_puzzle, menu);
		return true;
	}



	@Override
	public void onBackPressed()
	{

	   // super.onBackPressed(); // Comment this super call to avoid calling finish()
	}
	
}

