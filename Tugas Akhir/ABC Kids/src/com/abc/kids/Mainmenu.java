package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 

public class Mainmenu extends Activity {
	
	public Button animal , flower, fruit,back;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu_item);
	        
	        animal = (Button) findViewById(R.id.hewan);
	        flower = (Button) findViewById(R.id.bunga);
	        fruit = (Button) findViewById(R.id.buah);
	        back = (Button) findViewById(R.id.kembali);
	        
	        if(GlobalData.getInstance().lng==0){
	        	animal.setText("Animal");
	        	flower.setText("Flower");
	        	fruit.setText("Fruit");
	        	
	        }else{
	        	animal.setText("Hewan");
	           	flower.setText("Bunga");
	        	fruit.setText("Buah");
	        }
	        
	       animal.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View fourth) {
	            	
	            	Intent myIntent = new Intent(fourth.getContext(), MainLessonAnimal.class);
	                startActivityForResult(myIntent, 0);
                }

	        });
	       
	       flower.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View fourth1) {
	            	Intent myIntent = new Intent(fourth1.getContext(), MainLessonFlower.class);
	            	startActivityForResult(myIntent, 0);
               }

	        });
	       fruit.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View fourth2) {
	            	Intent myIntent = new Intent(fourth2.getContext(), MainLessonFruit.class);
	                startActivityForResult(myIntent, 0);
               }

	        });
	       
	       
	       back.setOnClickListener(new View.OnClickListener() {
	            

					public void onClick(View arg0) {
						Intent intent = new Intent();
		            	setResult(RESULT_OK, intent);
		            	finish();
						
             }

	        });
	        
	 }
}
