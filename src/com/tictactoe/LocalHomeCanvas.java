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
import android.widget.Button;
import android.widget.TextView;

public class LocalHomeCanvas extends View {
	private Bitmap kBitmap = null, cross=null, round=null;
	private Paint kPaint = null;
	private int MAXX, MAXY, MBH=227, MBW=207, kx, ky, CW=50, CH=50, RH=50, RW=50, MARX, MARY;
	private int mat[][], CI=-1, RI=1, DI=0, player;
	private boolean isOver=false;
	protected String playerR = "Player 1", playerC="Player 2", drawString ="Game Drawn!", winString=" wins!";
	protected String playAgain="Play Again!", restart="Restart";
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
		kPaint.setColor(Color.RED);
		System.out.println(MAXX+" "+MAXY);
		canvas.drawBitmap(kBitmap, MARX, MARY, kPaint);
		System.out.println("Yo!");
		for(int i=0; i<3; i++) for(int j=0; j<3; j++) {
			if(mat[i][j]==CI) canvas.drawBitmap(cross,MARX+(2*i+1)*MBW/6-CW/2,MARY+(2*j+1)*MBH/6-CH/2,kPaint);
			else if(mat[i][j]==RI) canvas.drawBitmap(round,MARX+(2*i+1)*MBW/6-RW/2,MARY+(2*j+1)*MBH/6-RH/2,kPaint);
		}
		if(checkDraw()==true || checkWin()==true) isOver=true;
	}
	
	protected String currentPlayer() {
		if(player==RI) return playerR;
		else return playerC;
	}
	
	protected String showDraw() {
		return(drawString);
	}

	protected String showWin() {
		String winPlayer;
		if(player==CI) winPlayer=playerR;
		else winPlayer=playerC;
		return(winPlayer+winString);
	}

	protected boolean checkDraw() {
		for(int i=0; i<3; i++) for(int j=0; j<3; j++) if(mat[i][j]==DI) return false;
		return true;
	}
	
	protected boolean checkWin() {		//canvas may be passed as argument and line may be shown cutting the similar ones or just an image of line may be added
		// TODO Auto-generated method stub
		int checkPlayer;
		if(player==RI) checkPlayer=CI;
		else checkPlayer=RI;
		
		if((mat[0][0]==checkPlayer && mat[0][0]==mat[1][1] && mat[1][1]==mat[2][2])||(checkPlayer == mat[2][0] && mat[2][0]==mat[1][1] && mat[1][1]==mat[0][2])) {
            return true;
        }
        for(int i=0; i<3; i++)
            if((mat[i][0]==checkPlayer && mat[i][0]==mat[i][1] && mat[i][1]==mat[i][2])||(mat[0][i]==checkPlayer && mat[0][i]==mat[1][i] && mat[1][i]==mat[2][i])) {
                return true;
            }
		return false;
	}

	void putImage(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Why you no put image here :D");
		if(mat[kx/(MBW/3)][ky/(MBH/3)]==DI && isOver==false) {
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
	
	protected void restart() {
		for(int i=0; i<3; i++) for(int j=0; j<3; j++) mat[i][j]=DI;
		player=RI;
		isOver=false;
		invalidate();
	}
}
