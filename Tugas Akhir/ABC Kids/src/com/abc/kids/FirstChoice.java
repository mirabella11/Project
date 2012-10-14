package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
 



public class FirstChoice extends Activity {
	private ImageButton materi = null;
	private ImageButton test = null;
	private ImageButton laporan = null;
	private ImageButton akun = null;
	private ImageButton set = null;
	
 
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_choice_ind);
	        
	        materi = (ImageButton) findViewById(R.id.learn);
	        test = (ImageButton) findViewById(R.id.test);
	        laporan= (ImageButton) findViewById(R.id.report);
	        akun = (ImageButton) findViewById(R.id.change);
	        set = (ImageButton) findViewById(R.id.setting);
	       
	     
	        
	       
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
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	       akun.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	       set.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				}
			});
}
}


 
