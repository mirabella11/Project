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
	        
	    	english	=  (Button) findViewById(R.id.eng);
	    	indo    =  (Button) findViewById(R.id.ind);
	    	
	    	datasource = new UserDataSource(this);
		    datasource.open();
		      
			english.setOnClickListener(new OnClickListener() {

				public void onClick(View first) {
					
					GlobalData.getInstance().setLanguage(0);
					if(datasource.get()){
						if(GlobalData.getInstance().iduser!=0){
							Intent myIntent = new Intent(first.getContext(), FirstChoice.class);
			                startActivityForResult(myIntent, 0);
						} else {
					Intent myIntent = new Intent(first.getContext(), ListUser.class);
	                startActivityForResult(myIntent, 0);
						}
					}else{
					datasource.close();
					Intent myIntent = new Intent(first.getContext(), InputData.class);
					startActivityForResult(myIntent, 0);
						}}
			});
			
			
			indo.setOnClickListener(new OnClickListener() {
				

				public void onClick(View second) {
					GlobalData.getInstance().setLanguage(1);
				/*	Locale locale = new Locale("id");
			        Locale.setDefault(locale);
			        Configuration config = new Configuration();
			        config.locale = locale;
			        getBaseContext().getResources().updateConfiguration(config,  getBaseContext().getResources().getDisplayMetrics());
					*/
					if(datasource.get()){
						if(GlobalData.getInstance().iduser!=0){
							Intent myIntent = new Intent(second.getContext(),FirstChoice.class);
			                startActivityForResult(myIntent, 0);
						} else {
							
					Intent myIntent = new Intent(second.getContext(), ListUser.class);
	                startActivityForResult(myIntent, 0);
						}											 
					}else{
						datasource.close();
						Intent myIntent = new Intent(second.getContext(), InputData.class);
		                startActivityForResult(myIntent, 0);
					}}
			});
			
		 
	    }
	 
	     
	    
	}

