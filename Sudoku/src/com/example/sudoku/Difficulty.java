package com.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Difficulty extends Activity {

	ImageView im1,im2,im3,im4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_difficulty);
		
		im1 = (ImageView) findViewById(R.id.imageViewEasy);
		im2 = (ImageView) findViewById(R.id.imageViewMedium);
		im3 = (ImageView) findViewById(R.id.imageViewEvil);
		im4 = (ImageView) findViewById(R.id.imageViewMain);
		
		im4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent i4= new Intent(Difficulty.this, MenuSudoku.class);
//		    	startActivity(i4);
				android.os.Process.killProcess(android.os.Process.myPid());
		    	
			}
		});
		
		im1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1= new Intent(Difficulty.this, SudokuEasyGame.class);
		    	startActivity(i1);
			}
		});
		
		im2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2= new Intent(Difficulty.this, SudokuMediumGame.class);
		    	startActivity(i2);
			}
		});

		im3.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i3= new Intent(Difficulty.this, SudokuEvilGame.class);
		    	startActivity(i3);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.difficulty, menu);
		return true;
	}

}
