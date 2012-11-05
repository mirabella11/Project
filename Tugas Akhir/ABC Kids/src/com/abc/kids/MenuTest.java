package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuTest extends Activity{
	
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_game);

	        ImageButton guessvoice = (ImageButton) findViewById(R.id.voice);
	        ImageButton guessimage = (ImageButton) findViewById(R.id.image);
	        ImageButton arrange = (ImageButton) findViewById(R.id.word);
	        
	      guessvoice.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View voice1) {
	            	Intent myIntent = new Intent(voice1.getContext(), MenuLevel.class);
	                startActivityForResult(myIntent, 0);
                }

	        });
	      guessimage.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View image1) {
	            	Intent myIntent = new Intent(image1.getContext(), MenuLevel.class);
	                startActivityForResult(myIntent, 0);
              }

	        });
	      arrange.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View word1) {
	            	Intent myIntent = new Intent(word1.getContext(), MenuLevel.class);
	                startActivityForResult(myIntent, 0);
              }

	        });
	      
	        
	        
}
}