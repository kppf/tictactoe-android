package com.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LocalHome extends Activity {
	
	protected void onCreate(Bundle b) {
		System.out.println("In LocalHome class");
		super.onCreate(b);
		setContentView(R.layout.localhome);
		LocalHomeCanvas mycanvas = (LocalHomeCanvas)findViewById(R.id.localHomeCanvas);
		mycanvas.setOnClickListener(clickListener);
    }
    
    private OnClickListener clickListener = new OnClickListener() {
	//	private boolean isDrawn = false;
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	};
}