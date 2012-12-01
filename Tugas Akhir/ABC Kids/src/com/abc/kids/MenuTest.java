package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuTest extends Activity{
	
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_game);

	        Button guessvoice = (Button) findViewById(R.id.voice);
	        Button guessimage = (Button) findViewById(R.id.image);
	        Button arrange    = (Button) findViewById(R.id.word);
	        
	      guessvoice.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), VoiceTest.class);
	                startActivityForResult(myIntent, 0);
                }

	        });
	      guessimage.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View image1) {
	            	Intent myIntent = new Intent(image1.getContext(), ImageTest.class);
	                startActivityForResult(myIntent, 0);
              }

	        });
	      arrange.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View word1) {
	            	Intent myIntent = new Intent(word1.getContext(), ArrangeTest.class);
	                startActivityForResult(myIntent, 0);
              }

	        });
	      
	        
	        
}
}