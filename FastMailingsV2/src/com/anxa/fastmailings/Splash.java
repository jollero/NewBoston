package com.anxa.fastmailings;

import com.anxa.fastmailings.Splash;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
//import com.crashlytics.android.Crashlytics;
//import io.fabric.sdk.android.Fabric;


public class Splash extends Activity{


	MediaPlayer ourSong;
	boolean music;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//Fabric.with(this, new Crashlytics());

		setContentView(R.layout.splash);
	
		SharedPreferences getPrefs =  PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		music = getPrefs.getBoolean("checkbox", true);
		
		if (music == true) {
			ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound);
			ourSong.start();
		}
		
		Thread timer = new Thread(){
			public void run(){
				try{
					if (music==true) {sleep(5000);}
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent(Splash.this,Menu.class);
					startActivity(openStartingPoint);
				}
				
			}
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (music==true) {ourSong.release();}

		finish();
	}
	
	
	

}
