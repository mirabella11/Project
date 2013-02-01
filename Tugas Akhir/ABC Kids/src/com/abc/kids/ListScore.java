package com.abc.kids;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ListScore extends Activity{

	public ReportDataSource scoresource;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list_score);
	       
	        scoresource = new ReportDataSource(this);
	        scoresource.open();
	        TextView scorev = (TextView) findViewById(R.id.score_place_voice);
	        TextView scorei = (TextView) findViewById(R.id.score_place_image);
	        TextView scorea = (TextView) findViewById(R.id.score_place_arrange);
	        TextView score1 = (TextView) findViewById(R.id.score_voice);
	        TextView score2 = (TextView) findViewById(R.id.score_image);
	        TextView score3 = (TextView) findViewById(R.id.score_arrange);
	        
	        Report rep1 = scoresource.getHigh(GlobalData.getInstance().iduser,1);
	        score1.setText(""+rep1.getScore());
	        
	        Report rep2 = scoresource.getHigh(GlobalData.getInstance().iduser,2);
	        score2.setText(""+rep2.getScore());
	        
	        scoresource.close();
	        
	 }
}
