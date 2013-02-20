package com.abc.kids;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



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
        TextView  text = (TextView)findViewById(R.id.notice);
        
        createQuestion();
        if(GlobalData.getInstance().lng==0){
        	text.setText("Press the sound to hear the animal voice, then choose the animal which has the voice");
         }else{
        	text.setText("Tekan tombol suara untuk mendengarkan suara hewan, lalu pilihlah hewan yang mempunyai suara tersebut");
        }
        
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
       
      // player.setLooping(false); 
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
		
		if(answer==iAnswer){
			rAnswer++;
			check();
		}else{
			wAnswer++;
			toastImage();
			 new Handler().postDelayed(new Runnable(){
		            public void run() {
		            	check();
		                	               
		           	            		}
		        		}, 2000);	
		}
				
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
       	 
    	    
    	    boolean pass=true;
            int o=0;
            while(pass){
            	o = rand.nextInt(max-1);
            	if(o!=n){
            		pass=false;
            	}
            }
           Drawable e = getResources().getDrawable(GlobalData.getInstance().img[0][o]);
   	    	second.setBackgroundDrawable(e);
      	 
       }else{
    	   Drawable d = getResources().getDrawable(GlobalData.getInstance().img[0][n]);
    	   second.setBackgroundDrawable(d);
           
    	   boolean pass=true;
           int o=0;
           while(pass){
           	o = rand.nextInt(max-1);
           	if(o!=n){
           		pass=false;
           	}
           }
           Drawable e = getResources().getDrawable(GlobalData.getInstance().img[0][o]);
           first.setBackgroundDrawable(e);
       }       
       datasource.close();
   }
   
   public void toastImage(){
		Toast toastGambar = new Toast(this);
		        ImageView iv = new ImageView(this);
		        iv.setImageResource(R.drawable.wrong);
		        toastGambar.setGravity(Gravity.AXIS_CLIP |Gravity.CENTER_VERTICAL,0, 0);
		        toastGambar.setView(iv);
		        toastGambar.setDuration(1000);
		        toastGambar.show();
		}
   public void check(){
	   scoresource.open();
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
}
