package com.abc.kids;
 
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 

public class InputData  extends Activity {
	
	private EditText input_name;
	private Button Save;
	private UserDataSource adapter;
		 @Override
		 public void onCreate(Bundle bundle) {
		        super.onCreate(bundle);
		        setContentView(R.layout.menu_input_user);
		        
		        input_name = (EditText) findViewById(R.id.name);		        
		        Save = (Button) findViewById(R.id.save);
		       
		      
		        adapter= new UserDataSource(this);
		        adapter.open();
		 
		    
		        Save.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View third) {
		            	
		          	 String name = input_name.getText().toString();
		          	 User u = adapter.createUser(name);
		          	 
		          	 GlobalData.getInstance().setIduser(u.getId());
		           	 Intent myIntent = new Intent(third.getContext(),FirstChoice.class);
		           	 startActivityForResult(myIntent, 0);
		              
		            		}

		        });
		     		      	 
		    }
		 protected void onDestroy() {
				super.onDestroy();
				adapter.close();
		    	}
		  
		 	  	
		  	
		  }
		        
		




			 
				 


