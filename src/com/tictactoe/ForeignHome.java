package com.tictactoe;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ForeignHome extends Activity{
	
	private Button searchNew, pairedDevices, back;
	
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		setContentView(R.layout.foreignhome);
		searchNew = (Button) findViewById(R.id.searchNew);
		pairedDevices = (Button) findViewById(R.id.pairedDevices);
		back = (Button) findViewById(R.id.back);
		addIntents();
	}

	private void addIntents() {
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		searchNew.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
				if(mBluetoothAdapter==null) System.out.println("You need to buy a new mobile!");
				else System.out.println("You have enough toys to enjoy with!");
				
			}
		});
		
		pairedDevices.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Intent intent = new Intent("com.tictactoe.SPOTINGAPP");
				//startActivity(intent);
			}
		});
	}
}