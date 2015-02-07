package com.projetswtorelite2014.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.projetswtorelite2014.data.DataBaseHelper;
import com.projetswtorelite2014.model.Skill;

/**
 * @author User
 * Class to create the Skill table into the database
 */
public class SkillDao {

	public SQLiteDatabase dataBase;
	public DataBaseHelper helper;

	// Nom de la table
	public static final String TABLE_SKILL = "table_skill";

	// Colonnes de la table
	public static final String COL_ID = "ID";
	public static final String COL_CRAFT_SKILL_TYPE = "Skill_type_id";
	public static final String COL_NAME = "Name";

	public SkillDao(Context context) {
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
	 * @brief insert a skill into the database
	 * @param id, skill to insert
	 */
	public long insertSkill(int id, Skill skills) {
		ContentValues values = new ContentValues();
		values.put(COL_CRAFT_SKILL_TYPE, skills.getId());
		values.put(COL_NAME, skills.getName());
		return dataBase.insert(TABLE_SKILL, null, values);
	}

	/**
	 * @brief update a skill into the database
	 * @param the skill to update
	 */
	public int updateSkill(int id, Skill skills) {
		ContentValues values = new ContentValues();
		values.put(COL_CRAFT_SKILL_TYPE, skills.getId());
		values.put(COL_NAME, skills.getName());
		return dataBase.update(TABLE_SKILL, values, COL_ID + " = " +id, null);
	}
}
