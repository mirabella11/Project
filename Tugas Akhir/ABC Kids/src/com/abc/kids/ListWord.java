package com.abc.kids;

import java.util.List;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class ListWord extends ListActivity{
	private List<User> listWord = null;
	private WordDataSource datasource;
	private Button add;
	
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.choose_word);
	       
	         
	         
	         datasource = new WordDataSource(this);
	         datasource.open();
	         
	        
	         List<Word> values = datasource.getAllWord();

	         // Use the SimpleCursorAdapter to show the
	         // elements in a ListView
	         ArrayAdapter<Word> adapter = new ArrayAdapter<Word>(this,
	         android.R.layout.simple_list_item_1, values);
	         setListAdapter(adapter);      
	          
	 	}
	 
	 @Override
	 protected void onListItemClick(ListView l, View v, int position, long id) {
		 super.onListItemClick(l, v, position, id);
		    // Get the item that was clicked
		   	Word o = (Word) l.getItemAtPosition(position);
		   
		     
		    Intent mainIntent = new Intent(ListWord.this,MainLessonAnimal.class);
		    mainIntent.putExtra("Word", o);
            startActivity(mainIntent);
		   
		  }
	
	
	
}
