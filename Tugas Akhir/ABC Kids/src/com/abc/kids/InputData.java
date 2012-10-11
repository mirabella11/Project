package com.abc.kids;
 
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 
 
public class InputData  extends Activity {
	private EditText name =null;
	
	 
		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.menu_data_ind);
		        
		       name = (EditText) findViewById(R.id.name);
		     
		        
		        Button submit = (Button) findViewById(R.id.save);
		        submit.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View view) {
		             //   Intent  Intent1 = new Intent(view.getContext(), Union3.class);
		               // startActivityForResult( Intent1, 0);
		            }

		        });
		        
	 
		    }
		}





