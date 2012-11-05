package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class VoiceTest extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_voice);
        
        ImageButton first = (ImageButton) findViewById(R.id.animal1);
        ImageButton second = (ImageButton) findViewById(R.id.animal2);
        
        first.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
            	Intent myIntent = new Intent(voice1.getContext(), ImageTest.class);
                startActivityForResult(myIntent, 0);
          }

        });
      
        

}
}
