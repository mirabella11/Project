package com.abc.kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreTest extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_score);
        
        TextView result = (TextView) findViewById(R.id.textView1);
        TextView score = (TextView) findViewById(R.id.textView2);
        TextView resultscore = (TextView) findViewById(R.id.textView3);
        TextView true_= (TextView) findViewById(R.id.textView4);
        TextView result_true= (TextView) findViewById(R.id.textView5);
        TextView false_ = (TextView) findViewById(R.id.textView6);
        TextView result_false = (TextView) findViewById(R.id.textView7);
        Button home = (Button) findViewById(R.id.home);
        Button play = (Button) findViewById(R.id.play);
        
       home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View home1) {
            	Intent myIntent = new Intent(home1.getContext(),FirstChoice.class);
                startActivityForResult(myIntent, 0);
            }

        });
       
        
        
	}
}
