package com.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class GameIndex extends Activity {

	private Button newGame, exit, credits;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_index);
		
		newGame = (Button) findViewById(R.id.newGame);
		exit = (Button) findViewById(R.id.exit);
		credits = (Button) findViewById(R.id.credits);
		
		newGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View vNewGame) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.tictactoe.NEWGAME");
				startActivity(i);
			}
		});
		
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View vExit) {
				// TODO Auto-generated method stub

			}
		});

		credits.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View vCredits) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.tictactoe.CREDITS");
				startActivity(i);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game_index, menu);
		return true;
	}

}
