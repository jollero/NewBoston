package com.anxa.fastmailings;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener{
	
	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	int cameraResults;
	final static int cameraData=0;
	Bitmap bmp;

	
	@Override
	protected void onCreate(Bundle SavedInstanceState){
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.photo);
		Initialize();
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
	}


	private void Initialize() {
		// TODO Auto-generated method stub
		ib = (ImageButton) findViewById (R.id.ibTakepic);
		iv = (ImageView) findViewById(R.id.ivReturnedPic);
		b = (Button) findViewById (R.id.bSetwall);
		
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		WallpaperManager wallpaperManager;
		
		switch (v.getId()){
		
		case R.id.bSetwall:
			wallpaperManager = WallpaperManager.getInstance(this);
		    try {
				wallpaperManager.setBitmap(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case R.id.ibTakepic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			
			startActivityForResult(i,cameraData);
			break;
		
		}
		
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			
			iv.setImageBitmap(bmp);
		}
		
	}
	
	
	
}
