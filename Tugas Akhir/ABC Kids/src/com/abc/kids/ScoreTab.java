package com.abc.kids;



import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ScoreTab extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_score);
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        // Reusable TabSpec for each tab
          // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
         Intent  scoreintent = new Intent().setClass(this, ListScore.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        TabSpec   score = tabHost.newTabSpec("Score").setIndicator("Score",
                          res.getDrawable(R.drawable.ic_tab_artists))
                      .setContent(scoreintent);
       

        // Do the same for the other tabs
        Intent highscoreintent = new Intent().setClass(this, HighScoreTab.class);
        TabSpec  highscore = tabHost.newTabSpec("HighScore").setIndicator("HighScore",
                          res.getDrawable(R.drawable.ic_tab_albums))
                      .setContent(highscoreintent );
        
        tabHost.addTab(score);
        tabHost.addTab(highscore);

        

}
}
