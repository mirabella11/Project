package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLesson extends Activity {
	private Button home = null;
	private Button back = null;
	private Button prev = null;
	private Button voice = null; 
	private Button spell = null;
	private Button list = null;	 private Button next = null;
	
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_lesson);
	        
	        home = (Button) findViewById(R.id.home);
	        back = (Button) findViewById(R.id.back);
	        prev = (Button) findViewById(R.id.prev);
	        voice= (Button) findViewById(R.id.voice);
	        spell = (Button) findViewById(R.id.spell);
	        list = (Button) findViewById(R.id.list);
	        next= (Button) findViewById(R.id.next);
	        
	      home.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View five) {
	            	Intent myIntent = new Intent(five.getContext(), FirstChoice.class);
	                startActivityForResult(myIntent, 0);
                }

	        });
	      
	     back.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View six) {
	            	Intent myIntent = new Intent(six.getContext(), Mainmenu.class);
	                startActivityForResult(myIntent, 0);
              }

	        });
	        
	     prev.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	            	 
             }

	        });
	        
	     voice.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view1) {
	            	 
             }

	        });
	        
	     spell.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view1) {
	            	 
          }

	        });
	    list.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view1) {
	            	 
          }

	        });
	    next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
            	 
         }

        });
	 }
}
