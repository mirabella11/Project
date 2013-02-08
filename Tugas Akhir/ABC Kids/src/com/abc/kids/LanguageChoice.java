package com.abc.kids;

 

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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

	 public boolean onKeyDown(int keyCode, KeyEvent event) 
	    {	  if(GlobalData.getInstance().lng==0){
	    	 if (keyCode == KeyEvent.KEYCODE_BACK)
	    	 {
	    		 new AlertDialog.Builder(this)
	       
	       
	        .setMessage("You are about to exit the Application.\n" + 
	                     "Do you really want to exit?")
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	             public void onClick(DialogInterface dialog, int which) {
	               
	            	 
	            	 Intent homeIntent= new Intent(Intent.ACTION_MAIN);
	            	 homeIntent.addCategory(Intent.CATEGORY_HOME);
	            	 homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            	 startActivity(homeIntent);
	                  
	            	  
	            	// moveTaskToBack(true);
	                 
	                }
	         })
	        .setNegativeButton("No", null)
	        .show();
		 	
	        return true;
	    }     else {
	    	
	        return super.onKeyDown(keyCode, event);
	    }
	 }else{
	    			if (keyCode == KeyEvent.KEYCODE_BACK)
	   	    	 {
	   	    		 new AlertDialog.Builder(this)
	     	       
	     	       
	    	        .setMessage("Anda Akan Keluar Dari Aplikasi ini.\n" + 
	    	                     "Apakah Anda Ingin Keluar?")
	    	        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
	    	             public void onClick(DialogInterface dialog, int which) {
	    	               
	    	            //	 moveTaskToBack(true);
	    	                  
	    	                 
	    	                }
	    	         })
	    	        .setNegativeButton("Tidak", null)
	    	        .show();
	    		 	
	    	        return true;
	    	    }     else {
	    	    	
	    	        return super.onKeyDown(keyCode, event);
	    	    }
	 	        }  
	    		    	    }
	 
	     
	    
	}

