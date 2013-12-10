package com.example.aci570_db;

import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aci570_db.db.MyAppDataSourceItem;
import com.example.aci570_db.listeners.ListViewItemClickListener2;
import com.example.aci570_db.model.Items;



public class Lista2 extends ListActivity {

	
	public static final int REQUEST_CODE_ADD_ITEMS = 1;
    public static final int REQUEST_CODE_UPDATE_ITEMS = 2;
    
    public static final String EXTRA_ITEMS = "e_items";
    public static final String EXTRA_REMOVE_ITEMS = "e_remove_items";

    private MyAppDataSourceItem ds2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lista2);
            
        	ds2 = new MyAppDataSourceItem(this);
            ds2.open();
    
     List<Items> values2 = ds2.getItem();
    
     // use the SimpleCursorAdapter to show the elements in a ListView
     ArrayAdapter<Items> adapter2 = new ArrayAdapter<Items>(
                     this,
                     android.R.layout.simple_list_item_1,
                     values2
             );
    
     this.setListAdapter(adapter2);
     

    
     ListView lv2 = (ListView) this.findViewById(android.R.id.list);
     lv2.setOnItemClickListener(new ListViewItemClickListener2(this));
    }
       
            
            
     
            
    
    
    
    @Override
    protected void onActivityResult(int requestCode2, int resultCode2, Intent data2) {
            super.onActivityResult(requestCode2, resultCode2, data2);
            
            if(data2.hasExtra(EXTRA_ITEMS))
            {
                    List<Items> values2 = ds2.getItem();
            
             // use the SimpleCursorAdapter to show the elements in a ListView
             ArrayAdapter<Items> adapter2 = new ArrayAdapter<Items>(
                             this,
                             android.R.layout.simple_list_item_1,
                             values2
                     );
            
             ListView lv2 = (ListView) this.findViewById(android.R.id.list);
             lv2.setAdapter(adapter2);
            
                    if(requestCode2 == REQUEST_CODE_ADD_ITEMS) {
                            // do something here when a person is added
                    }
                    else if(requestCode2 == REQUEST_CODE_UPDATE_ITEMS)
                    {
                            Boolean remove2 = data2.getBooleanExtra(EXTRA_REMOVE_ITEMS, false);
                            
                            if(remove2) {
                                    // do something here when a person is removed
                            }
                            else {
                                    // do something here when a person is updated
                            }
                    }
                    adapter2.notifyDataSetChanged();
            }
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
    }
    
    public void onAddItemClick2(View view) {
            Intent i = new Intent(this, ListaItem.class);
            this.startActivityForResult(i, REQUEST_CODE_ADD_ITEMS);
    }
	
	
	
	
    
	public void onBackClick(View view) {
		Intent i = new Intent(this, MainActivity.class);
		this.startActivity(i);
 
		
	}	
	
	
	
}
