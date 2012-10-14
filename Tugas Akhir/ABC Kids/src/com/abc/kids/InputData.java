package com.abc.kids;
 
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 
 
public class InputData  extends Activity {
	private EditText name =null;
	private EditText age= null;
	
	 
		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.menu_data_ind);
		        
		       name = (EditText) findViewById(R.id.name);
		       age = (EditText) findViewById(R.id.age);
		        
		        Button submit = (Button) findViewById(R.id.save);
		        submit.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View third) {
		            	Intent myIntent = new Intent(third.getContext(),FirstChoice.class);
		                startActivityForResult(myIntent, 0);
	                }

		        });
		        
	 
		    }
		}





