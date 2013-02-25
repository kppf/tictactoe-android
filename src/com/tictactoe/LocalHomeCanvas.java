package com.tictactoe;

/*import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable.Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class LocalHomeCanvas extends SurfaceView implements Callback {
//	private CanvasThread canvasThread;
	Paint paint = new Paint();
	
	public LocalHomeCanvas(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	private class CanvasThread extends Thread {
		private SurfaceHolder surfaceHolder;
		private boolean isRun = false;

		public CanvasThread(SurfaceHolder holder) {
		this.surfaceHolder = holder;
		}
	}

	protected void onDraw(Canvas canvas) {
		System.out.println("I'm here in onDraw class");
		canvas.drawColor(Color.BLUE);
		canvas.drawRect(100, 100, 100, 100, paint);
	}
}
*/

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LocalHomeCanvas extends View {
	private Bitmap kBitmap = null, cross=null, round=null;
	private Paint kPaint = null;
	private int MAXX, MAXY, MBH=227, MBW=207, kx, ky, CW=50, CH=50, RH=50, RW=50, MARX, MARY;
	private int mat[][], CI=-1, RI=1, DI=0, player;
/*
 * CI->Cross index, RI-> Round Index, DI->Default index, player->current player
 * MBH-> main board height, MBW->width, CW,Ch->Cross, RH, RW->round
 */
	public LocalHomeCanvas(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		kPaint = new Paint();
		kPaint.setColor(Color.BLUE);
		kBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mainboard);
		cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
		round = BitmapFactory.decodeResource(getResources(), R.drawable.round);
		mat = new int[3][3];
		for(int i=0; i<3; i++) for(int j=0; j<3; j++) mat[i][j]=0;
		player=RI;
	}
	
	public void onDraw(Canvas canvas) {
		MAXY = getHeight();
		MAXX = getWidth();
		MARX = MAXX/2-MBW/2;
		MARY = MAXY/2-MBH/2;
	//	canvas.drawRGB(0, 0, 255);
	//	canvas.drawRect(0, 0, MAXX/2, MAXY/2, kPaint);
		kPaint.setColor(Color.RED);
	//	canvas.drawLine(MAXX/3, MAXY/12, MAXX/3, MAXY/12+MAXX, kPaint);
		System.out.println(MAXX+" "+MAXY);
	//	canvas.setBitmap(kBitmap);
		canvas.drawBitmap(kBitmap, MARX, MARY, kPaint);
		System.out.println("Yo!");
		int win = checkWin();
		for(int i=0; i<3; i++) for(int j=0; j<3; j++) {
			if(mat[i][j]==CI) canvas.drawBitmap(cross,MARX+(2*i+1)*MBW/6-CW/2,MARY+(2*j+1)*MBH/6-CH/2,kPaint);
			else if(mat[i][j]==RI) canvas.drawBitmap(round,MARX+(2*i+1)*MBW/6-RW/2,MARY+(2*j+1)*MBH/6-RH/2,kPaint);
		}
	}
	
	private int checkWin() {
		// TODO Auto-generated method stub
		
	}

	void putImage(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Why you no put image here :D");
		if(mat[kx/(MBW/3)][ ky/(MBH/3)]==DI) {
		if(player==RI)
		{
			mat[kx/(MBW/3)][ ky/(MBH/3)]=RI;
			player=CI;
		}
		else {
			mat[kx/(MBW/3)][ ky/(MBH/3)]=CI;
			player=RI;
		} }
		System.out.println(kx+"Yeah! "+ky);
		invalidate();			//Redraw
	}

	//We can implement something like getRelativeX getRelativeY to direct get the matrix position of the touch
	
	boolean play(int x, int y) {
		// TODO Auto-generated method stub
		kx = x - (MAXX/2-MBW/2);
		ky = y - (MAXY/2-MBH/2);
		System.out.println(kx+" KKK "+ky);
		if(kx>0 && ky>0 && kx<MBW && ky<MBH) return true;
		return false;
	}
}
