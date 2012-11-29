package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LanguageChoice extends Activity {
	private Button english=null;
	private Button indo=null;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.language_choice);
	        
	    	english=  (Button) findViewById(R.id.eng);
	    	indo = (Button) findViewById(R.id.ind);
	    	
	    	
			english.setOnClickListener(new OnClickListener() {

				public void onClick(View first) {
					Intent myIntent = new Intent(first.getContext(), InputData.class);
	                startActivityForResult(myIntent, 0);
					 
						}
			});
			
			
			indo.setOnClickListener(new OnClickListener() {

				public void onClick(View second) {
					  
					Intent myIntent = new Intent(second.getContext(), InputData.class);
	                startActivityForResult(myIntent, 0);
	                
						}
			});

	    }
	 
	     
	    
	}

