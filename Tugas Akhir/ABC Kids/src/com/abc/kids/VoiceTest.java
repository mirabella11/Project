package com.abc.kids;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class VoiceTest extends Activity {
	
	public MediaPlayer player;
	public WordDataSource datasource;
	int quizNumber=10;
	int rAnswer=0,wAnswer=0;
	 
	int iAnswer=0; //posisi button untuk jawaban yang benar 0=kiri 1=kanan
	private Button first,second,sound;
	public ReportDataSource scoresource;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_voice);
        scoresource = new ReportDataSource(this);
        
        datasource = new WordDataSource(this);
        
        first = (Button) findViewById(R.id.animal1);
        second = (Button) findViewById(R.id.animal2);
        sound = (Button) findViewById(R.id.btnSound);
        
        createQuestion();
        
        first.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
            	checkAnswer(0);
          }

        });
        
        second.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
            	checkAnswer(1);
          }

        });
        
        
        sound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
            	playSound();
          }

        });
   
	}
	 
    public void playSound( ){
    	try{
            if (player.isPlaying()) {
                player.stop();
                player.release();
            }
        }catch(Exception e){
            
        }
       
       player.setLooping(false); 
        player.start();
 	}
 
    
public void onPause() {
	        try{
	        super.onPause();
	        player.pause();
	        }catch (Exception e){
	 
	        }
	    }
   
   
   
   private void checkAnswer(int answer){
		 scoresource.open();
		if(answer==iAnswer){
			rAnswer++;
		}else{
			wAnswer++;
		}
		
		if(quizNumber==(rAnswer+wAnswer)){
			Report res=scoresource.createReport(GlobalData.getInstance().iduser, 1, (rAnswer*100)/quizNumber);
			GlobalData.getInstance().setReport(res);
			Intent mainIntent = new Intent(VoiceTest.this, ScoreTest.class);
			startActivity(mainIntent);
		}else if((rAnswer+wAnswer)<=10){
			createQuestion();
		}
		
		scoresource.close();
		
	}
   
   public void createQuestion(){
	   datasource.open();
		Random rand = new Random();
		
	
		int max = GlobalData.getInstance().max_number[0];
		int n = rand.nextInt(max-1);
		player = MediaPlayer.create(this,GlobalData.getInstance().voice[n]);
		
		
		
       
       iAnswer = rand.nextInt(2);
       if(iAnswer==0){
    	   Drawable d = getResources().getDrawable(GlobalData.getInstance().img[0][n]);
    	    first.setBackgroundDrawable(d);
       	 
           
           int o = rand.nextInt(max-1);
           Drawable e = getResources().getDrawable(GlobalData.getInstance().img[0][o]);
   	    	second.setBackgroundDrawable(e);
      	 
       }else{
    	   Drawable d = getResources().getDrawable(GlobalData.getInstance().img[0][n]);
    	   second.setBackgroundDrawable(d);
           
           int o = rand.nextInt(max-1);
           Drawable e = getResources().getDrawable(GlobalData.getInstance().img[0][o]);
           first.setBackgroundDrawable(e);
       }       
       datasource.close();
   }
}
