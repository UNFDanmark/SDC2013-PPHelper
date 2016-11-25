package dk.unf.software.aar2013.gruppe1;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LoadCharacter extends Activity {

	private ListView listview;
	TextView totalrecords;
	CharacterDatabase db;
	public ArrayList<Character> charlist = new ArrayList<Character>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loadchar);
		listview = (ListView) findViewById(R.id.listView1);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		charlist.clear();

		db = new CharacterDatabase(getApplicationContext());
		db.getWritableDatabase();
		ArrayList<Character> char_list = db.getCharacters();

		for (int i = 0; i < char_list.size(); i++) {

			String tname = char_list.get(i).getpName();
			String trace = char_list.get(i).getpRace();
			String tclass = char_list.get(i).getpClass();
		
			Character character = new Character();

			character.setpName(tname);
			character.setpRace(trace);
			character.setpClass(tclass);

			charlist.add(character);
		}
		listview.setAdapter(new ListAdapter(this));
		db.close();

	}

	private class ListAdapter extends BaseAdapter {
		LayoutInflater inflater;
		ViewHolder viewHolder;

		public ListAdapter(Context context) {
			// TODO Auto-generated constructor stub
			inflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return charlist.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {

				convertView = inflater.inflate(R.layout.activity_selectloadcharlayout, null);
				viewHolder = new ViewHolder();

				viewHolder.txt_name = (TextView) convertView
						.findViewById(R.id.charName);
				viewHolder.txt_race = (TextView) convertView
						.findViewById(R.id.charRace1);

				viewHolder.txt_class = (TextView) convertView
						.findViewById(R.id.charClass1);
				convertView.setTag(viewHolder);

			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}

			viewHolder.txt_name.setText(charlist.get(position)
					.getpName().trim());
			viewHolder.txt_race.setText(charlist.get(position)
					.getpRace().trim());

			viewHolder.txt_class.setText(charlist.get(position).getpClass()
					.trim());

			final int temp = position;
			(convertView.findViewById(R.id.loadCharacter2))
					.setOnClickListener(new OnClickListener() {

						public void onClick(View arg0) {

							Intent i = new Intent(LoadCharacter.this, DiceRollActivity.class);//Her skal I starte dice activity eller hvor I nu ekllers vil starte spillet når man har valgt spiller.
							i.putExtra("name", charlist.get(position).getpName());
							startActivity(i);
						}
					});

			// for delete record we no need to create class we just call
			// removeProduct() method of DatabaseHelper like following.

			(convertView.findViewById(R.id.deleteCharacter2))
					.setOnClickListener(new OnClickListener() {

						public void onClick(View arg0) {

							AlertDialog.Builder alertbox = new AlertDialog.Builder(
									LoadCharacter.this);
							alertbox.setCancelable(true);
							alertbox.setMessage("Are you sure you want to delete ?");
							alertbox.setPositiveButton("Yes",
									new DialogInterface.OnClickListener() {

										public void onClick(
												DialogInterface arg0, int arg1) {

											db.removeCharacter(charlist.get(temp).getpName());

											LoadCharacter.this.onResume();

											Toast.makeText(
													getApplicationContext(),
													"Character Deleted...",
													Toast.LENGTH_SHORT).show();

										}

									});
							alertbox.setNegativeButton("No",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface arg0, int arg1) {

										}
									});
							alertbox.show();
						}
					});
			return convertView;

		}
	}

	private class ViewHolder {
		TextView txt_name;
		TextView txt_race;
		TextView txt_class;

	}

}