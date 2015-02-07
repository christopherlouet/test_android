package com.projetswtorelite2014.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.projetswtorelite2014.data.DataBaseHelper;
import com.projetswtorelite2014.model.Rarity;

/**
 * @author User
 * Class to create the Rarity table into the database
 */
public class RarityDao {
	
	public SQLiteDatabase dataBase;
	public DataBaseHelper helper;

	// Nom de la table
	public static final String TABLE_RARITY = "table_rarity";

	// Colonnes de la table
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "Name";

	public RarityDao(Context context) {
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
		public long insertRarity(int id, Rarity rarity) {
			ContentValues values = new ContentValues();
			values.put(COL_NAME, rarity.getName());
			return dataBase.insert(TABLE_RARITY, null, values);
		}

		/**
		 * @brief update a rarity into the database
		 * @param the rarity to update
		 */
		public int updateRarity(int id, Rarity rarity) {
			ContentValues values = new ContentValues();
			values.put(COL_NAME, rarity.getName());
			return dataBase.update(TABLE_RARITY, values, COL_ID + " = " +id, null);
		}
	}
