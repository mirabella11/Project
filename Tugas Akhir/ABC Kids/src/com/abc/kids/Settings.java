package com.abc.kids;

 

import android.app.Activity;
import android.os.Bundle; 
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;


public class Settings  extends Activity {
	public CheckBox msc;
	public TextView desc;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.setting);
	        
	        msc=(CheckBox) findViewById (R.id.music);
	        desc =(TextView) findViewById(R.id.musicdesc);
	        
	        if(GlobalData.getInstance().msc==1){
	        	msc.setChecked(true);
	        }else{
	        	msc.setChecked(false);
	        }
	        if(GlobalData.getInstance().lng==0){
	        	 
	        	desc.setText("Setting For Music");
	        	
	        }else{
	        	 
	        	desc.setText("Pengaturan Musik");
	        }
	        msc.setOnClickListener(new OnClickListener() {

				public void onClick(View arg0) {
					if (msc.isChecked()){
						 
						GlobalData.getInstance().setMusic(1);
						
					}
					else {
						GlobalData.getInstance().setMusic(0);
					}
					
				}
			});
	        
	 }
 
}