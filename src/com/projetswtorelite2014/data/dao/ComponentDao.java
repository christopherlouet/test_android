package com.projetswtorelite2014.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.projetswtorelite2014.data.DataBaseHelper;
import com.projetswtorelite2014.model.Component;

/**
 * @author User
 * Class to create the Skill table into the database
 */
public class ComponentDao {

	public SQLiteDatabase dataBase;
	public DataBaseHelper helper;

	// Nom de la table
	public static final String TABLE_COMPONENT = "table_component";

	// Colonnes de la table
	public static final String COL_ID = "ID";
	public static final String COL_COMPONENT_RANK = "Componenet_rank";
	public static final String COL_COMPONENT_TYPE = "Componenet_type";
	public static final String COL_NAME = "Name";
	public static final String COL_RARITY = "Rarity";

	public ComponentDao(Context context) {
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
	public long insertComponent(int id, Component component) {
		ContentValues values = new ContentValues();
		values.put(COL_COMPONENT_RANK, component.getComponentRank());
		values.put(COL_COMPONENT_TYPE, component.getComponentType());
		values.put(COL_NAME, component.getName());
		values.put(COL_RARITY, component.getRarity());
		return dataBase.insert(TABLE_COMPONENT, null, values);
	}

	/**
	 * @brief update a skill into the database
	 * @param the skill to update
	 */
	public int updateComponent(int id, Component component) {
		ContentValues values = new ContentValues();
		values.put(COL_COMPONENT_RANK, component.getComponentRank());
		values.put(COL_COMPONENT_TYPE, component.getComponentType());
		values.put(COL_NAME, component.getName());
		values.put(COL_RARITY, component.getRarity());
		return dataBase.update(TABLE_COMPONENT, values, COL_ID + " = " +id, null);
	}
}
