package com.abc.kids;
 
 


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

 
 
public class InputData  extends Activity {
	private EditText name =null;
	
	private Button Save = null;
	private Button Add = null;

	 
	private UserDBAdapter adapter= null;

	private DatabaseAdapter userDb = null;
	 
	
	private Dialog formDialog = null;
	 
		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.menu_data_ind);
		        
		       name = (EditText) findViewById(R.id.name);
		       
		        
		        Button submit = (Button) findViewById(R.id.save);
		        submit.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View third) {
		            	Intent myIntent = new Intent(third.getContext(),FirstChoice.class);
		                startActivityForResult(myIntent, 0);
		                
	        //   User user = userDb.get(Name.getName().toString());
			/*			if (book != null) {
							book.setJudul(Judul.getText().toString());
							book.setNamaPenulis(Nama.getText().toString());
							bukuDb.update(book);
						} else {
							book = new Buku();
							book.setISBN(ISBN.getText().toString());
							book.setJudul(Judul.getText().toString());
							book.setNamaPenulis(Nama.getText().toString());

							bukuDb.insert(book);
						}
						listBukuu = bukuDb.toArray();
						refreshListAdapter();
						formDialog.hide();
					}
				});*/
	                }

		        });
		        
	 
		    }
		}




			 
				 


