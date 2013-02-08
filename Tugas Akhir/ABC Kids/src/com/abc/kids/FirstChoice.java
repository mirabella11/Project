package com.abc.kids;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;



public class FirstChoice extends Activity {
	private Button materi,test,laporan,akun,set,Yes,No,bahasa; 
  
	 
	
 
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_choice_ind);
	        
	        materi = (Button) findViewById(R.id.learn);
	        test   = (Button) findViewById(R.id.test);
	        laporan= (Button) findViewById(R.id.report);
	        akun   = (Button) findViewById(R.id.changeacc);
	        set    = (Button) findViewById(R.id.setting);
	        bahasa = (Button) findViewById(R.id.changelng);
	       
	       if(GlobalData.getInstance().lng==0){
	        	materi.setText("Learn");
	        	test.setText("Test");
	        	laporan.setText("Report");
	        	
	        }else{
	        	materi.setText("Pembelajaran");
	        	test.setText("Ujian");
	        	laporan.setText("Laporan");
	        }  
	        
	        materi.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View second) {
	            	
	            	
	            	Intent myIntent = new Intent(second.getContext(), Mainmenu.class);
	            	startActivityForResult(myIntent, 0);
	                
	        }
	        });
	        test.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View second1) {
					
					Intent myIntent = new Intent(second1.getContext(), MenuTest.class);
	                startActivityForResult(myIntent, 0);
					
				}
			});
	        
	       laporan.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View second2) {
					Intent myIntent = new Intent(second2.getContext(), ScoreTab.class);
					startActivityForResult(myIntent, 0);
					
					
				}
			});
	       akun.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View three) {
					Intent myIntent = new Intent(three.getContext(), ListUser.class);
	                startActivityForResult(myIntent, 0);
					
				}
			});
	       bahasa.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View four) {
					Intent myIntent = new Intent(four.getContext(), LanguageChoice.class);
	                startActivityForResult(myIntent, 0);
					
				}
			});
	       set.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View five) {
					Intent myIntent = new Intent(five.getContext(), Settings.class);
	                startActivityForResult(myIntent, 0);
					
				}
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
	            	 homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	            	 startActivity(homeIntent);
 	               
 	            	moveTaskToBack(true);
 	                }
 	         })
 	        .setNegativeButton("No", null)
 	        .show();
 		 	
 	        return true;
 	    }     else {
 	    	
 	        return super.onKeyDown(keyCode, event);
 	    }
 	 }
        
	    	
	    	 
	    		else{
	    			if (keyCode == KeyEvent.KEYCODE_BACK)
	   	    	 {
	   	    		 new AlertDialog.Builder(this)
	     	       
	     	       
	    	        .setMessage("Anda Akan Keluar Dari Aplikasi ini.\n" + 
	    	                     "Apakah Anda Ingin Keluar?")
	    	        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
	    	             public void onClick(DialogInterface dialog, int which) {
	    	               
	    	            	 Intent homeIntent= new Intent(Intent.ACTION_MAIN);
	    	            	 homeIntent.addCategory(Intent.CATEGORY_HOME);
	    	            	 homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    	            	 startActivity(homeIntent); 
	    	            	 
	    	                 
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


 
