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
	public UserDataSource datasource;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.language_choice);
	        
	    	english=  (Button) findViewById(R.id.eng);
	    	indo = (Button) findViewById(R.id.ind);
	    	
	    	  datasource = new UserDataSource(this);
		      datasource.open();
			english.setOnClickListener(new OnClickListener() {

				public void onClick(View first) {
					
					if(datasource.get()){
						
					Intent myIntent = new Intent(first.getContext(), ListUser.class);
	                startActivityForResult(myIntent, 0);
					 
						}else{
							
							Intent myIntent = new Intent(first.getContext(), InputData.class);
							startActivityForResult(myIntent, 0);
						}}
			});
			
			
			indo.setOnClickListener(new OnClickListener() {

				public void onClick(View second) {
					if(datasource.get()){
					
				Intent myIntent = new Intent(second.getContext(), ListUser.class);
                startActivityForResult(myIntent, 0);
				 
					}else{
						
						Intent myIntent = new Intent(second.getContext(), InputData.class);
		                startActivityForResult(myIntent, 0);
					}}
			});
		//	datasource.close();
	    }
	 
	     
	    
	}

