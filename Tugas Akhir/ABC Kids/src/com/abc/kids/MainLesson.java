package com.abc.kids;

import org.apache.http.conn.routing.RouteInfo.LayerType;

import com.abc.kids.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainLesson extends Activity {
	private Button home = null;
	private Button back = null;
	private Button prev = null;
	private Button voice = null; 
	private Button spell = null;
	private Button list = null;	 private Button next = null;
	private ImageView image= null;
	
	
	
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
	         image = (ImageView) findViewById(R.id.imageView1);
	        
	        showimage();
	      home.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View five) {
	            	Intent myIntent = new Intent(five.getContext(), FirstChoice.class);
	                startActivityForResult(myIntent, 0);
                }

	        });
	      
	     back.setOnClickListener(new View.OnClickListener() {
	    	 public void onClick(View arg0) {
					Intent intent = new Intent();
	            	setResult(RESULT_OK, intent);
	            	finish();
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
	 
	 public void showimage(){
		 int[] img = new int [] { R.drawable.splash, R.drawable.arale1};
		 
		 for ( int i = 0; i < img.length; i++ )
         { 
			 image.setImageResource(img[i]);

         }
		 
		 
		// Drawable drawable=this.getResources().getDrawable(img[i]);
	      //  image.setBackgroundDrawable(drawable);
		 }
		 
	 }

