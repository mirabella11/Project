package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreTest extends Activity{
		
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_score);
        
        Report hasil = GlobalData.getInstance().lastReport;
        
        TextView result = (TextView) findViewById(R.id.result_comment);
        TextView score = (TextView) findViewById(R.id.score_place);
        TextView resultscore = (TextView) findViewById(R.id.score);
        
        Button home = (Button) findViewById(R.id.home);
        Button play = (Button) findViewById(R.id.play);
        
        if(GlobalData.getInstance().lng==0){
        	score.setText("SCORE"); 
        if (hasil.getScore()<=50){
        	result.setText("NOT BAD , TRY AGAIN");
            }else if(hasil.getScore()>50&&hasil.getScore()<=80) {
            	  result.setText("GOOD JOB");
            }else if (hasil.getScore()>80&&hasil.getScore()<=100){
            	  result.setText("EXCELLENT");
            }
        }
        else {
        	score.setText("NILAI"); 
        	 if (hasil.getScore()<=50){
             	result.setText("TIDAK BURUK , COBA LAGI");
                 }else if(hasil.getScore()>50&&hasil.getScore()<=80) {
                 	  result.setText("BAGUS");
                 }else if (hasil.getScore()>80&&hasil.getScore()<=100){
                 	  result.setText("HEBAT");
                 }
        }
         resultscore.setText(""+hasil.getScore());
        
        
        
        
        
       home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View home1) {
            	Intent myIntent = new Intent(home1.getContext(),FirstChoice.class);
                startActivityForResult(myIntent, 0);
            }

        });
       
      play.setOnClickListener(new View.OnClickListener() {
           public void onClick(View play1) {
           	Intent myIntent = new Intent(play1.getContext(),MenuTest.class);
               startActivityForResult(myIntent, 0);
           }

       });
      
        
        
	}
}
