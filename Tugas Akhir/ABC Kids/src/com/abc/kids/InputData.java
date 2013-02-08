package com.abc.kids;
 
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 

public class InputData  extends Activity {
	
	private EditText input_name;
	private Button Save;
	private TextView text_name,Attention;
	private UserDataSource adapter;
		 @Override
		 public void onCreate(Bundle bundle) {
		        super.onCreate(bundle);
		        setContentView(R.layout.menu_input_user);
		        Attention = (TextView)findViewById(R.id.alert);
		        text_name = (TextView) findViewById(R.id.text);
		        input_name = (EditText) findViewById(R.id.name);		        
		        Save = (Button) findViewById(R.id.save);
		       
		      
		        adapter= new UserDataSource(this);
		        adapter.open();
		 
		        if(GlobalData.getInstance().lng==0){
		        	text_name.setText("Name");
		        	Save.setText("Save");
		        	
		        }else{
		        	text_name.setText("Nama");
		        	Save.setText("Simpan");
		        }  
		        
		        Save.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View third) {
		            	
		          	 String name = input_name.getText().toString();
		          	if (name.matches("")){
			 			Attention.setText("Please Fill The Username");
			 			if(GlobalData.getInstance().lng==1){
			 				Attention.setText("Masukkan Nama User Terlebih Dahulu");
						}
			 		return;
			 		} else {
		          	 User u = adapter.createUser(name);
		          	 
		          	 GlobalData.getInstance().setIduser(u.getId());
		           	 Intent myIntent = new Intent(third.getContext(),FirstChoice.class);
		           	 startActivityForResult(myIntent, 0);
			 		}
					}
			});
		 }
		     		      	 
		   
		 protected void onDestroy() {
				super.onDestroy();
				adapter.close();
		    	}
		  
		 	  	
		  	
		  }
		        
		




			 
				 


