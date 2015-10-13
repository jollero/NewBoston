package com.anxa.fastmailings;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener{

	SoundPool sp;
	int explosion = 0;
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		View v = new View(this);
		v.setOnClickListener((OnClickListener) this);
		v.setOnLongClickListener(this);
		setContentView(v);
		
		
		AudioAttributes attributes = new AudioAttributes.Builder()
				.setUsage(AudioAttributes.USAGE_GAME)
				.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
				.build();
		sp = new SoundPool.Builder()
				.setAudioAttributes(attributes)
				.setMaxStreams(25)
				.build();
		
		explosion = sp.load(this, R.raw.bomb,1);
		mp = MediaPlayer.create(this, R.raw.splashsound);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (explosion != 0)	sp.play(explosion, 1, 1, 0, 0, 1);
			
		
		
		
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		mp.start();
		
		return false;
	}

	
	
	
}
