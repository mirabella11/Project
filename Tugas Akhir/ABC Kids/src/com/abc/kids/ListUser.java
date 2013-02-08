package com.abc.kids;


import java.util.List;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class ListUser extends ListActivity {
	
	
	private UserDataSource datasource;
	private Button add;
	private Button Back,Save,Change,Select,Delete;
	private TextView notice,Attention;
	private Dialog formdialog, Buttondialog,Updatedialog;
	private EditText user_name;
	private List<User> listUser = null;
	
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.choose_user);
	       
	       
	         datasource = new UserDataSource(this);
	         datasource.open();
	         
	         add = (Button) findViewById(R.id.add);
	         
	         if(GlobalData.getInstance().lng==0){
		        	add.setText("Add New");
		        	 
		        	
		        }else{
		        	add.setText("Tambah Baru");
		        	 
		        }   
		        
	         List<User> values = datasource.getAllUser();
 
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
		    
		    User o = (User) l.getItemAtPosition(position);
		    String keyword =  o.getName();
		     
		    prepareButtonDialog(o);
		    Buttondialog.show();
		   
		  }
	

	 private void prepareFormDialog() {
		 formdialog = new Dialog(ListUser.this);
			formdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			formdialog.setContentView(R.layout.save_user);
			
			

			LayoutParams formDialogParams = formdialog.getWindow().getAttributes();
			formDialogParams.width = LayoutParams.WRAP_CONTENT;
			formDialogParams.height = LayoutParams.WRAP_CONTENT;
			formdialog.getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) formDialogParams);

			user_name = (EditText) formdialog.findViewById(R.id.FormName);
			 

			Back = (Button) formdialog.findViewById(R.id.btnCancel);
			Save = (Button) formdialog.findViewById(R.id.btnSave);
			notice = (TextView) formdialog.findViewById(R.id.notice);
			Attention = (TextView) formdialog.findViewById(R.id.warning);
			
			 if(GlobalData.getInstance().lng==0){
		        	notice.setText("Input your name");
		        }else{
		        	notice.setText("Masukkan nama kamu");
		        }   
		        
		        

			Save.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
					String check = user_name.getText().toString();
			 		if (check.matches("")){
			 			Attention.setText("Please Fill The Username");
			 			if(GlobalData.getInstance().lng==1){
			 				Attention.setText("Masukkan Nama User Terlebih Dahulu");
						}
			 		return;
			 		} else {
					datasource.createUser(user_name.getText().toString());
					
					listUser = datasource.getAllUser();
					refreshListAdapter();
					formdialog.hide(); 
			 		}
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
			Buttondialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			
			Buttondialog.setContentView(R.layout.button_choice);
			
			
			LayoutParams ButtonDialogParams = Buttondialog.getWindow().getAttributes();
			ButtonDialogParams.width = LayoutParams.WRAP_CONTENT;
			ButtonDialogParams.height= LayoutParams.WRAP_CONTENT;
			
			Buttondialog.getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) ButtonDialogParams);					    
		    
				    
			notice = (TextView) Buttondialog.findViewById(R.id.notice);
			Back = 	 (Button) Buttondialog.findViewById(R.id.btnCancel);
			Select = (Button) Buttondialog.findViewById(R.id.btnSelect);
			Change = (Button) Buttondialog.findViewById(R.id.btnChange);
			Delete = (Button)Buttondialog.findViewById(R.id.btnDelete);
			
			
			String question="Are you ";
			if(GlobalData.getInstance().lng==1){
				question="Apa kamu adalah ";
			}
			notice.setText(question+user.getName()+" ?");
			Select.setOnClickListener(new OnClickListener() {

				public void onClick(View third) {			 																									
					GlobalData.getInstance().setIduser(user.getId());
					Intent myIntent = new Intent(third.getContext(),FirstChoice.class);
	                startActivityForResult(myIntent, 0);
					Buttondialog.hide(); 
					}
			});

			Change.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
			 		
					
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
			Updatedialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			Updatedialog.setContentView(R.layout.save_user);
						
			LayoutParams UpdateDialogParams = Updatedialog .getWindow().getAttributes();
			UpdateDialogParams.width = LayoutParams.WRAP_CONTENT;
			UpdateDialogParams.height = LayoutParams.WRAP_CONTENT;
			Updatedialog .getWindow().setAttributes(
					(android.view.WindowManager.LayoutParams) UpdateDialogParams);

			user_name = (EditText) Updatedialog .findViewById(R.id.FormName);
			Attention = (TextView) Updatedialog .findViewById(R.id.alert);
			notice = (TextView) formdialog.findViewById(R.id.notice);
			Back = (Button) Updatedialog .findViewById(R.id.btnCancel);
			Save = (Button) Updatedialog .findViewById(R.id.btnSave);
			 
			if(GlobalData.getInstance().lng==0){
	        	notice.setText("Input your name");
	        }else{
	        	notice.setText("Masukkan nama kamu");
	        }   
			Save.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
					String check = user_name.getText().toString();
			 		if (check.matches("")){
			 			Attention.setText("Please Fill The Username");
			 			if(GlobalData.getInstance().lng==1){
			 				Attention.setText("Masukkan Nama User Terlebih Dahulu");
						}
			 		return;
			 		} else {
			 		
					datasource.updateUser(userU,user_name.getText().toString());
					listUser = datasource.getAllUser();
					refreshListAdapter();
				
					Updatedialog.hide(); 
						}
				}
			});

			Back.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {

					Updatedialog.hide();
						}
			});
		}
	 

}

	
	

