package com.abc.kids;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class ArrangeTest extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_arrange);
        
        ImageView image= (ImageView) findViewById (R.id.image1);
        Button first = (Button) findViewById(R.id.button1);
        Button second = (Button) findViewById(R.id.button2);
        Button third= (Button) findViewById(R.id.button3);
        Button four = (Button) findViewById(R.id.button4);
        Button five = (Button) findViewById(R.id.button5);
        
        
	}

}
