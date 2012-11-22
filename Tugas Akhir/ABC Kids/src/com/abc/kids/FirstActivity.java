package com.abc.kids;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;

public class FirstActivity extends Activity {
	
	 private final int SPLASH_DISPLAY_LENGHT = 2000;

	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.first_activity);
	       
	        new Handler().postDelayed(new Runnable(){
	            public void run() {
	                /* Create an Intent that will start the Menu-Activity. */
	                Intent mainIntent = new Intent(FirstActivity.this, LanguageChoice.class);
	                startActivity(mainIntent);
	                //finish();
	              }
	        }, SPLASH_DISPLAY_LENGHT);
	        
	        
		 
	 }
}

