package com.abc.kids;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainLessonFlower extends Activity  {
	private Button home,back,prev,spell,list,next;
	private ImageView image= null;
	private Word data;
   	public Dialog alfabetDialog;
  	public Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
  	private TextView name;
	public WordDataSource datasource;
	private int[] listarray={};
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_lesson_flo);
	        
	        datasource = new WordDataSource(this);
	        datasource.open();
	        listarray=datasource.getList(GlobalData.getInstance().lng, 2);
	        datasource.close();
	        GlobalData.getInstance().setPosition(0);
	      
	        
	        home = (Button) findViewById(R.id.home_1);
	        back = (Button) findViewById(R.id.back_1);
	        prev = (Button) findViewById(R.id.prev_1);
	        
	        spell = (Button) findViewById(R.id.spell_1);
	        list = (Button) findViewById(R.id.list_1);
	        next= (Button) findViewById(R.id.next_1);
	        image = (ImageView) findViewById(R.id.imageView1);
	        name = (TextView) findViewById(R.id.flowername);
	         
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
	            	next.setEnabled(true); 
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
            	if (GlobalData.getInstance().position+1==GlobalData.getInstance().max_number[1]-1){
            		
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
		 datasource.open();
		 Drawable d = getResources().getDrawable(GlobalData.getInstance().img[1][listarray[GlobalData.getInstance().position]-1]);
         image.setImageDrawable(d);
         Word flo = datasource.get(listarray[GlobalData.getInstance().position]-1, 2);
         if (GlobalData.getInstance().lng==0){
        	 name.setText(flo.getEng());
             }else{
             name.setText(flo.getIndo()); 
             }
         
         datasource.close();
	 	}
	  
	   
	   public void ListAlfabet(){
		    alfabetDialog = new Dialog(MainLessonFlower.this);
		   alfabetDialog.setContentView(R.layout.list_alfabet);
		   
		   LayoutParams alfabetDialogParams = alfabetDialog.getWindow().getAttributes();
			alfabetDialogParams.width = LayoutParams.FILL_PARENT;
			alfabetDialog.getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) alfabetDialogParams);
					
			
			a= (Button)alfabetDialog.findViewById(R.id.btnA);
		 	b= (Button)alfabetDialog.findViewById(R.id.btnB);
		 	c= (Button)alfabetDialog.findViewById(R.id.btnC);
		 	d= (Button)alfabetDialog.findViewById(R.id.btnD);
		 	e= (Button)alfabetDialog.findViewById(R.id.btnE); 
			f= (Button)alfabetDialog.findViewById(R.id.btnF);
		    g= (Button)alfabetDialog.findViewById(R.id.btnG);
		    h= (Button)alfabetDialog.findViewById(R.id.btnH); 
		    i= (Button)alfabetDialog.findViewById(R.id.btnI);
		    j= (Button)alfabetDialog.findViewById(R.id.btnJ); 
		    k= (Button)alfabetDialog.findViewById(R.id.btnK);
		    l= (Button)alfabetDialog.findViewById(R.id.btnL);
		    m= (Button)alfabetDialog.findViewById(R.id.btnM); 
		    n= (Button)alfabetDialog.findViewById(R.id.btnN); 
		    o= (Button)alfabetDialog.findViewById(R.id.btnO);
		    p= (Button)alfabetDialog.findViewById(R.id.btnP); 
		    q= (Button)alfabetDialog.findViewById(R.id.btnQ);
		    r= (Button)alfabetDialog.findViewById(R.id.btnR);
		    s= (Button)alfabetDialog.findViewById(R.id.btnS); 
		    t= (Button)alfabetDialog.findViewById(R.id.btnT); 
			u= (Button)alfabetDialog.findViewById(R.id.btnU);
			v= (Button)alfabetDialog.findViewById(R.id.btnV); 
			w= (Button)alfabetDialog.findViewById(R.id.btnW); 
		    x= (Button)alfabetDialog.findViewById(R.id.btnX); 
		    y= (Button)alfabetDialog.findViewById(R.id.btnY);
		    z= (Button)alfabetDialog.findViewById(R.id.btnZ);
			 
		    
			 
		 	a.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	
	            	GlobalData.getInstance().setPosition(0);
		    		alfabetDialog.hide();
		        	ChangeImage(); 
		        	prev.setEnabled(false);
		        	next.setEnabled(true);
	            		}
	        });
			 
		 	
			b.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(3);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(4);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			
			c.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(6);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(15);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			 
			d.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(12);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(16);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			 
			e.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(15);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(19);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			
			f.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(16);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(20);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			
			g.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(18);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(21);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			 
			h.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(20);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(23);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			
			i.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(23);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(26);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			
			j.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(25);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(28);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			 

			k.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(26);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(28);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			

			l.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(26);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(32);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			m.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(29);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(35);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			n.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(31);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(37);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			o.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(32);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(38);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			p.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(34);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(39);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			q.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(37);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(41);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			r.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(37);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(41);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			s.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(39);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(41);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			t.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(41);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(43);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			u.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(44);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(44);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			v.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(44);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }else{
	                    GlobalData.getInstance().setPosition(44);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(true);
	                     }
	            		            		}
	        });
			w.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(45);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }else{
	                    GlobalData.getInstance().setPosition(45);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }
	            		            		}
	        });
			x.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(45);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }else{
	                    GlobalData.getInstance().setPosition(45);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }
	            		            		}
	        });
			y.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(45);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }else{
	                    GlobalData.getInstance().setPosition(45);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }
	            		            		}
	        });
			z.setOnClickListener(new OnClickListener() {
	            public void onClick(View view) {
	            	 if (GlobalData.getInstance().lng==0){
	            		 GlobalData.getInstance().setPosition(45);
	 		    		alfabetDialog.hide();
	 		        	ChangeImage(); 
	 		        	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }else{
	                    GlobalData.getInstance().setPosition(45);
	 	 		    	alfabetDialog.hide();
	 	 		    	ChangeImage(); 
	 	 		    	prev.setEnabled(true);
			        	next.setEnabled(false);
	                     }
	            		            		}
	        });
			 
			
		
			 
	   }
}
	
			