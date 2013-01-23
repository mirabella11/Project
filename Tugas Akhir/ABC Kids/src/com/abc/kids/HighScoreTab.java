package com.abc.kids;

import android.app.TabActivity;
import android.content.Intent;
 import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class HighScoreTab extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_highscore);
    
   
    TabHost tabHost = getTabHost();  // The activity TabHost
    // Reusable TabSpec for each tab
      // Reusable Intent for each tab

    // Create an Intent to launch an Activity for the tab (to be reused)
     Intent  hsvoice = new Intent().setClass(this, HighScoreVoice.class);

    // Initialize a TabSpec for each tab and add it to the TabHost
    TabSpec  hs1 = tabHost.newTabSpec("Voice").setIndicator("High Score Voice")
                  .setContent(hsvoice);
   

    // Do the same for the other tabs
    Intent hsimage = new Intent().setClass(this, HighScoreImage.class);
    TabSpec  hs2= tabHost.newTabSpec("Image").setIndicator("High Score Image")
                  .setContent(hsimage);
    
    Intent hsarrange = new Intent().setClass(this, HighScoreArrange.class);
    TabSpec  hs3 = tabHost.newTabSpec("Arrange").setIndicator("High Score Arrange")
                  .setContent(hsarrange);
    
    tabHost.addTab(hs1);
    tabHost.addTab(hs2);
    tabHost.addTab(hs3);
    

}
}
