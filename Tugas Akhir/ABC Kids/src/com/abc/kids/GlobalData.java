package com.abc.kids;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

public class GlobalData {

	private static GlobalData mInstance=null;
	public long iduser=0;
	public int [] max_number = new int []{32,22,22};
	public  int[][] img = new int [][] {
			 { R.drawable.anm_1,R.drawable.anm_2,R.drawable.anm_3,R.drawable.anm_4,R.drawable.anm_5,R.drawable.anm_6,
			   R.drawable.anm_7,R.drawable.anm_8,R.drawable.anm_9,R.drawable.anm_10,R.drawable.anm_11,R.drawable.anm_12,
			   R.drawable.anm_13,R.drawable.anm_14,R.drawable.anm_15,R.drawable.anm_16,R.drawable.anm_17,R.drawable.anm_18,
			   R.drawable.anm_19,R.drawable.anm_20,R.drawable.anm_21,R.drawable.anm_22,R.drawable.anm_23,R.drawable.anm_24,
			   R.drawable.anm_25,R.drawable.anm_26,R.drawable.anm_27,R.drawable.anm_28,R.drawable.anm_29,R.drawable.anm_30,
			   R.drawable.anm_31,R.drawable.anm_32},
			 {  R.drawable.flo_1,R.drawable.flo_2,R.drawable.flo_3,R.drawable.flo_4,R.drawable.flo_5,R.drawable.flo_6,
			   R.drawable.flo_7,R.drawable.flo_8,R.drawable.flo_9,R.drawable.flo_10,R.drawable.flo_11,R.drawable.flo_12,
			   R.drawable.flo_13,R.drawable.flo_14,R.drawable.flo_15,R.drawable.flo_16,R.drawable.flo_17,R.drawable.flo_18,
			   R.drawable.flo_19,R.drawable.flo_20,R.drawable.flo_21,R.drawable.flo_22 },
			 {  R.drawable.fru_1,R.drawable.fru_2,R.drawable.fru_3,R.drawable.fru_4,R.drawable.fru_5,R.drawable.fru_6,
			   R.drawable.fru_7,R.drawable.fru_8,R.drawable.fru_9,R.drawable.fru_10,R.drawable.fru_11,R.drawable.fru_12,
		       R.drawable.fru_13,R.drawable.fru_14,R.drawable.fru_15,R.drawable.fru_16,R.drawable.fru_17,R.drawable.fru_18,
		       R.drawable.fru_19,R.drawable.fru_20,R.drawable.fru_21,R.drawable.fru_22 }}; 
	 
	public int [] voice = new int [] {R.raw.pling,R.raw.harimau,R.raw.pling,R.raw.harimau,R.raw.pling,
									  R.raw.pling,R.raw.harimau,R.raw.pling,R.raw.harimau,R.raw.pling,
									  R.raw.pling,R.raw.harimau,R.raw.pling,R.raw.harimau,R.raw.pling,
									  R.raw.pling,R.raw.harimau,R.raw.pling,R.raw.harimau,R.raw.pling,
									  R.raw.pling,R.raw.harimau,R.raw.pling,R.raw.harimau,R.raw.pling,
									  R.raw.pling,R.raw.harimau,R.raw.pling,R.raw.harimau,R.raw.pling,
									  R.raw.pling,R.raw.harimau};
	
	
	
	public int position = 0;
	public int lng;
	public float msc=1;
	
	public Report lastReport=null;
	protected GlobalData(){
		 
	}
	public static synchronized GlobalData getInstance(){
		if(null==mInstance){
			mInstance = new GlobalData();			
		}
		return mInstance;
	}
	public void setIduser(long a){		
		this.iduser=a;
	}
	public void setPosition(int a){		
		this.position=a;
	}
	public void setReport(Report a){		
		this.lastReport=a;
	}
	public void setLanguage(int language){
		this.lng=language;
	}
	public void setMusic(float music){
		this.msc=music;
	}
}



 