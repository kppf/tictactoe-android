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
	private int MAXX, MAXY, MBH=250, MBW=250;
	public LocalHomeCanvas(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		kPaint = new Paint();
		kPaint.setColor(Color.BLUE);
		kBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mainboard);
		cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
		round = BitmapFactory.decodeResource(getResources(), R.drawable.round);
		}
	
	public void onDraw(Canvas canvas) {
		MAXY = getHeight();
		MAXX = getWidth();
	//	canvas.drawRGB(0, 0, 255);
	//	canvas.drawRect(0, 0, MAXX/2, MAXY/2, kPaint);
		kPaint.setColor(Color.RED);
	//	canvas.drawLine(MAXX/3, MAXY/12, MAXX/3, MAXY/12+MAXX, kPaint);
		System.out.println(MAXX+" "+MAXY);
	//	canvas.setBitmap(kBitmap);
		canvas.drawBitmap(kBitmap, MAXX/2-MBW/2, MAXY/2-MBH/2, kPaint);
		System.out.println("Yo!");
	}
	void putImage(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Why you no put image here :D");
	}

	//We can implement something like getRelativeX getRelativeY to direct get the matrix position of the touch
	
	boolean play(int x, int y) {
		// TODO Auto-generated method stub
		int kx = x - (MAXX/2-MBW/2);
		int ky = y - (MAXY/2-MBH/2);
		System.out.println(kx+" KKK "+ky);
		if(kx>0 && ky>0 && kx<MBW && ky<MBH) return true;
		return false;
	}
}
