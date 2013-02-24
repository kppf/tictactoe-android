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
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LocalHomeCanvas extends View {

	private Paint kPaint = null;
	private int MAXX, MAXY;
	public LocalHomeCanvas(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		kPaint = new Paint();
		kPaint.setColor(Color.BLUE);
	}
	
	public void onDraw(Canvas canvas) {
		MAXY = getHeight();
		MAXX = getWidth();
		canvas.drawRGB(0, 0, 255);
	//	canvas.drawRect(0, 0, MAXX/2, MAXY/2, kPaint);
		kPaint.setColor(Color.RED);
		canvas.drawLine(MAXX/3, MAXY/12, MAXX/3, MAXY/12+MAXX, kPaint);
		System.out.println(MAXX+" "+MAXY);
	}
}
