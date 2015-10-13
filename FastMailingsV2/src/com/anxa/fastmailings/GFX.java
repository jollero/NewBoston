package com.anxa.fastmailings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.WindowManager;

public class GFX extends Activity{

	MyBringBack ourView;
	WakeLock wL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		PowerManager pM = (PowerManager)getSystemService(Context.POWER_SERVICE);
		wL = pM.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"whatever");
		
		
		super.onCreate(savedInstanceState);
		wL.acquire();
		
		ourView = new MyBringBack(this);
		setContentView(ourView);
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wL.release();
	}



}
