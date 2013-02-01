package com.abc.kids;

import java.util.List;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


public class HighScoreVoice extends ListActivity{
	
	private ReportDataSource datasource;	
	private List<Report> listReport = null;
	
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.high_score_voice);
	        
	        datasource = new ReportDataSource(this);
	        datasource.open();
	        
	    
	        
	        List<Report> values = datasource.getHighscore(1);
	        
	         ArrayAdapter<Report> adapter = new ArrayAdapter<Report>(this,
	             android.R.layout.simple_list_item_1, values);
	         setListAdapter(adapter); 
	         
	         
	         
	         	
	    	         
	    		 
	    	 
	         datasource.close();
		        
	        
	 }
	 
	
}
