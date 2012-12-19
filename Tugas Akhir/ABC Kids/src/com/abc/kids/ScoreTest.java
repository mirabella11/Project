package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreTest extends Activity{
	
	private ImageTest scoretest;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_score);
        
        Report hasil = GlobalData.getInstance().lastReport;
        
        TextView result = (TextView) findViewById(R.id.textView1);
        TextView score = (TextView) findViewById(R.id.textView2);
        TextView resultscore = (TextView) findViewById(R.id.textView3);
        
        Button home = (Button) findViewById(R.id.home);
        Button play = (Button) findViewById(R.id.play);
        
        
        if (hasil.getScore()<=50){
        	result.setText("NOT BAD , TRY AGAIN");
            }else if(hasil.getScore()>50&&hasil.getScore()<=80) {
            	  result.setText("GOOD JOB");
            }else if (hasil.getScore()>80&&hasil.getScore()<=100){
            	  result.setText("EXCELLENT");
            }
       
        resultscore.setText(""+hasil.getScore());
        
        
        
        
        
       home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View home1) {
            	Intent myIntent = new Intent(home1.getContext(),FirstChoice.class);
                startActivityForResult(myIntent, 0);
            }

        });
       
    /*  play.setOnClickListener(new View.OnClickListener() {
           public void onClick(View play1) {
           	Intent myIntent = new Intent(play1.getContext(),FirstChoice.class);
               startActivityForResult(myIntent, 0);
           }

       });
      */ 
        
        
	}
}
