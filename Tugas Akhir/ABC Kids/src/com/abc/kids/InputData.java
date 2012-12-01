package com.abc.kids;
 
import java.util.List;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 

public class InputData  extends Activity {
	
	private EditText input_name;
	private User id;
	private Button Save;
	private UserDataSource adapter;
		 @Override
		 public void onCreate(Bundle bundle) {
		        super.onCreate(bundle);
		        setContentView(R.layout.menu_data_eng);
		        
		        input_name = (EditText) findViewById(R.id.name);		        
		        Save = (Button) findViewById(R.id.save);
		       
		      
		        adapter= new UserDataSource(this);
		        adapter.open();
		 
		    
		        Save.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View third) {
		            	
		          	 String name = input_name.getText().toString();
		          	 adapter.createUser(name);
		          	 
		     	
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
		        
		




			 
				 


