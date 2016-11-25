package dk.unf.software.aar2013.gruppe1;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomizedSpinnerAdapter extends ArrayAdapter<String> {

	 private Activity context;
	 String[] data = null;

	 public CustomizedSpinnerAdapter(Activity context, int resource, String[] data2)
	 {
	     super(context, resource, data2);
	     this.context = context;
	     this.data = data2;
	 }


	 @Override
	 public View getDropDownView(int position, View convertView, ViewGroup parent)
	 {   
	     View row = convertView;
	     if(row == null)
	     {
	         //inflate your customlayout for the textview
	         LayoutInflater inflater = context.getLayoutInflater();
	         row = inflater.inflate(R.layout.spinnerstyle, parent, false);
	     }
	    

	     return row;
	 }
	
	}