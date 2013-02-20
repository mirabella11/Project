package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreTest extends Activity{
	public MediaPlayer player;
		
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
          	playSoundEnglish(28);
            }else if(hasil.getScore()>50&&hasil.getScore()<=80) {
            	  result.setText("GOOD JOB");
               	playSoundEnglish(26);
            }else if (hasil.getScore()>80&&hasil.getScore()<=100){
            	  result.setText("EXCELLENT");
              	playSoundEnglish(27);
            }
        }
        else {
        	score.setText("NILAI"); 
        	 if (hasil.getScore()<=50){
             	result.setText("TIDAK BURUK , COBA LAGI");
            	playSoundIndo(28);
                 }else if(hasil.getScore()>50&&hasil.getScore()<=80) {
                 	  result.setText("BAGUS");
                 	 playSoundIndo(26);
                 }else if (hasil.getScore()>80&&hasil.getScore()<=100){
                 	  result.setText("HEBAT");
                 	 playSoundIndo(27);
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
	
	public void playSoundEnglish(int position){
		GlobalData.getInstance().setPosition(position);
    	try{
            if (player.isPlaying()) {
                player.stop();
                player.release();
            }
        }catch(Exception e){
            
        }
       player = MediaPlayer.create(this,GlobalData.getInstance().voice_english[GlobalData.getInstance().position]);
       player.setVolume(0,GlobalData.getInstance().msc);
       player.setLooping(false); 
       player.start();
 	}
	
	public void playSoundIndo(int position){
		GlobalData.getInstance().setPosition(position);
    	try{
            if (player.isPlaying()) {
                player.stop();
                player.release();
            }
        }catch(Exception e){
            
        }
       player = MediaPlayer.create(this,GlobalData.getInstance().voice_indonesia[GlobalData.getInstance().position]);
       player.setVolume(0,GlobalData.getInstance().msc);
       player.setLooping(false); 
       player.start();
 	}
	
 
}
