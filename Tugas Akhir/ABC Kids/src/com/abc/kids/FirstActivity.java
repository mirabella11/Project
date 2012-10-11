package com.abc.kids;



 

import org.apache.http.util.LangUtils;

 

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v4.app.NavUtils;
import android.widget.Button;

public class FirstActivity extends Activity {
	private Button english=null;
	private Button indo=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_choice);
        
    	english=  (Button) findViewById(R.id.eng);
		english.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				 
			}
		});
		
		indo = (Button) findViewById(R.id.ind);
		indo.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				  
				 
			}
		});

    }
 
     
    
}
