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

public class SudokuEasyGame extends Activity {

	private EditText medit[][]= new EditText[9][9];
	private int mint[][] = new int[9][9];
	private int mcompar[][] = new int[9][9];
	private ImageView check;
	private Chronometer chrono;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sudoku_easy_game);
		
		check = (ImageView) findViewById(R.id.imageViewCheckEasy);
		chrono = (Chronometer) findViewById(R.id.chronometerEasy);
		
		chrono.start();
		
		final int mcompar[][] = {{7,6,1,9,3,4,8,2,5},{3,5,4,6,2,8,1,9,7},{9,2,8,1,5,7,6,3,4},
							{2,1,9,5,4,6,3,7,8},{4,8,3,2,7,9,5,1,6},{5,7,6,3,8,1,9,4,2},
							{1,9,5,7,6,2,4,8,3},{8,3,2,4,9,5,7,6,1},{6,4,7,8,1,3,2,5,9}};
				
		int count = 1;
		for (int i = 0; i <=8; i++) 
		{
           for (int j = 0; j <=8; j++)
           { 
			 medit[i][j]= (EditText) findViewById(getResources().getIdentifier("editTextEasy"+count, "id", getPackageName()));
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
					    						Toast.makeText(SudokuEasyGame.this, "Only numbers between 1 and 9 allowed.", Toast.LENGTH_SHORT).show();
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
							    						Toast.makeText(SudokuEasyGame.this, "Nope,try again.", Toast.LENGTH_SHORT).show();
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
		getMenuInflater().inflate(R.menu.sudoku_easy_game, menu);
		return true;
	}
	
	public void initializare(EditText medit[][],int mint[][])
	{
		medit[0][1].setText("6");
		medit[0][1].setFocusable(false);
		mint[0][1]=6;
		
		medit[0][2].setText("1");
		medit[0][2].setFocusable(false);
		mint[0][2]=1;
		
		medit[0][4].setText("3");
		medit[0][4].setFocusable(false);
		mint[0][4]=3;
		
		medit[0][7].setText("2");
		medit[0][7].setFocusable(false);
		mint[0][7]=2;
		
		medit[1][1].setText("5");
		medit[1][1].setFocusable(false);
		mint[1][1]=5;
		
		medit[1][5].setText("8");
		medit[1][5].setFocusable(false);
		mint[1][5]=8;
		
		medit[1][6].setText("1");
		medit[1][6].setFocusable(false);
		mint[1][6]=1;
		
		medit[1][8].setText("7");
		medit[1][8].setFocusable(false);
		mint[1][8]=7;
		
		medit[2][5].setText("7");
		medit[2][5].setFocusable(false);
		mint[2][5]=7;
		
		medit[2][7].setText("3");
		medit[2][7].setFocusable(false);
		mint[2][7]=3;
		
		medit[2][8].setText("4");
		medit[2][8].setFocusable(false);
		mint[2][8]=4;
		
		medit[3][2].setText("9");
		medit[3][2].setFocusable(false);
		mint[3][2]=9;
		
		medit[3][5].setText("6");
		medit[3][5].setFocusable(false);
		mint[3][5]=6;
		
		medit[3][7].setText("7");
		medit[3][7].setFocusable(false);
		mint[3][7]=7;
		
		medit[3][8].setText("8");
		medit[3][8].setFocusable(false);
		mint[3][8]=8;
		
		medit[4][2].setText("3");
		medit[4][2].setFocusable(false);
		mint[4][2]=3;
		
		medit[4][3].setText("2");
		medit[4][3].setFocusable(false);
		mint[4][3]=2;
		
		medit[4][5].setText("9");
		medit[4][5].setFocusable(false);
		mint[4][5]=9;
		
		medit[4][6].setText("5");
		medit[4][6].setFocusable(false);
		mint[4][6]=5;
		
		medit[5][0].setText("5");
		medit[5][0].setFocusable(false);
		mint[5][0]=5;
		
		medit[5][1].setText("7");
		medit[5][1].setFocusable(false);
		mint[5][1]=7;
		
		medit[5][3].setText("3");
		medit[5][3].setFocusable(false);
		mint[5][3]=3;
		
		medit[5][6].setText("9");
		medit[5][6].setFocusable(false);
		mint[5][6]=9;
		
		medit[6][0].setText("1");
		medit[6][0].setFocusable(false);
		mint[6][0]=1;
		
		medit[6][1].setText("9");
		medit[6][1].setFocusable(false);
		mint[6][1]=9;
		
		medit[6][3].setText("7");
		medit[6][3].setFocusable(false);
		mint[6][3]=7;
		
		medit[7][0].setText("8");
		medit[7][0].setFocusable(false);
		mint[7][0]=8;
		
		medit[7][2].setText("2");
		medit[7][2].setFocusable(false);
		mint[7][2]=2;
		
		medit[7][3].setText("4");
		medit[7][3].setFocusable(false);
		mint[7][3]=4;
		
		medit[7][7].setText("6");
		medit[7][7].setFocusable(false);
		mint[7][7]=6;
		
		medit[8][1].setText("4");
		medit[8][1].setFocusable(false);
		mint[8][1]=4;
		
		medit[8][4].setText("1");
		medit[8][4].setFocusable(false);
		mint[8][4]=1;
		
		medit[8][6].setText("2");
		medit[8][6].setFocusable(false);
		mint[8][6]=2;
		
		medit[8][7].setText("5");
		medit[8][7].setFocusable(false);
		mint[8][7]=5;
		
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
			
			Intent intent= new Intent(SudokuEasyGame.this, Congrats.class);
			intent.putExtra("chrono", chrono.getText().toString());
			startActivity(intent);
		}
		else
		{
			Toast.makeText(SudokuEasyGame.this, "Not done yet.", Toast.LENGTH_SHORT).show();
		}
	}
}
