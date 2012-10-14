package com.abc.kids;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MenuTest extends Activity{
	
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_game);

	        ImageButton guessvoice = (ImageButton) findViewById(R.id.suara);
	        ImageButton guessimage = (ImageButton) findViewById(R.id.gambar);
	        ImageButton arrange = (ImageButton) findViewById(R.id.kata);
	        
	        
}
}