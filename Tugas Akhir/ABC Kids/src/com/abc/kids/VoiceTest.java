package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class VoiceTest extends Activity {
	
	public MediaPlayer player;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_voice);
        
        ImageButton first = (ImageButton) findViewById(R.id.animal1);
        ImageButton second = (ImageButton) findViewById(R.id.animal2);
        Button sound = (Button) findViewById(R.id.btnSound);
        
        first.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
            	
          }

        });
        
        second.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
            	
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
       player = MediaPlayer.create(this,GlobalData.getInstance().voice[GlobalData.getInstance().position]);
 
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
}
