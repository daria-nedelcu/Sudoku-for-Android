package com.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SudokuEvilGame extends Activity {

	private EditText medit[][]= new EditText[9][9];
	private int mint[][] = new int[9][9];
	private int mcompar[][] = new int[9][9];
	private ImageView check;
	private Chronometer chrono;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sudoku_evil_game);
		
		check = (ImageView) findViewById(R.id.imageViewCheckEvil);
		chrono = (Chronometer) findViewById(R.id.chronometerEvil);
		
		chrono.start();
		
		final int mcompar[][] = {{8,6,7,9,4,2,1,5,3},{2,4,9,5,3,1,7,6,8},{1,3,5,7,6,8,9,4,2},
								{4,7,1,2,5,6,3,8,9},{5,8,6,1,9,3,2,7,4},{9,2,3,4,8,7,5,1,6},
								{7,9,8,6,2,5,4,3,1},{3,5,2,8,1,4,6,9,7},{6,1,4,3,7,9,8,2,5  }};
				
		int count = 1;
		for (int i = 0; i <=8; i++) 
		{
           for (int j = 0; j <=8; j++)
           { 
			 medit[i][j]= (EditText) findViewById(getResources().getIdentifier("editTextEvil"+count, "id", getPackageName()));
			 count++;
           }
		}
		
		initializare(medit,mint);
		
		for (int i = 0; i <=8; i++) 
			{
	           for (int j = 0; j <=8; j++)
	           { 
				 final EditText et=medit[i][j];
				 final int x=i;
				 final int y=j;			 
				 
				 et.setOnFocusChangeListener(new OnFocusChangeListener() {
	
			            @Override
			            public void onFocusChange(View v, boolean hasFocus) {
	
			                if(!hasFocus){
			                	if(et.getText().toString()!="")
			                		{   
				                		try
				                		{
				                			int number=Integer.parseInt(et.getText().toString());
	//			                			System.out.println("number "+number);
				                		
				                		if ((number<1) || (number>9))
					    					{
					    						//et.clearComposingText();
					                			et.setText("");
					    						Toast.makeText(SudokuEvilGame.this, "Only numbers between 1 and 9 allowed.", Toast.LENGTH_SHORT).show();
					    					}
				                		else
					                		{
				                				et.setTextColor(Color.BLACK);
				                				mint[x][y]=number;
				                				
//				                				for (int i = 0; i <=8; i++) 
//				                				{
//				                		           
//				                					for (int j = 0; j <=8; j++)
//				                		           { 
//				                		        	   System.out.println(" " + mint[i][j]);
//				                		           }
//				                				}
					                			
					                			if(mint[x][y]!= mcompar[x][y])
						                			{
						                				et.setTextColor(Color.RED);
							    						Toast.makeText(SudokuEvilGame.this, "Nope,try again.", Toast.LENGTH_SHORT).show();
						                			}
					                		}
				                		} 
				                		catch (Exception E)
				                		{
				                			//System.out.println(et.getText().toString());
				                		}
			                		}
			                }
			            }
			        });											
	            }
			}
			
		check.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				verificaretabelcomplet(mint,mcompar);
			}
		});
		
		
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sudoku_evil_game, menu);
		return true;
	}
	
	public void initializare(EditText medit[][],int mint[][])
	{
		medit[0][0].setText("8");
		medit[0][0].setFocusable(false);
		mint[0][0]=8;
		
		medit[0][4].setText("4");
		medit[0][4].setFocusable(false);
		mint[0][4]=4;
		
		medit[0][6].setText("1");
		medit[0][6].setFocusable(false);
		mint[0][6]=1;
		
		medit[0][8].setText("3");
		medit[0][8].setFocusable(false);
		mint[0][8]=3;
					
		medit[1][3].setText("5");
		medit[1][3].setFocusable(false);
		mint[1][3]=5;
		
		medit[1][6].setText("7");
		medit[1][6].setFocusable(false);
		mint[1][6]=7;
					
		medit[2][0].setText("1");
		medit[2][0].setFocusable(false);
		mint[2][0]=1;
		
		medit[2][1].setText("3");
		medit[2][1].setFocusable(false);
		mint[2][1]=3;
					
		medit[3][3].setText("2");
		medit[3][3].setFocusable(false);
		mint[3][3]=2;
		
		medit[3][5].setText("6");
		medit[3][5].setFocusable(false);
		mint[3][5]=6;
		
		medit[3][7].setText("8");
		medit[3][7].setFocusable(false);
		mint[3][7]=8;
		
		medit[4][0].setText("5");
		medit[4][0].setFocusable(false);
		mint[4][0]=5;
		
		medit[4][8].setText("4");
		medit[4][8].setFocusable(false);
		mint[4][8]=4;
					
		medit[5][1].setText("2");
		medit[5][1].setFocusable(false);
		mint[5][1]=2;
		
		medit[5][3].setText("4");
		medit[5][3].setFocusable(false);
		mint[5][3]=4;
		
		medit[5][5].setText("7");
		medit[5][5].setFocusable(false);
		mint[5][5]=7;
				
		medit[6][7].setText("3");
		medit[6][7].setFocusable(false);
		mint[6][7]=3;
		
		medit[6][8].setText("1");
		medit[6][8].setFocusable(false);
		mint[6][8]=1;
		
		medit[7][2].setText("2");
		medit[7][2].setFocusable(false);
		mint[7][2]=2;
		
		medit[7][5].setText("4");
		medit[7][5].setFocusable(false);
		mint[7][5]=4;
				
		medit[8][0].setText("6");
		medit[8][0].setFocusable(false);
		mint[8][0]=6;
						
		medit[8][2].setText("4");
		medit[8][2].setFocusable(false);
		mint[8][2]=4;
		
		medit[8][4].setText("7");
		medit[8][4].setFocusable(false);
		mint[8][4]=7;
		
		medit[8][8].setText("5");
		medit[8][8].setFocusable(false);
		mint[8][8]=5;
		
		
	}
	
	public void verificaretabelcomplet(int mint[][],int mcompar[][])
	{
		int ok=1;
		for (int i = 0; i <=8; i++) 
		{
           for (int j = 0; j <=8; j++)
           { 
        	   if (mint[i][j]!=mcompar[i][j])
        	   {
        		   ok=0;
        	   }
        	 
           }
		}
		if (ok==1)
		{
			chrono.stop();
			
			Intent intent= new Intent(SudokuEvilGame.this, Congrats.class);
			intent.putExtra("chrono", chrono.getText().toString());
			startActivity(intent);
		}
		else
		{
			Toast.makeText(SudokuEvilGame.this, "Not done yet.", Toast.LENGTH_SHORT).show();
		}
	}
}
