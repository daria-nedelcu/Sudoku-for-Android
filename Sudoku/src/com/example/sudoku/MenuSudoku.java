package com.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MenuSudoku extends Activity {

	ImageView im1,im2,im3,im4;
	Intent intent1,intent2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_sudoku);
		
		im1 = (ImageView) findViewById(R.id.imageViewNewGame);
		im2 = (ImageView) findViewById(R.id.imageViewHowTo);
		im3 = (ImageView) findViewById(R.id.imageViewMoreApps);
		im4 = (ImageView) findViewById(R.id.imageViewQuit);
		
		im1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent1= new Intent(MenuSudoku.this, Difficulty.class);
		    	startActivity(intent1);
			}
		});
		
		im2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent2= new Intent(MenuSudoku.this, Howtoplay.class);
		    	startActivity(intent2);
			}
		});
		
		im3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri web = Uri.parse("http://www.android.com/apps/");
				startActivity(new Intent(Intent.ACTION_VIEW, web));
			}
		});
		
		im4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_sudoku, menu);
		return true;
	}

}
