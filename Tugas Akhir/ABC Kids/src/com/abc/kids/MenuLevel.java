package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuLevel extends Activity {
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_level);
	        
	      ImageButton easy = (ImageButton) findViewById(R.id.easy);
	      ImageButton middle = (ImageButton) findViewById(R.id.middle);
	      ImageButton hard = (ImageButton) findViewById(R.id.hard);
	      
	      
	     easy.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), VoiceTest.class);
	                startActivityForResult(myIntent, 0);
              }

	        });
	     middle.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), VoiceTest.class);
	                startActivityForResult(myIntent, 0);
           }

	        });
	      
	    hard.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), VoiceTest.class);
	                startActivityForResult(myIntent, 0);
           }

	        });
	      
	      
	      
}
}
