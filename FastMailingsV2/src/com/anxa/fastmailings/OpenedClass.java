package com.anxa.fastmailings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{

	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread, setData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		Initialize();
		
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name","Joseph is ...");
		String values = getData.getString("list", "4");
		
		if (values.contentEquals("1")) {
			question.setText(et);
		}
		else {
			Intent i = getIntent();
			gotBread = i.getStringExtra("key");
			question.setText(gotBread);
			
			
		}
		
		
		
		
		
	}

	private void Initialize() {
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		returnData.setOnClickListener(this);
		selectionList.setOnCheckedChangeListener(this);
		
		test.setText("...");
	}

	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch (arg0.getId()) {
		
		case R.id.bReturn:
			Intent person = new Intent();
			Bundle backpack = new Bundle();
			
			backpack.putString("key", setData);
			person.putExtras(backpack);
			setResult(RESULT_OK,person);
			finish();
			
			break;
		
			
			
		}
		

		
	}

	
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		
		switch(arg1) {
		
		case R.id.rCrazy:
			setData = "Your probably right!";
			test.setText(setData);
			break;
			
		case R.id.rSexy:
			setData = "Thats is true!";
			test.setText(setData);
			break;
			
			
		case R.id.rBoth:
			setData = "Spot on!";
			test.setText(setData);
			break;
			
		}
		
		
		
		
	}

}
