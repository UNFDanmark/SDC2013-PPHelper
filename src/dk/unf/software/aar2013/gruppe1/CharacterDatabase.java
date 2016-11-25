package dk.unf.software.aar2013.gruppe1;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CharacterDatabase extends SQLiteOpenHelper {

    public static String DATABASENAME = "characterDatabase";  // our database Name

    public static String TABLE = "character";                    //table name

    private ArrayList<Character> charList = new ArrayList<Character>();
    Context c;


  //constructor
    public CharacterDatabase(Context context) {
        super(context, DATABASENAME, null, 33);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE if not exists chartable(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "pName"
                + " TEXT ,"
                + "pRace"
                + " TEXT,"
                + "pClass"
                + " TEXT,"
                + "pWeapon"
                + " TEXT,"
                + "pSkills"
                + " TEXT,"
                + "pSkillRank"
                + " TEXT,"
                + "pLanguage"
                + " TEXT,"
                + "pAlignment"
                + " TEXT,"
                + "pGear1"
                + " TEXT,"
                + "pGear2"
                + " TEXT,"
                + "pGear3"
                + " TEXT,"
                + "pGoldPP"
                + " TEXT,"
                + "pGoldGP"
                + " TEXT,"
                + "pGoldSP"
                + " TEXT,"
                + "pGoldCP"
                + " TEXT,"
                + "pSpell1"
                + " TEXT,"
                + "pSpell2"
                + " TEXT,"
                + "pSpell3"
                + " TEXT,"
                + "pSpell4"
                + " TEXT,"
                + "pSpell5"
                + " TEXT,"
                + "pSpell6"
                + " TEXT,"
                + "pSpell7"
                + " TEXT,"
                + "pSpell8"
                + " TEXT,"
                + "pSpell9"
                + " TEXT,"
                + "pSpell10"
                + " TEXT,"
                + "pStrenght"
                + " TEXT,"
                + "pDexterity"
                + " TEXT,"
                + "pConstitution"
                + " TEXT,"
                + "pIntelligence"
                + " TEXT,"
                + "pWisdom"
                + " TEXT,"
                + "pCharisma"
                + " TEXT,"
                + "pMaxHP"
                + " TEXT,"
                + "pCurrentHP"
                + " TEXT,"
                + "pFeat1"
                + " TEXT,"
                + "pFeat2"
                + " TEXT,"
                + "pFeat3"
                + " TEXT,"
                + "pFeat4"
                + " TEXT,"
                + "pFeat5"
                + " TEXT,"
                + "pFeat6"
                + " TEXT,"
                + "pArmorClass"
                + " TEXT,"
                + "pTouchAC"
                + " TEXT,"
                + "pFlatFootAC"
                + " TEXT,"
                + "pInitiative"
        		+ " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(db);
    }

  //Add record
    public void addCharacter(Character player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pName", player.getpName());
        contentValues.put("pRace", player.getpRace());
        contentValues.put("pClass", player.getpClass());
        contentValues.put("pWeapon", player.getpWeapon());
        contentValues.put("pSkills", player.getpSkills());
        contentValues.put("pSkillRank", player.getpSkillRank());
        contentValues.put("pLanguage", player.getpLanguage());
        contentValues.put("pAlignment", player.getpAlignment());
        contentValues.put("pGear1", player.getpGear1());
        contentValues.put("pGear2", player.getpGear2());
        contentValues.put("pGear3", player.getpGear3());
        contentValues.put("pGoldPP", player.getpGoldPP());
        contentValues.put("pGoldGP", player.getpGoldGP());
        contentValues.put("pGoldSP", player.getpGoldSP());
        contentValues.put("pGoldCP", player.getpGoldCP());
        contentValues.put("pSpell1", player.getpSpell1());
        contentValues.put("pSpell2", player.getpSpell2());
        contentValues.put("pSpell3", player.getpSpell3());
        contentValues.put("pSpell4", player.getpSpell4());
        contentValues.put("pSpell5", player.getpSpell5());
        contentValues.put("pSpell6", player.getpSpell6());
        contentValues.put("pSpell7", player.getpSpell7());
        contentValues.put("pSpell8", player.getpSpell8());
        contentValues.put("pSpell9", player.getpSpell9());
        contentValues.put("pSpell10", player.getpSpell10());
        contentValues.put("pStrenght", player.getpStrenght());
        contentValues.put("pDexterity", player.getpDexterity());
        contentValues.put("pConstitution", player.getpConstitution());
        contentValues.put("pIntelligence", player.getpIntelligence());
        contentValues.put("pWisdom", player.getpWisdom());
        contentValues.put("pCharisma", player.getpCharisma());
        contentValues.put("pCurrentHP", player.getpCurrentHP());
        contentValues.put("pFeat1", player.getpFeat1());
        contentValues.put("pFeat2", player.getpFeat2());
        contentValues.put("pFeat3", player.getpFeat3());
        contentValues.put("pFeat4", player.getpFeat4());
        contentValues.put("pFeat5", player.getpFeat5());
        contentValues.put("pFeat6", player.getpFeat6());
        contentValues.put("pArmorClass", player.getpArmorClass());
        contentValues.put("pTouchAC", player.getpTouchAC());
        contentValues.put("pFlatFootAC", player.getpFlatFootAC());
        contentValues.put("pInitiative", player.getpInitiative());
        db.insert("chartable", null, contentValues);
        db.close();
    }

 //update record
    public void updateCharacter(Character player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pName", player.getpName());
        contentValues.put("pRace", player.getpRace());
        contentValues.put("pClass", player.getpClass());
        contentValues.put("pWeapon", player.getpWeapon());
        contentValues.put("pSkills", player.getpSkills());
        contentValues.put("pSkillRank", player.getpSkillRank());
        contentValues.put("pLanguage", player.getpLanguage());
        contentValues.put("pAlignment", player.getpAlignment());
        contentValues.put("pGear1", player.getpGear1());
        contentValues.put("pGear2", player.getpGear2());
        contentValues.put("pGear3", player.getpGear3());
        contentValues.put("pGoldPP", player.getpGoldPP());
        contentValues.put("pGoldGP", player.getpGoldGP());
        contentValues.put("pGoldSP", player.getpGoldSP());
        contentValues.put("pGoldCP", player.getpGoldCP());
        contentValues.put("pSpell1", player.getpSpell1());
        contentValues.put("pSpell2", player.getpSpell2());
        contentValues.put("pSpell3", player.getpSpell3());
        contentValues.put("pSpell4", player.getpSpell4());
        contentValues.put("pSpell5", player.getpSpell5());
        contentValues.put("pSpell6", player.getpSpell6());
        contentValues.put("pSpell7", player.getpSpell7());
        contentValues.put("pSpell8", player.getpSpell8());
        contentValues.put("pSpell9", player.getpSpell9());
        contentValues.put("pSpell10", player.getpSpell10());
        contentValues.put("pStrenght", player.getpStrenght());
        contentValues.put("pDexterity", player.getpDexterity());
        contentValues.put("pConstitution", player.getpConstitution());
        contentValues.put("pIntelligence", player.getpIntelligence());
        contentValues.put("pWisdom", player.getpWisdom());
        contentValues.put("pCharisma", player.getpCharisma());
        contentValues.put("pMaxHP", player.getpMaxHP());
        contentValues.put("pCurrentHP", player.getpCurrentHP());
        contentValues.put("pFeat1", player.getpFeat1());
        contentValues.put("pFeat2", player.getpFeat2());
        contentValues.put("pFeat3", player.getpFeat3());
        contentValues.put("pFeat4", player.getpFeat4());
        contentValues.put("pFeat5", player.getpFeat5());
        contentValues.put("pFeat6", player.getpFeat6());
        contentValues.put("pArmorClass", player.getpArmorClass());
        contentValues.put("pTouchAC", player.getpTouchAC());
        contentValues.put("pFlatFootAC", player.getpFlatFootAC());
        contentValues.put("pInitiative", player.getpInitiative());

        db.update("chartable", contentValues, "pName=?", new String[]{String.valueOf(player.getpName())});
        db.close();
    }

  // delete entire data from table
    public void emptyCharacter() {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from chartable");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  // remove specific record from table
    public void removeCharacter(String name) {
        try {
            String[] args = { name };
            getWritableDatabase().delete("chartable", "pName=?", args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  // get all products from database
    public ArrayList<Character> getCharacters() {

    	charList.clear();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from chartable", null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                	Character item = new Character();

                    item.setpName(cursor.getString(cursor
                            .getColumnIndex("pName")));
                    item.setpRace( cursor.getString(cursor
                            .getColumnIndex("pRace"))) ;
                    item.setpClass(cursor.getString(cursor
                            .getColumnIndex("pClass")));
                    item.setpWeapon(cursor.getString(cursor
                            .getColumnIndex("pWeapon")));
                    item.setpSkills(cursor.getString(cursor
                            .getColumnIndex("pSkills")));
                    item.setpSkillRank(cursor.getString(cursor
                            .getColumnIndex("pSkillRank")));
                    item.setpLanguage(cursor.getString(cursor
                            .getColumnIndex("pLanguage")));
                    item.setpAlignment(cursor.getString(cursor
                            .getColumnIndex("pAlignment")));
                    item.setpGear1(cursor.getString(cursor
                            .getColumnIndex("pGear1")));
                    item.setpGear2( cursor.getString(cursor
                            .getColumnIndex("pGear2")));
                    item.setpGoldCP(cursor.getString(cursor
                            .getColumnIndex("pGear3")));
                    item.setpGoldPP(cursor.getString(cursor
                            .getColumnIndex("pGoldPP")));
                    item.setpGoldGP(cursor.getString(cursor
                            .getColumnIndex("pGoldGP")));
                    item.setpGoldSP(cursor.getString(cursor
                            .getColumnIndex("pGoldSP")));
                    item.setpGoldCP(cursor.getString(cursor
                            .getColumnIndex("pGoldCP")));
                    item.setpSpell1(cursor.getString(cursor
                            .getColumnIndex("pSpell1")));
                    item.setpSpell2(cursor.getString(cursor
                            .getColumnIndex("pSpell2")));
                    item.setpSpell3(cursor.getString(cursor
                            .getColumnIndex("pSpell3")));
                    item.setpSpell4(cursor.getString(cursor
                            .getColumnIndex("pSpell4")));
                    item.setpSpell5(cursor.getString(cursor
                            .getColumnIndex("pSpell5")));
                    item.setpSpell6(cursor.getString(cursor
                            .getColumnIndex("pSpell6")));
                    item.setpSpell7(cursor.getString(cursor
                            .getColumnIndex("pSpell7")));
                    item.setpSpell8(cursor.getString(cursor
                            .getColumnIndex("pSpell8")));
                    item.setpSpell9(cursor.getString(cursor
                            .getColumnIndex("pSpell9")));
                    item.setpSpell10(cursor.getString(cursor
                            .getColumnIndex("pSpell10")));
                    item.setpStrenght(cursor.getString(cursor
                            .getColumnIndex("pStrenght")));
                    item.setpDexterity(cursor.getString(cursor
                            .getColumnIndex("pDexterity")));
                    item.setpConstitution(cursor.getString(cursor
                            .getColumnIndex("pConstitution")));
                    item.setpIntelligence(cursor.getString(cursor
                            .getColumnIndex("pIntelligence")));
                    item.setpWisdom(cursor.getString(cursor
                            .getColumnIndex("pWisdom")));
                    item.setpCharisma(cursor.getString(cursor
                            .getColumnIndex("pCharisma")));
                    item.setpMaxHP(cursor.getString(cursor
                            .getColumnIndex("pMaxHP")));
                    item.setpCurrentHP(cursor.getString(cursor
                            .getColumnIndex("pCurrentHP")));
                    item.setpFeat1(cursor.getString(cursor
                            .getColumnIndex("pFeat1")));
                    item.setpFeat2(cursor.getString(cursor
                            .getColumnIndex("pFeat2")));
                    item.setpFeat3(cursor.getString(cursor
                            .getColumnIndex("pFeat3")));
                    item.setpFeat4(cursor.getString(cursor
                            .getColumnIndex("pFeat4")));
                    item.setpFeat5(cursor.getString(cursor
                            .getColumnIndex("pFeat5")));
                    item.setpFeat6(cursor.getString(cursor
                            .getColumnIndex("pFeat6")));
                    item.setpArmorClass(cursor.getString(cursor
                            .getColumnIndex("pArmorClass")));
                    item.setpTouchAC(cursor.getString(cursor
                            .getColumnIndex("pTouchAC")));
                    item.setpFlatFootAC(cursor.getString(cursor
                            .getColumnIndex("pFlatFootAC")));
                    item.setpInitiative(cursor.getString(cursor
                            .getColumnIndex("pInitiative")));
                    

                    charList.add(item);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return charList;
    }
}