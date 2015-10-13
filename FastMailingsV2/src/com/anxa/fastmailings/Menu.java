package com.anxa.fastmailings;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {




	String classes[] = {"MainActivity","Text","Email","Camera","Data","imagebuttons","GFX","GFXSurface","SoundStuff","Slider","Tabs","SimpleBrowser","example1"};
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setListAdapter(new ArrayAdapter<string>(Menu.this, android.R.layout.simple_list_item_1, classes);
		
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes);
		setListAdapter(adapter);
	}
	

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
		
		String cheese = classes[position];
		
		try {
			Class<?> ourClass = Class.forName("com.anxa.fastmailings." + cheese.toString());
			Intent ourIntent = new Intent(Menu.this, ourClass);
			
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		
		
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu,menu);
		
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch (item.getItemId()) {
			
		case R.id.aboutUs:
			Intent i = new Intent("com.anxa.fastmailings.ABOUT");
			startActivity(i);
			break;
			
		case R.id.preferences:
			Intent a = new Intent("com.anxa.fastmailings.PREFS");
			startActivity(a);
			break;
			
		}
		
		
		return super.onOptionsItemSelected(item);
		
	}
	

	

	
	
}
