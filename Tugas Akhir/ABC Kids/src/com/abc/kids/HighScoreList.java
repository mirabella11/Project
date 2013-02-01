package com.abc.kids;

 
 
import java.util.List;

 
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

 

public class HighScoreList extends ListActivity {
		 
	private ReportDataSource datasource;	
	private List<Report> listReport = null;
 
	public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_highscore);
    
    Button highvoice = (Button) findViewById(R.id.hs1);
    Button highimage = (Button) findViewById(R.id.hs2);		
    Button higharrange = (Button) findViewById(R.id.hs3);
    

    datasource = new ReportDataSource(this);
    datasource.open();
    
    List<Report> values = datasource.getHighscore(1);
    
    ArrayAdapter<Report> adapter = new ArrayAdapter<Report>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter); 
     
    
    
    highvoice.setOnClickListener(new View.OnClickListener() {
        public void onClick(View second) {
        	
        	
        	refreshListAdapter(1);
    }
    });
    highimage.setOnClickListener(new View.OnClickListener() {
        public void onClick(View second) {
        	
        	
        	refreshListAdapter(2);
    }
    });
    higharrange.setOnClickListener(new View.OnClickListener() {
        public void onClick(View second) {
        	
        	
        	refreshListAdapter(3);
    }
    });
    
   
     
     datasource.close();
     
     
   

}
	 protected void refreshListAdapter(int i) {
		 datasource.open();
		 List<Report> values = datasource.getHighscore(i);
		 ArrayAdapter<Report> adapter = new ArrayAdapter<Report>(this,
	     android.R.layout.simple_list_item_1, values);
	     setListAdapter(adapter);
	     datasource.close();
     	}
	 
	}
