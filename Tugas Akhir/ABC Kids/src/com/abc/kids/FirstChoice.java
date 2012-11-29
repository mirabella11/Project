package com.abc.kids;




import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.abc.kids.LanguageChoice;



public class FirstChoice extends Activity {
	private ImageButton materi = null;
	private ImageButton test = null;
	private ImageButton laporan = null;
	private ImageButton akun = null;
	private ImageButton set = null;
	private Button Yes = null;
	private Button No = null;
	private Dialog choiceDialog = null;
	 
	 
	
 
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
				
				public void onClick(View second2) {
					Intent myIntent = new Intent(second2.getContext(), ScoreTest.class);
	                startActivityForResult(myIntent, 0);
					
					
				}
			});
	       akun.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					
					
				}
			});
	       set.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	        }
	       
	       

	    public boolean onKeyDown(int keyCode, KeyEvent event) 
	    {
	    	 if (keyCode == KeyEvent.KEYCODE_BACK)
	    	 {
	    		 new AlertDialog.Builder(this)
	    	       
	    	        .setTitle("Exit?")
	    	        .setMessage("You are about to exit the Application. " + 
	    	                     "Do you really want to exit?")
	    	        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	             public void onClick(DialogInterface dialog, int which) {
	    	                //Stop the activity
	    	                 //maintenancetabs.this.finish();
	    	               int pid = android.os.Process.myPid();
	    	                 android.os.Process.killProcess(pid);
	    	                 finish();
	    	                }
	    	         })
	    	        .setNegativeButton("No", null)
	    	        .show();
	    	         return true;
	    	    }     else {
	    	        return super.onKeyDown(keyCode, event);
	    	    }
	    	 }
	    
	    
	    
	    
	       
	   
}


 
