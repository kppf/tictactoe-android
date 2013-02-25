package com.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class LocalHome extends Activity {
	private LocalHomeCanvas mycanvas;
	protected void onCreate(Bundle b) {
		System.out.println("In LocalHome class");
		super.onCreate(b);
		setContentView(R.layout.localhome);
		mycanvas = (LocalHomeCanvas)findViewById(R.id.localHomeCanvas);
		mycanvas.setOnClickListener(clickListener);
		mycanvas.setOnTouchListener(touchListener);
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
		    	touch=false;
		    }
			return false;
		}
	};
}