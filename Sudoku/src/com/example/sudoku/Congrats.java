package com.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Congrats extends Activity {
	
	ImageView im;
	TextView t;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_congrats);
		
		t = (TextView) findViewById(R.id.textViewTime);
		
		Bundle b = new Bundle();
		b = getIntent().getExtras();
		String chrono = b.getString("chrono");
		t.setText(chrono);
					 
		im = (ImageView) findViewById(R.id.imageViewNewPuzzle);
		
		im.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1= new Intent(Congrats.this, Difficulty.class);
		    	startActivity(i1);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.congrats, menu);
		return true;
	}

}
