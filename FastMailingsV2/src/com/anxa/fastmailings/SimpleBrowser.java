package com.anxa.fastmailings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class SimpleBrowser extends Activity implements OnClickListener{
	

	WebView ourBrowser;
	EditText etBrowserURL;
	Button bGoBrowser;
	Button bGoBack;
	Button bGoForward;
	Button bGoRefresh;
	Button bClearHistory;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		
		ourBrowser = (WebView) findViewById(R.id.vwBrowser);
		etBrowserURL = (EditText) findViewById(R.id.etBrowserURL);
		bGoBrowser = (Button) findViewById(R.id.bGoBrowser);
		bGoBack = (Button) findViewById(R.id.bGoBackAPage);
		bGoForward = (Button) findViewById(R.id.bGoForward);
		bGoRefresh = (Button) findViewById(R.id.bRefreshPage);
		bClearHistory = (Button) findViewById(R.id.bClearHistory);
		
		bGoBrowser.setOnClickListener(this);
		bGoBack.setOnClickListener(this);
		bGoRefresh.setOnClickListener(this);
		bGoForward.setOnClickListener(this);
		bClearHistory.setOnClickListener(this);
		
		ourBrowser.setWebViewClient(new OurViewClient());
		ourBrowser.loadUrl("http://www.anxa.com");
		
		ourBrowser.getSettings().setJavaScriptEnabled(true);
		ourBrowser.getSettings().setLoadWithOverviewMode(true);
		ourBrowser.getSettings().setUseWideViewPort(true);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.bGoBrowser:
			String URL =etBrowserURL.getText().toString();
			
			if (!URL.contains("http://")) URL = "http://" + URL;
			
			ourBrowser.loadUrl(URL);
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etBrowserURL.getApplicationWindowToken(), 0);
			break;
		
		case R.id.bGoBackAPage:
			if (ourBrowser.canGoBack()) 			
				ourBrowser.goBack();
			break;
			
		case R.id.bRefreshPage:
			ourBrowser.reload();
			break;

		case R.id.bGoForward:
			if (ourBrowser.canGoForward()) 
			ourBrowser.reload();
			break;
			
		case R.id.bClearHistory:
			ourBrowser.clearHistory();
			break;
			
		}
	}
	
	
	private class OurViewClient extends WebViewClient {


		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			
			view.loadUrl(url);
			//return super.shouldOverrideUrlLoading(view, url);
			return true;
		}
		
	}

}


