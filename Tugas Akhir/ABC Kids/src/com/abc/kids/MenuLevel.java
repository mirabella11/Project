package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 


public class MenuLevel extends Activity {
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_level);
	        
	       Button easy 	 = (Button) findViewById(R.id.easy);
	       Button middle = (Button) findViewById(R.id.middle);
	       Button hard 	 = (Button) findViewById(R.id.hard);
	      
	      
	     easy.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), VoiceTest.class);
	            	myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            	myIntent.putExtra("EXIT", true);
	                startActivityForResult(myIntent, 0);
	           
	            }

	        });
	     middle.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), VoiceTest.class);
	            	myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            	myIntent.putExtra("EXIT", true);
	                startActivityForResult(myIntent, 0);
           }

	        });
	      
	    hard.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), VoiceTest.class);
	            	myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            	myIntent.putExtra("EXIT", true);
	                startActivityForResult(myIntent, 0);
           }

	        });
	      
	      
	      
}
}
