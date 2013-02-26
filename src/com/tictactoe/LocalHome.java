package com.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class LocalHome extends Activity {
	private LocalHomeCanvas mycanvas;
	private TextView label;
	private Button button;
	protected void onCreate(Bundle b) {
		System.out.println("In LocalHome class");
		super.onCreate(b);
		setContentView(R.layout.localhome);
		mycanvas = (LocalHomeCanvas)findViewById(R.id.localHomeCanvas);
		button = (Button) findViewById(R.id.the_button);
		label = (TextView) findViewById(R.id.the_label);
		mycanvas.setOnClickListener(clickListener);
		mycanvas.setOnTouchListener(touchListener);
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				mycanvas.restart();
				button.setText(mycanvas.restart);
				label.setText(mycanvas.playerR);
			}
			
		});
    }
    
	private void showWin() {
		label.setText(mycanvas.showWin());
		button.setText(mycanvas.playAgain);
	}
	
	private void showDraw() {
		label.setText(mycanvas.showDraw());
		button.setText(mycanvas.playAgain);
	}
	
    private OnClickListener clickListener = new OnClickListener() {
	//	private boolean isDrawn = false;
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private OnTouchListener touchListener = new OnTouchListener() {

		@Override
		public boolean onTouch(View arg0, MotionEvent event) {
			// TODO Auto-generated method stub
			int x = (int)event.getX();
		    int y = (int)event.getY();
		    boolean touch = false;
		    switch (event.getAction()) {
		        case MotionEvent.ACTION_DOWN:	touch=false; break;
		        case MotionEvent.ACTION_MOVE:	break;
		        case MotionEvent.ACTION_UP:		touch=true; break;
		    } 
		    System.out.println(x+" "+y);
		    if(touch==true) 
		    {
		    	System.out.println("Touch lifted.");
		    	if(mycanvas.play(x,y)==true) mycanvas.putImage(x,y);
				boolean win = mycanvas.checkWin();
				boolean draw = mycanvas.checkDraw();
				if(win==true) showWin();
				else if(draw==true) showDraw();
				else label.setText(mycanvas.currentPlayer());
		    	touch=false;
		    }
			return false;
		}
	};
}