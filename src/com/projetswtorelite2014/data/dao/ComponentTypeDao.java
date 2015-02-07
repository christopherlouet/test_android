package com.projetswtorelite2014.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.projetswtorelite2014.data.DataBaseHelper;
import com.projetswtorelite2014.model.ComponentType;

/**
 * @author User
 * Class to create the Rarity table into the database
 */
public class ComponentTypeDao {
	
	public SQLiteDatabase dataBase;
	public DataBaseHelper helper;

	// Nom de la table
	public static final String TABLE_COMPONENT_TYPE = "table_component_type";

	// Colonnes de la table
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "Name";

	public ComponentTypeDao(Context context) {
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
		 * @brief insert a rarity into the database
		 * @param id, rarity to insert
		 */
		public long insertComponentType(int id, ComponentType component) {
			ContentValues values = new ContentValues();
			values.put(COL_NAME, component.getName());
			return dataBase.insert(TABLE_COMPONENT_TYPE, null, values);
		}

		/**
		 * @brief update a rarity into the database
		 * @param the rarity to update
		 */
		public int updateComponentType(int id, ComponentType component) {
			ContentValues values = new ContentValues();
			values.put(COL_NAME, component.getName());
			return dataBase.update(TABLE_COMPONENT_TYPE, values, COL_ID + " = " +id, null);
		}
	}
