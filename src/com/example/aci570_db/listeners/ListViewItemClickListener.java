package com.example.aci570_db.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.aci570_db.Lista2;

import com.example.aci570_db.model.Person;

public class ListViewItemClickListener implements AdapterView.OnItemClickListener {

	private Activity activity;
	
	public ListViewItemClickListener(Activity activity) {
		this.activity = activity;
	}
	
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Person p = (Person) parent.getItemAtPosition(position);
		
		if(p != null)
		{
			Intent i = new Intent(this.activity, Lista2.class);
			this.activity.startActivity(i);			
		}
		
			
	}
}
