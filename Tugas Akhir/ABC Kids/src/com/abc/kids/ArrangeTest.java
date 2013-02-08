package com.abc.kids;

import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ArrangeTest extends Activity {
	private ImageView image;
	private Button first,second,third,fourth,fiveth,sixth;
	public WordDataSource datasource;
	public ReportDataSource scoresource;
	String answer="";
	int quizNumber=10;
	int rAnswer=0,wAnswer=0;
	int qType=0; //pembedaan tipe gambar yang dikeluarkan
	int iAnswer=0; //posisi button untuk jawaban yang benar 0=kiri 1=kanan
	Word[] list=null;
	int[] temp=null;
	RelativeLayout layout;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_arrange);
        layout=  (RelativeLayout) findViewById(R.id.layoutArrange);
        datasource = new WordDataSource(this);
        datasource.open();
        list= datasource.getSpell();
        datasource.close();
        scoresource = new ReportDataSource(this);
        
         image= (ImageView) findViewById (R.id.image1);
         first = (Button) findViewById(R.id.button1);
         second = (Button) findViewById(R.id.button2);
         third= (Button) findViewById(R.id.button3);
         fourth = (Button) findViewById(R.id.button4);
         fiveth = (Button) findViewById(R.id.button5);
         sixth = (Button) findViewById(R.id.button6);
         refreshButton();
         createQuestion();
         
	}
	private void checkButton(Button btn,String text){
		btn.setVisibility(View.GONE);
		answer+=text;
		Word q=list[iAnswer];
		if(GlobalData.getInstance().lng==0){
			if(q.getEng().length()==answer.length()){
				if(q.getEng().toUpperCase().equals(answer.toUpperCase())){
					Toast.makeText(this,"Answer right", Toast.LENGTH_LONG).show();
					rAnswer++;
				}else if(q.getEng().length()==answer.length()){
					Toast.makeText(this,"Answer wrong", Toast.LENGTH_LONG).show();	
					wAnswer++;
				}
				answerCheck();
			}
			
        } else {
        	if(q.getIndo().length()==answer.length()){
        		if(q.getIndo().toUpperCase().equals(answer.toUpperCase())){
    				Toast.makeText(this,"Answer right", Toast.LENGTH_LONG).show();
    				rAnswer++;
    			}else if(q.getIndo().length()==answer.length()){
    				Toast.makeText(this,"Answer wrong", Toast.LENGTH_LONG).show();
    				wAnswer++;
    			}
        		answerCheck();
        	}        	
        }
	}
	private void answerCheck(){
		if(rAnswer+wAnswer==quizNumber){
			Report res=scoresource.createReport(GlobalData.getInstance().iduser, 3, (rAnswer*100)/quizNumber);
			GlobalData.getInstance().setReport(res);
			Intent mainIntent = new Intent(ArrangeTest.this, ScoreTest.class);
			startActivity(mainIntent);
		}else{
			refreshButton();
			createQuestion();
		}
	}
	private void refreshButton(){
		answer="";
        first.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
           	 checkButton(first,first.getText().toString());
            }

        });
        second.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
           	 checkButton(second,second.getText().toString());
            }

        });
        third.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
           	 checkButton(third,third.getText().toString());
            }

        });

        fourth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
           	 checkButton(fourth,fourth.getText().toString());
            }

        });
        fiveth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
           	 checkButton(fiveth,fiveth.getText().toString());
            }

        });

        sixth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View voice1) {
           	 checkButton(sixth,sixth.getText().toString());
            }

        });

		first.setVisibility(View.GONE);
        second.setVisibility(View.GONE);
        third.setVisibility(View.GONE);
        fourth.setVisibility(View.GONE);
        fiveth.setVisibility(View.GONE);
        sixth.setVisibility(View.GONE);
	}
	  
    public void getButton (Word a){
    	String spell="";
    	if(GlobalData.getInstance().lng==0){    		    	   	 
    	   	spell=a.getEng();
        } else {
         	spell=a.getIndo();
        }
	    temp = new int[spell.length()];
	    
	    for(int i=0; i<spell.length(); i++){
	    	int place=0;
	    	if(i>0){
	    		Boolean check=true;
	    		while(check){
	    			Boolean same=false;
	    			Random rand = new Random();		
	        		place = rand.nextInt(spell.length());
	        		for(int j=0;j<i;j++){
	        			if(place==temp[j]){
	        				same=true;
	        				break;
	        			}        			
	        		}
	        		if(!same){
	        			temp[i]=place;
	        			break;
	        		}
	    		}
	    	}else{
	    		Random rand = new Random();		
	    		place = rand.nextInt(spell.length());
	    		temp[i]=place;
	    	}
	    	
	    	switch(i){
	    		case 0: 
	    			first.setText(""+spell.charAt(place));
	    			first.setVisibility(View.VISIBLE);
	    		break;
	    		case 1: 
	    			second.setText(""+spell.charAt(place));
	    			second.setVisibility(View.VISIBLE);
	    		break;
	    		case 2: 
	    			third.setText(""+spell.charAt(place));
	    			third.setVisibility(View.VISIBLE);
	    		break;
	    		case 3: 
	    			fourth.setText(""+spell.charAt(place));
	    			fourth.setVisibility(View.VISIBLE);
	    		break;
	    		case 4: 
	    			fiveth.setText(""+spell.charAt(place));
	    			fiveth.setVisibility(View.VISIBLE);
	    		break;
	    		case 5: 
	    			sixth.setText(""+spell.charAt(place));
	    			sixth.setVisibility(View.VISIBLE);
	    		break;
	    	}	    		   	
	    }
    }
    

    
    public void createQuestion (){  
    	Random random= new Random();
    	 
     	iAnswer=random.nextInt(list.length);
     	Word spell=list[iAnswer];   	 	
     	Drawable a = getResources().getDrawable(GlobalData.getInstance().img[(int) (spell.getType()-1)][spell.getImg()-1]);
     	image.setImageDrawable(a);
    	getButton(spell);
        
   	 
   	   	   	 
    }
 
   	 
}
