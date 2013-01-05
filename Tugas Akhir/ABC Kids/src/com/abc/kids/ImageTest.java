package com.abc.kids;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageTest extends Activity{
	private ImageView image;
	private Button first,second;
	public WordDataSource datasource;
	public ReportDataSource scoresource;
	
	int quizNumber=10;
	int rAnswer=0,wAnswer=0;
	int qType=0; //pembedaan tipe gambar yang dikeluarkan
	int iAnswer=0; //posisi button untuk jawaban yang benar 0=kiri 1=kanan
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_image);
        
        datasource = new WordDataSource(this);
        scoresource = new ReportDataSource(this);
       
        
        image = (ImageView) findViewById(R.id.image1);
        first = (Button) findViewById(R.id.button1);
        second = (Button) findViewById(R.id.button2);
        
        if(GlobalData.getInstance().lng==0){
        	  createQuestion();
        	
        }else{
        	  createQuestionIndo();
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
        
        
	}
	
	private void checkAnswer(int answer){
		 scoresource.open();
		if(answer==iAnswer){
			rAnswer++;
		}else{
			wAnswer++;
		}
		
		if(quizNumber==(rAnswer+wAnswer)){
			Report res=scoresource.createReport(GlobalData.getInstance().iduser, 2, (rAnswer*100)/quizNumber);
			GlobalData.getInstance().setReport(res);
			Intent mainIntent = new Intent(ImageTest.this, ScoreTest.class);
			startActivity(mainIntent);
		}else if((rAnswer+wAnswer)<=10){
			
			 if(GlobalData.getInstance().lng==0){
	        	  createQuestion();
	        	
	        }else{
	        	  createQuestionIndo();
	        }   
			 }
		
		scoresource.close();
		
	}
	
	public void createQuestion(){	
		datasource.open();
		Random rand = new Random();
		
		qType = rand.nextInt(3);
		int max = GlobalData.getInstance().max_number[qType];
		int n = rand.nextInt(max-1);
		Drawable d = getResources().getDrawable(GlobalData.getInstance().img[qType][n]);
        image.setImageDrawable(d);
        
        iAnswer = rand.nextInt(2);
        if(iAnswer==0){
        	Word satu=datasource.get(n,qType+1);
            first.setText(satu.getEng());
            
            int o = rand.nextInt(max-1);
            Word dua=datasource.get(o,qType+1);
            second.setText(dua.getEng());
        }else{
        	Word satu=datasource.get(n,qType+1);
        	second.setText(satu.getEng());
            
            int o = rand.nextInt(max-1);
            Word dua=datasource.get(o,qType+1);
            first.setText(dua.getEng());
        }       
        datasource.close();
	}
	
	public void createQuestionIndo(){	
		datasource.open();
		Random rand = new Random();
		
		qType = rand.nextInt(3);
		int max = GlobalData.getInstance().max_number[qType];
		int n = rand.nextInt(max-1);
		Drawable d = getResources().getDrawable(GlobalData.getInstance().img[qType][n]);
        image.setImageDrawable(d);
        
        iAnswer = rand.nextInt(2);
        if(iAnswer==0){
        	Word satu=datasource.get(n,qType+1);
            first.setText(satu.getIndo());
            
            int o = rand.nextInt(max-1);
            Word dua=datasource.get(o,qType+1);
            second.setText(dua.getIndo());
        }else{
        	Word satu=datasource.get(n,qType+1);
        	second.setText(satu.getIndo());
            
            int o = rand.nextInt(max-1);
            Word dua=datasource.get(o,qType+1);
            first.setText(dua.getIndo());
        }       
        datasource.close();
	}
}