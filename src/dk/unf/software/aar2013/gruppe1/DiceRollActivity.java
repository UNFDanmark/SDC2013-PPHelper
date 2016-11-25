package dk.unf.software.aar2013.gruppe1;

import java.util.ArrayList;
import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DiceRollActivity extends Activity {
	Random rand = new Random();
	Button terningKast;
	int dx = 20;
	int dice = 0;
	int resultatet;
	int diceAntal = 1;
	int willStat = 0;
	Button up;
	Button down;
	TextView terningType;
	TextView terningKastet;
	Button DiceUp;
	Button DiceDown;
	TextView AntalDice;
	TextView resultDiceType;
	TextView resultThrows;
	TextView resultMiscMod;
	EditText MiscModifier;
	int MiscMod = 0;
	CharacterDatabase db;
	public ArrayList<Character> charlist = new ArrayList<Character>();
	Character main;
	private Button melee;
	private Button will;
	double willSafe;
	TextView actionBonus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dice_roll);
		terningType = (TextView) findViewById(R.id.terningType);
		resultDiceType = (TextView) findViewById(R.id.resultType);
		resultThrows = (TextView) findViewById(R.id.resultThrows);
		resultMiscMod = (TextView) findViewById(R.id.resultMiscMod);
		terningKastet = (TextView) findViewById(R.id.result);
		AntalDice = (TextView) findViewById(R.id.AntalDice);
	    MiscModifier = (EditText) findViewById(R.id.miscMod);
		terningKast = (Button) findViewById(R.id.terningKast);
		down = (Button) findViewById(R.id.down);
		up = (Button) findViewById(R.id.up);
		DiceUp = (Button) findViewById(R.id.DiceUp);
		DiceDown = (Button) findViewById(R.id.DiceDown);
		actionBonus = (TextView) findViewById(R.id.actionBonus);
		
		db = new CharacterDatabase(getApplicationContext());
		db.getWritableDatabase();
		ArrayList<Character> char_list = db.getCharacters();
		db.close();
		main = new Character();
		
		String intentName = getIntent().getExtras().getString("name");
		
		for(int i = 0; i < char_list.size(); i++) {
			if(char_list.get(i).getpName().equals(intentName)) {
				main = char_list.get(i);
			}
		}
		
		melee = (Button)findViewById(R.id.meleeDice);
		melee.setText(main.getpWeapon());
		
		melee.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		
		will = (Button)findViewById(R.id.willDice);
		will.setText(main.getpWeapon());
		
		willSafe = (Integer.parseInt(main.getpClassLVL())/3);
		
		will.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(main.getpClass().equals("Barbarian")){
					willStat = (int) (willStat + willSafe);
					actionBonus.setText("                                                  Action Bonus: " + willStat);
				}
				
			}
		});
		
		up.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (dx < 100) {
					dx++;
					if (dx == 5)
						dx = 6;
					if (dx == 7)
						dx = 8;
					if (dx == 9)
						dx = 10;
					if (dx == 11)
						dx = 12;
					if (dx > 12 && dx < 20)
						dx = 20;
					if (dx > 20 && dx < 100)
						dx = 100;
					terningType.setText("Dice Type: " + dx);
					resultDiceType.setText("Dice Type: D" + dx + "          * ");
				}
			}

		});

		down.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (dx > 2) {
					dx--;
					if (dx == 5)
						dx = 4;
					if (dx == 7)
						dx = 6;
					if (dx == 9)
						dx = 8;
					if (dx == 11)
						dx = 10;
					if (dx > 12 && dx < 20)
						dx = 12;
					if (dx > 20 && dx < 100)
						dx = 20;
					terningType.setText("Dice Type: " + dx);
					resultDiceType.setText("Dice Type: D" + dx + "          * ");
				}
			}
		});
		terningKast.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				diceRoll();
				terningKastet.setText("                Result: " + resultatet);
			}
		});
		DiceDown.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (diceAntal > 1)
					diceAntal--;
				AntalDice.setText("Throws: " + diceAntal);
				resultThrows.setText("Throws: " + diceAntal + "    +");
			}
		});

		DiceUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (diceAntal < 40)
					diceAntal++;
				AntalDice.setText("Throws: " + diceAntal);
				resultThrows.setText("Throws: " + diceAntal + "    +");
			}
		});
	}

	private void diceRoll() {
		dice = 0;
			try {
				MiscMod = Integer.parseInt(MiscModifier.getText().toString());
			} catch (NumberFormatException e) {
				MiscMod = 0;
			}
			resultMiscMod.setText("Misc Mod: " + MiscMod + "      =");
		resultatet = 0 + MiscMod + willStat;
		for (int i = 0; i < diceAntal; i++) {
			dice = rand.nextInt(dx) + 1;
			resultatet = resultatet + dice;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.dice_roll, menu);
		return true;
	}
	
}
