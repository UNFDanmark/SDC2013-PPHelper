package dk.unf.software.aar2013.gruppe1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity {

	Button createCharacter;
	Button loadCharacter;
	Button settings;
	Button diceRoller;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		createCharacter = (Button) findViewById(R.id.createCharacter);
		loadCharacter = (Button) findViewById(R.id.loadCharacter);
		settings = (Button) findViewById(R.id.settings);
		diceRoller = (Button) findViewById(R.id.diceRoller);
		
		createCharacter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent createChar = new Intent(MainMenuActivity.this,CharClassActivity.class);
				startActivity(createChar);
			}
		});
		loadCharacter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent loadChar = new Intent(MainMenuActivity.this,LoadCharacter.class);
				startActivity(loadChar);
			}
		});
			diceRoller.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent diceRoller = new Intent(MainMenuActivity.this,DiceRollActivity.class);
					startActivity(diceRoller);
				}
			});
			/*settings.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent settings = new Intent(MainMenuActivity.this,Placeholder.class);
					startActivity(settings);
					
				} 
			};*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
