package com.abc.kids;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;

public class MainLessonFruit extends Activity implements OnClickListener {
	private Button home,back,prev,spell,list,next;
	private ImageView image= null;
	private Word data;
   	public Dialog alfabetDialog;
  	public Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
  	
	
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_lesson_fru);
	        
	        GlobalData.getInstance().setPosition(0);
	      //  data = (Word) getIntent().getExtras().getSerializable("Word");
	        
	        home = (Button) findViewById(R.id.home_2);
	        back = (Button) findViewById(R.id.back_2);
	        prev = (Button) findViewById(R.id.prev_2);
	        spell = (Button) findViewById(R.id.spell_2);
	        list = (Button) findViewById(R.id.list_2);
	        next= (Button) findViewById(R.id.next_2);
	        image = (ImageView) findViewById(R.id.imageView1);
	        
	         
	         if (GlobalData.getInstance().position==0){
         		prev.setEnabled(false);
         			}
	         
	         
	      ChangeImage();
	        
	      home.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View five) {
	            	Intent myIntent = new Intent(five.getContext(), FirstChoice.class);
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
	        
	      prev.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	            	 
	            	if (GlobalData.getInstance().position-1==0){
	             		prev.setEnabled(false);
	             	}else{
	             		prev.setEnabled(true);
	             		}	
	   	        
	            	GlobalData.getInstance().setPosition(GlobalData.getInstance().position-1);
	            	ChangeImage();
	            	
	            		}

	      	});
	        
	      
	        
	      spell.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view1) {
	            	 
	            		}

	        });
	      list.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view1) {
	             	 ListAlfabet();
	            	 alfabetDialog.show(); 
	            		}

	        });
	      next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
            	prev.setEnabled(true);
            	if (GlobalData.getInstance().position+1==GlobalData.getInstance().max_number[0]-1){
            		
             		next.setEnabled(false);
             	}else{
             		
             		next.setEnabled(true);
             		
             	}
            	GlobalData.getInstance().setPosition(GlobalData.getInstance().position+1);
            	ChangeImage();
         }

        });
	 }
	  
	 private void ChangeImage(){
		 Drawable d = getResources().getDrawable(GlobalData.getInstance().img[2][GlobalData.getInstance().position]);
         image.setImageDrawable(d);
	 	}
	
	   
	   
	   public void ListAlfabet(){
		    alfabetDialog = new Dialog(MainLessonFruit.this);
		   alfabetDialog.setContentView(R.layout.list_alfabet);
		   
		   LayoutParams alfabetDialogParams = alfabetDialog.getWindow().getAttributes();
			alfabetDialogParams.width = LayoutParams.FILL_PARENT;
			alfabetDialog.getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) alfabetDialogParams);
					
	/*		 a= (Button)findViewById(R.id.btnA);
			 a.setOnClickListener(this);
			 
			 b= (Button)findViewById(R.id.btnB);
			 b.setOnClickListener(this);
			 
			 c= (Button)findViewById(R.id.btnC);
			 c.setOnClickListener(this);
			 
			 d= (Button)findViewById(R.id.btnD);
			 d.setOnClickListener(this);
			 
			 e= (Button)findViewById(R.id.btnE);
			 e.setOnClickListener(this);
			 
			 f= (Button)findViewById(R.id.btnF);
			 f.setOnClickListener(this);
			 
			 g= (Button)findViewById(R.id.btnG);
			 g.setOnClickListener(this);
			 
			 h= (Button)findViewById(R.id.btnH);
			 h.setOnClickListener(this);
			 
			 i= (Button)findViewById(R.id.btnI);
			 i.setOnClickListener(this);
			 
			 j= (Button)findViewById(R.id.btnJ);
			 j.setOnClickListener(this);
			 
			 k= (Button)findViewById(R.id.btnK);
			 k.setOnClickListener(this);
			 
			 l= (Button)findViewById(R.id.btnL);
			 l.setOnClickListener(this);
			 
			 m= (Button)findViewById(R.id.btnM);
			 m.setOnClickListener(this);
			 
			 n= (Button)findViewById(R.id.btnN); 
			 n.setOnClickListener(this);
			 
			 o= (Button)findViewById(R.id.btnO);
			 o.setOnClickListener(this);
			 
			 p= (Button)findViewById(R.id.btnP);
			 p.setOnClickListener(this);
			 
			 q= (Button)findViewById(R.id.btnQ);
			 q.setOnClickListener(this);
			 
			 r= (Button)findViewById(R.id.btnR);
			 r.setOnClickListener(this);
			 
			 s= (Button)findViewById(R.id.btnS);
			 s.setOnClickListener(this);
			 
			 t= (Button)findViewById(R.id.btnT);
			 t.setOnClickListener(this);
			 
			 u= (Button)findViewById(R.id.btnU);
			 u.setOnClickListener(this);
			 
			 v= (Button)findViewById(R.id.btnV); 
			 v.setOnClickListener(this);
			 
			 w= (Button)findViewById(R.id.btnW); 
			 w.setOnClickListener(this);
			 
			 x= (Button)findViewById(R.id.btnX); 
			 x.setOnClickListener(this);
			 
			 y= (Button)findViewById(R.id.btnY);
			 y.setOnClickListener(this);
			 
			 z= (Button)findViewById(R.id.btnZ);
			 z.setOnClickListener(this);
			 
			 
			 */
			 
	   }

	public void onClick(View view) {

		switch (view.getId()){
		case R.id.btnA:
			
			break;
		}
		
	}
}
	
			