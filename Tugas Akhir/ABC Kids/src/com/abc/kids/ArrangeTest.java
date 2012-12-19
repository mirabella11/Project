package com.abc.kids;

import java.util.Random;

import com.abc.kids.R.layout;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ArrangeTest extends Activity {
	private ImageView image;
	private Button first,second,third,fourth,fiveth,sixth;
	public WordDataSource datasource;
	public ReportDataSource scoresource;
	
	int quizNumber=10;
	int rAnswer=0,wAnswer=0;
	int qType=0; //pembedaan tipe gambar yang dikeluarkan
	int iAnswer=0; //posisi button untuk jawaban yang benar 0=kiri 1=kanan
	Word[] list=null;
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
         first.setVisibility(View.GONE);
         second.setVisibility(View.GONE);
         third.setVisibility(View.GONE);
         fourth.setVisibility(View.GONE);
         fiveth.setVisibility(View.GONE);
         sixth.setVisibility(View.GONE                                                                                                                    );
         createQuestion();
	}

	  
    public void getButton (Word a){
    
    for(int i=0; i<a.getEng().length(); i++){
   	  
    	switch(i){
    		case 0: 
    			first.setText(""+a.getEng().charAt(i));
    			first.setVisibility(View.VISIBLE);
    		break;
    		case 1: 
    			second.setText(""+a.getEng().charAt(i));
    			second.setVisibility(View.VISIBLE);
    		break;
    		case 2: 
    			third.setText(""+a.getEng().charAt(i));
    			third.setVisibility(View.VISIBLE);
    		break;
    		case 3: 
    			fourth.setText(""+a.getEng().charAt(i));
    			fourth.setVisibility(View.VISIBLE);
    		break;
    		case 4: 
    			fiveth.setText(""+a.getEng().charAt(i));
    			fiveth.setVisibility(View.VISIBLE);
    		break;
    		case 5: 
    			sixth.setText(""+a.getEng().charAt(i));
    			sixth.setVisibility(View.VISIBLE);
    		break;
    	}
   	 /*Button b = new Button(this);
   	 b.setOnClickListener(new OnClickListener() {

   	        public void onClick(View v) {
   	                      
   	                  }

   	 });
   	RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(

   			RelativeLayout.LayoutParams.WRAP_CONTENT,
   			RelativeLayout.LayoutParams.WRAP_CONTENT   			
    );
   	 
   	 b.setText(""+a.getIndo().charAt(i));
   	 
   	 b.setWidth(30);
   	 b.setHeight(20);
  
   	 layout.addView(b,p);*/
    }
    }
    
    
    
    
    public void createQuestion (){   	 
   	 Random rando= new Random();
   	 
   	 iAnswer=rando.nextInt(list.length);
   	 Word spell=list[iAnswer];   	 	
   	 Drawable a = getResources().getDrawable(GlobalData.getInstance().img[(int) (spell.getType()-1)][spell.getImg()-1]);
   	 image.setImageDrawable(a);
   	 
   	 getButton(spell);
   	 
   	 
   	 
    }
   	 
}
