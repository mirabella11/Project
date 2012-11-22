package com.abc.kids;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class GlobalData {

	private static GlobalData mInstance=null;
	public long iduser=0;
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
}



 