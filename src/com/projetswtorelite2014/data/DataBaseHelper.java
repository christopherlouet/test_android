package com.projetswtorelite2014.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.projetswtorelite2014.data.dao.ComponentDao;
import com.projetswtorelite2014.data.dao.ComponentRankDao;
import com.projetswtorelite2014.data.dao.ComponentTypeDao;
import com.projetswtorelite2014.data.dao.RarityDao;
import com.projetswtorelite2014.data.dao.SkillDao;
import com.projetswtorelite2014.data.dao.SkillTypeDao;

/**
 * @author Axel
 * Class to create the database
 */

public class DataBaseHelper extends SQLiteOpenHelper {

	// Version base de donnees
	public static final int DATABASE_VERSION = 1;

	// Nom base de donnees
	public static final String DATABASE_NAME = "swtorelite";

	// Requetes création base
	private static final String CREATE_TABLE_SKILL = "CREATE TABLE " 
			+ SkillDao.TABLE_SKILL + " ("
			+ SkillDao.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ SkillDao.COL_CRAFT_SKILL_TYPE + " INTEGER NOT NULL, "
			+ SkillDao.COL_NAME + " TEXT NOT NULL);";

	private static final String CREATE_TABLE_SKILL_TYPE = "CREATE TABLE " 
			+ SkillTypeDao.TABLE_SKILL_TYPE + " ("
			+ SkillTypeDao.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ SkillTypeDao.COL_NAME + " TEXT NOT NULL);";

	private static final String CREATE_TABLE_RARITY = "CREATE TABLE " 
			+ RarityDao.TABLE_RARITY + " ("
			+ RarityDao.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ RarityDao.COL_NAME + " TEXT NOT NULL);";

	private static final String CREATE_TABLE_COMPONENTYPE = "CREATE TABLE " 
			+ ComponentTypeDao.TABLE_COMPONENT_TYPE + " ("
			+ ComponentTypeDao.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ComponentTypeDao.COL_NAME + " TEXT NOT NULL);";

	private static final String CREATE_TABLE_COMPONENTRANK = "CREATE TABLE " 
			+ ComponentRankDao.TABLE_COMPONENT_RANK + " ("
			+ ComponentRankDao.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ComponentRankDao.COL_RANK + " INTEGER NOT NULL);";

	private static final String CREATE_TABLE_COMPONENT = "CREATE TABLE " 
			+ ComponentDao.TABLE_COMPONENT + " ("
			+ ComponentDao.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ComponentDao.COL_COMPONENT_RANK + " INTEGER NOT NULL, "
			+ ComponentDao.COL_COMPONENT_TYPE + " INTEGER NOT NULL, "
			+ ComponentDao.COL_NAME + " TEXT NOT NULL, "
			+ ComponentDao.COL_RARITY + " TEXT NOT NULL);";

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_SKILL);
		db.execSQL(CREATE_TABLE_SKILL_TYPE);
		db.execSQL(CREATE_TABLE_RARITY);
		db.execSQL(CREATE_TABLE_COMPONENTYPE);
		db.execSQL(CREATE_TABLE_COMPONENTRANK);
		db.execSQL(CREATE_TABLE_COMPONENT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE " + SkillDao.TABLE_SKILL + ";");
		db.execSQL("DROP TABLE " + SkillTypeDao.TABLE_SKILL_TYPE + ";");
		db.execSQL("DROP TABLE " + RarityDao.TABLE_RARITY + ";");
		db.execSQL("DROP TABLE " + ComponentTypeDao.TABLE_COMPONENT_TYPE + ";");
		db.execSQL("DROP TABLE " + ComponentRankDao.TABLE_COMPONENT_RANK + ";");
		db.execSQL("DROP TABLE " + ComponentDao.TABLE_COMPONENT + ";");
		onCreate(db);
	}

}
