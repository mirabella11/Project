package com.abc.kids;


import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;

public class FirstActivity extends Activity {
	
	 private final int SPLASH_DISPLAY_LENGHT = 5000;

	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.first_activity);
	       
	        new Handler().postDelayed(new Runnable(){
	            public void run() {
	            	
	                
	                Intent mainIntent = new Intent(FirstActivity.this, LanguageChoice.class);
	                startActivity(mainIntent);
	           	            		}
	        		}, SPLASH_DISPLAY_LENGHT);	
	       
	       		}
	 
}

