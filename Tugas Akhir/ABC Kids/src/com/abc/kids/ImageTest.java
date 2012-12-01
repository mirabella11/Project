package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageTest extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_image);

        ImageView image = (ImageView) findViewById(R.id.image1);
        Button first = (Button) findViewById(R.id.button1);
        Button second = (Button) findViewById(R.id.button2);
        
        first.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
            	 
          }

        });
        
        
}
}