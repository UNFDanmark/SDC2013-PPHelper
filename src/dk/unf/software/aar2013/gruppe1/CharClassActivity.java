package dk.unf.software.aar2013.gruppe1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CharClassActivity extends Activity {

	public Character player;
	private Button part1;
	private Button part2;
	private Button dice2;
	private String race;
	private String classes;
	private String classLVL;
	private String weapon;
	private String skills;
	private String skillRank;
	private String language;
	private String alignment;
	private String gear1;
	private String gear2;
	private String gear3;
	private String name;
	private String pp;
	private String gp;
	private String sp;
	private String cp;
	private String spell1;
	private String spell2;
	private String spell3;
	private String spell4;
	private String spell5;
	private String spell6;
	private String spell7;
	private String spell8;
	private String spell9;
	private String spell10;
	private String strenght;
	private String dexterity;
	private String constitution;
	private String intelligence;
	private String wisdom;
	private String charisma;
	private String maxHP;
	private String currentHP;
	private String feat1;
	private String feat2;
	private String feat3;
	private String feat4;
	private String feat5;
	private String feat6;
	private String armorClass;
	private String touchAC;
	private String flatFootAC;
	private String initiative;
	private Spinner spinner1;
	private Spinner spinner2;
	private Spinner spinner3;
	private Spinner spinner4;
	private Spinner spinner5;
	private Spinner spinner6;
	private Spinner spinner7;
	private Spinner spinner8;
	private Spinner spinner9;
	private EditText nameText;
	private EditText classLVLText;
	private EditText skillRankText;
	private EditText ppText;
	private EditText gpText;
	private EditText spText;
	private EditText cpText;
	private EditText spell1Text;
	private EditText spell2Text;
	private EditText spell3Text;
	private EditText spell4Text;
	private EditText spell5Text;
	private EditText spell6Text;
	private EditText spell7Text;
	private EditText spell8Text;
	private EditText spell9Text;
	private EditText spell10Text;
	private EditText strenghtText;
	private EditText dexterityText;
	private EditText constitutionText;
	private EditText intelligenceText;
	private EditText wisdomText;
	private EditText charismaText;
	private EditText maxHPText;
	private EditText currentHPText;
	private EditText feat1Text;
	private EditText feat2Text;
	private EditText feat3Text;
	private EditText feat4Text;
	private EditText feat5Text;
	private EditText feat6Text;
	private EditText armorClassText;
	private EditText touchACText;
	private EditText flatFootACText;
	private EditText initiativeText;
	CharacterDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		player = new Character();
		changePage1();


	}

	public void saveCharacter1() {
		name = nameText.getText().toString();
		classLVL = classLVLText.getText().toString();
		skillRank = skillRankText.getText().toString();

		pp = ppText.getText().toString();
		gp = gpText.getText().toString();
		sp = spText.getText().toString();
		cp = cpText.getText().toString();
		player.setpName(name);
		player.setpRace(race);
		player.setpClass(classes);
		player.setpClassLVL(classLVL);
		player.setpWeapon(weapon);
		player.setpSkills(skills);
		player.setpSkillRank(skillRank);
		player.setpLanguage(language);
		player.setpAlignment(alignment);
		player.setpGear1(gear1);
		player.setpGear2(gear2);
		player.setpGear3(gear3);
		player.setpGoldPP(pp);
		player.setpGoldGP(gp);
		player.setpGoldSP(sp);
		player.setpGoldCP(cp);
	}

	public void saveCharacter2() {
		player.setpSpell1(spell1);
		player.setpSpell2(spell2);
		player.setpSpell3(spell3);
		player.setpSpell4(spell4);
		player.setpSpell5(spell5);
		player.setpSpell6(spell6);
		player.setpSpell7(spell7);
		player.setpSpell8(spell8);
		player.setpSpell9(spell9);
		player.setpSpell10(spell10);
		player.setpStrenght(strenght);
		player.setpDexterity(dexterity);
		player.setpConstitution(constitution);
		player.setpIntelligence(intelligence);
		player.setpWisdom(wisdom);
		player.setpCharisma(charisma);
		player.setpMaxHP(maxHP);
		player.setpCurrentHP(currentHP);
		player.setpFeat1(feat1);
		player.setpFeat2(feat2);
		player.setpFeat3(feat3);
		player.setpFeat4(feat4);
		player.setpFeat5(feat5);
		player.setpFeat6(feat6);
		player.setpArmorClass(armorClass);
		player.setpTouchAC(touchAC);
		player.setpFlatFootAC(flatFootAC);
		player.setpInitiative(initiative);
	}

	public void changePage1() {
		setContentView(R.layout.activity_main1);
		
		nameText = (EditText) findViewById(R.id.name);
		classLVLText = (EditText) findViewById(R.id.ClassLVL);
		skillRankText = (EditText) findViewById(R.id.skillRank);
		ppText = (EditText) findViewById(R.id.pp);
		gpText = (EditText) findViewById(R.id.gp);
		spText = (EditText) findViewById(R.id.sp);
		cpText = (EditText) findViewById(R.id.cp);


		spinner1 = (Spinner) findViewById(R.id.spinnerRace);
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				race = spinner1.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> raceStyle = ArrayAdapter.createFromResource(
				this, R.array.Races, R.layout.spinnerstyle);
		spinner1.setAdapter(raceStyle);

		spinner2 = (Spinner) findViewById(R.id.spinnerClasses);
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				classes = spinner2.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> classStyle = ArrayAdapter
				.createFromResource(this, R.array.Classes,
						R.layout.spinnerstyle);
		spinner2.setAdapter(classStyle);

		spinner3 = (Spinner) findViewById(R.id.spinnerWeapon);
		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				weapon = spinner3.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> weaponStyle = ArrayAdapter
				.createFromResource(this, R.array.Gear, R.layout.spinnerstyle);
		spinner3.setAdapter(weaponStyle);

		spinner4 = (Spinner) findViewById(R.id.spinnerSkills);
		spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				skills = spinner4.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> skillsStyle = ArrayAdapter
				.createFromResource(this, R.array.Skills, R.layout.spinnerstyle);
		spinner4.setAdapter(skillsStyle);

		spinner5 = (Spinner) findViewById(R.id.spinnerLanguage);
		spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				language = spinner5.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> languageStyle = ArrayAdapter
				.createFromResource(this, R.array.Language,
						R.layout.spinnerstyle);
		spinner5.setAdapter(languageStyle);

		spinner6 = (Spinner) findViewById(R.id.spinnerAlignment);
		spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				spinner6.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		alignment = spinner6.getSelectedItem().toString();
		ArrayAdapter<CharSequence> alignmentStyle = ArrayAdapter
				.createFromResource(this, R.array.Alignment,
						R.layout.spinnerstyle);
		spinner6.setAdapter(alignmentStyle);

		spinner7 = (Spinner) findViewById(R.id.spinnerGear1);
		spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				gear1 = spinner7.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> gear1Style = ArrayAdapter
				.createFromResource(this, R.array.Armor, R.layout.spinnerstyle);
		spinner7.setAdapter(gear1Style);

		spinner8 = (Spinner) findViewById(R.id.spinnerGear2);
		spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				gear2 = spinner8.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> gear2Style = ArrayAdapter
				.createFromResource(this, R.array.Shield, R.layout.spinnerstyle);
		spinner8.setAdapter(gear2Style);

		spinner9 = (Spinner) findViewById(R.id.spinnerGear3);
		spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				gear3 = spinner9.getSelectedItem().toString();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		ArrayAdapter<CharSequence> gear3Style = ArrayAdapter
				.createFromResource(this, R.array.Misc, R.layout.spinnerstyle);
		spinner9.setAdapter(gear3Style);

		part1 = (Button) findViewById(R.id.part1);
		part1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.part1:
					break;

				default:
					break;
				}
				saveCharacter1();
				changePage2();
			}
		});

	}

	public void changePage2() {
		setContentView(R.layout.activity_main2);
		part2 = (Button) findViewById(R.id.part2);
		part2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				saveCharacter2();
				changePage1();
			}
		});
		dice2 = (Button) findViewById(R.id.openDiceRoller2);
		dice2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(CharClassActivity.this,
						DiceRollActivity.class);
				switch (v.getId()) {
				case R.id.openDiceRoller2:

					if (spell1Text.getText().toString().equals("")||
							spell2Text.getText().toString().equals("")||
							spell3Text.getText().toString().equals("")||
							spell4Text.getText().toString().equals("")||
							spell5Text.getText().toString().equals("")||
							spell6Text.getText().toString().equals("")||
							spell7Text.getText().toString().equals("")||
							spell8Text.getText().toString().equals("")||
							spell9Text.getText().toString().equals("")||
							spell10Text.getText().toString().equals("")||
							strenghtText.getText().toString().equals("")||
							dexterityText.getText().toString().equals("")||
							constitutionText.getText().toString().equals("")||
							intelligenceText.getText().toString().equals("")||
							wisdomText.getText().toString().equals("")||
							charismaText.getText().toString().equals("")||
							maxHPText.getText().toString().equals("")||
							currentHPText.getText().toString().equals("")||
							feat1Text.getText().toString().equals("")||
							feat2Text.getText().toString().equals("")||
							feat3Text.getText().toString().equals("")||
							feat4Text.getText().toString().equals("")||
							feat5Text.getText().toString().equals("")||
							feat6Text.getText().toString().equals("")||
							armorClassText.getText().toString().equals("")||
							touchACText.getText().toString().equals("")||
							flatFootACText.getText().toString().equals("")||
							initiativeText.getText().toString().equals("")) {
						Toast.makeText(CharClassActivity.this, "Please add values..",
								Toast.LENGTH_LONG).show();
					} else {

						db = new CharacterDatabase(getApplicationContext());
						db.getWritableDatabase();
						saveCharacter2();
						db.addCharacter(player);
						Toast.makeText(CharClassActivity.this,
								"Character Added successfully.", Toast.LENGTH_LONG)
								.show();
					}
					break;

				default:
					break;
				}
				i.putExtra("name", player.getpName());
				startActivity(i);
			}
		});

		spell1Text = (EditText) findViewById(R.id.spell1);
		spell1 = spell1Text.getText().toString();
		spell2Text = (EditText) findViewById(R.id.spell2);
		spell2 = spell2Text.getText().toString();
		spell3Text = (EditText) findViewById(R.id.spell3);
		spell3 = spell3Text.getText().toString();
		spell4Text = (EditText) findViewById(R.id.spell4);
		spell4 = spell4Text.getText().toString();
		spell5Text = (EditText) findViewById(R.id.spell5);
		spell5 = spell5Text.getText().toString();
		spell6Text = (EditText) findViewById(R.id.spell6);
		spell6 = spell6Text.getText().toString();
		spell7Text = (EditText) findViewById(R.id.spell7);
		spell7 = spell7Text.getText().toString();
		spell8Text = (EditText) findViewById(R.id.spell8);
		spell8 = spell8Text.getText().toString();
		spell9Text = (EditText) findViewById(R.id.spell9);
		spell9 = spell9Text.getText().toString();
		spell10Text = (EditText) findViewById(R.id.spell10);
		spell10 = spell10Text.getText().toString();
		strenghtText = (EditText) findViewById(R.id.strenght);
		strenght = strenghtText.getText().toString();
		dexterityText = (EditText) findViewById(R.id.dexterity);
		dexterity = dexterityText.getText().toString();
		constitutionText = (EditText) findViewById(R.id.constitution);
		constitution = constitutionText.getText().toString();
		intelligenceText = (EditText) findViewById(R.id.intelligence);
		intelligence = intelligenceText.getText().toString();
		wisdomText = (EditText) findViewById(R.id.wisdom);
		wisdom = wisdomText.getText().toString();
		charismaText = (EditText) findViewById(R.id.charisma);
		charisma = charismaText.getText().toString();
		maxHPText = (EditText) findViewById(R.id.maxHP);
		maxHP = maxHPText.getText().toString();
		currentHPText = (EditText) findViewById(R.id.currentHP);
		currentHP = currentHPText.getText().toString();
		feat1Text = (EditText) findViewById(R.id.feat1);
		feat1 = feat1Text.getText().toString();
		feat2Text = (EditText) findViewById(R.id.feat2);
		feat2 = feat2Text.getText().toString();
		feat3Text = (EditText) findViewById(R.id.feat3);
		feat3 = feat3Text.getText().toString();
		feat4Text = (EditText) findViewById(R.id.feat4);
		feat4 = feat4Text.getText().toString();
		feat5Text = (EditText) findViewById(R.id.feat5);
		feat5 = feat5Text.getText().toString();
		feat6Text = (EditText) findViewById(R.id.feat6);
		feat6 = feat6Text.getText().toString();
		armorClassText = (EditText) findViewById(R.id.armorClass);
		armorClass = armorClassText.getText().toString();
		touchACText = (EditText) findViewById(R.id.touchAC);
		touchAC = touchACText.getText().toString();
		flatFootACText = (EditText) findViewById(R.id.flatFootAC);
		flatFootAC = flatFootACText.getText().toString();
		initiativeText = (EditText) findViewById(R.id.initiative);
		initiative = initiativeText.getText().toString();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}