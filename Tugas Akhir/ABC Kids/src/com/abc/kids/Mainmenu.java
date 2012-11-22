package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Mainmenu extends Activity {
	
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_item);
	        
	        ImageButton animal = (ImageButton) findViewById(R.id.hewan);
	        ImageButton flower = (ImageButton) findViewById(R.id.bunga);
	        ImageButton fruit = (ImageButton) findViewById(R.id.buah);
	        Button back = (Button) findViewById(R.id.kembali);
	        
	       animal.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View fourth) {
	            	Intent myIntent = new Intent(fourth.getContext(), MainLesson.class);
	                startActivityForResult(myIntent, 0);
                }

	        });
	       
	       flower.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View fourth1) {
	            	Intent myIntent = new Intent(fourth1.getContext(), MainLesson.class);
	                startActivityForResult(myIntent, 0);
               }

	        });
	       fruit.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View fourth2) {
	            	Intent myIntent = new Intent(fourth2.getContext(), MainLesson.class);
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
	        
	 }
}
