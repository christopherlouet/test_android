package com.projetswtorelite2014.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.projetswtorelite2014.data.DataBaseHelper;
import com.projetswtorelite2014.model.SkillType;

/**
 * @author User
 * Class to create the Skill Type table into the database
 */
public class SkillTypeDao {
	
	public SQLiteDatabase dataBase;
	public DataBaseHelper helper;

	// Nom de la table
	public static final String TABLE_SKILL_TYPE = "table_skill_type";

	// Colonnes de la table
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "Name";

	public SkillTypeDao(Context context) {
		helper = new DataBaseHelper(context);
		open();
	}

	public void open() throws SQLException {
		dataBase = helper.getWritableDatabase();
	}

	public void close() {
		helper.close();
	}

		/**
		 * @brief insert a skill type into the database
		 * @param id, skill type to insert
		 */
		public long insertSkillType(int id, SkillType skillType) {
			ContentValues values = new ContentValues();
			values.put(COL_NAME, skillType.getName());
			return dataBase.insert(TABLE_SKILL_TYPE, null, values);
		}

		/**
		 * @brief update a skill type into the database
		 * @param the skill type to update
		 */
		public int updateSkillType(int id, SkillType skillType) {
			ContentValues values = new ContentValues();
			values.put(COL_NAME, skillType.getName());
			return dataBase.update(TABLE_SKILL_TYPE, values, COL_ID + " = " +id, null);
		}
	}
