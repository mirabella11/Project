package com.abc.kids;

import java.util.ArrayList;
import java.util.List;


import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListUser extends ListActivity {
	
	
	private UserDataSource datasource;
	private Button add;
	private Button Back,Save,Change,Select,Delete;
	private TextView notice;
	private Dialog formdialog, Buttondialog,Updatedialog;
	private EditText user_name;
	private List<User> listUser = null;
	
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.choose_user);
	       
	       
	         datasource = new UserDataSource(this);
	         datasource.open();
	         
	         add = (Button) findViewById(R.id.add);
	         List<User> values = datasource.getAllUser();

	         // Use the SimpleCursorAdapter to show the
	         // elements in a ListView
	         ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
	             android.R.layout.simple_list_item_1, values);
	         setListAdapter(adapter);
	         
	         
	         add.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View view) {
		            	formdialog.show();

	 }
	         });
	         prepareFormDialog();
	         
	 }
	 
	 @Override
	 protected void onListItemClick(ListView l, View v, int position, long id) {
		 super.onListItemClick(l, v, position, id);
		    // Get the item that was clicked
		    User o = (User) l.getItemAtPosition(position);
		    String keyword =  o.getName();
		     
		    prepareButtonDialog(o);
		    Buttondialog.show();
		   
		  }
	

	 private void prepareFormDialog() {
			formdialog = new Dialog(ListUser.this);
			formdialog.setContentView(R.layout.save_user);
			
			

			LayoutParams formDialogParams = formdialog.getWindow().getAttributes();
			formDialogParams.width = LayoutParams.FILL_PARENT;
			formdialog.getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) formDialogParams);

			user_name = (EditText) formdialog.findViewById(R.id.FormName);
			 

			Back = (Button) formdialog.findViewById(R.id.btnCancel);
			Save = (Button) formdialog.findViewById(R.id.btnSave);

			Save.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
			 		
					datasource.createUser(user_name.getText().toString());
					
					listUser = datasource.getAllUser();
					refreshListAdapter();
					formdialog.hide(); 
 			}
			});

			Back.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {

					formdialog.hide();
				}
			});
		}
	 
	 protected void refreshListAdapter() {
		 datasource.updateListUser(listUser);
		 ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
	             android.R.layout.simple_list_item_1, listUser);
	         setListAdapter(adapter);
	         
		}
	 
	 
	 private void prepareButtonDialog(final User user) {
			Buttondialog = new Dialog(ListUser.this);
			Buttondialog.setContentView(R.layout.button_choice);
			
			
			LayoutParams ButtonDialogParams = Buttondialog.getWindow().getAttributes();
			ButtonDialogParams.width = LayoutParams.FILL_PARENT;
			Buttondialog.getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) ButtonDialogParams);					    
		    
			notice = (TextView) Buttondialog.findViewById(R.id.notice);
			Back = 	 (Button) Buttondialog.findViewById(R.id.btnCancel);
			Select = (Button) Buttondialog.findViewById(R.id.btnSelect);
			Change = (Button) Buttondialog.findViewById(R.id.btnChange);
			Delete = (Button)Buttondialog.findViewById(R.id.btnDelete);

			notice.setText(user.getName());
			Select.setOnClickListener(new OnClickListener() {

				public void onClick(View third) {			 																									
					GlobalData.getInstance().setIduser(user.getId());
					Intent myIntent = new Intent(third.getContext(),ListWord.class);
	                startActivityForResult(myIntent, 0);
					Buttondialog.hide(); 
			}
			});

			Change.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
			 		
					//Updatedialog.show();
					prepareUpdateDialog(user); 														
					Updatedialog.show();	
					Buttondialog.hide(); 
			}
			});

			Back.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {

					Buttondialog.hide();
				}
			});
			
			Delete.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
			 		
					datasource.deleteUser(user);
					listUser = datasource.getAllUser();
					refreshListAdapter();															
					
					Buttondialog.hide(); 
			}
			});
		}
	 
	 private void prepareUpdateDialog(final User userU) {
			Updatedialog  = new Dialog(ListUser.this);
			Updatedialog .setContentView(R.layout.save_user);
			
			
			
			LayoutParams UpdatedialogParams = Updatedialog .getWindow().getAttributes();
			UpdatedialogParams.width = LayoutParams.FILL_PARENT;
			Updatedialog .getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) UpdatedialogParams);

			user_name = (EditText) Updatedialog .findViewById(R.id.FormName);
			 

			Back = (Button) Updatedialog .findViewById(R.id.btnCancel);
			Save = (Button) Updatedialog .findViewById(R.id.btnSave);
			 

			Save.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
					 
			 		
					datasource.updateUser(userU,user_name.getText().toString());
					listUser = datasource.getAllUser();
					refreshListAdapter();
				
					Updatedialog.hide(); 
			}
			});

			Back.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {

					Updatedialog.hide();
				}
			});
		}
	 

}

	
	

