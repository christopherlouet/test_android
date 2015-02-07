package com.projetswtorelite2014.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.projetswtorelite2014.data.DataBaseHelper;
import com.projetswtorelite2014.model.ComponentRank;

/**
 * @author User
 * Class to create the Rarity table into the database
 */
public class ComponentRankDao {
	
	public SQLiteDatabase dataBase;
	public DataBaseHelper helper;

	// Nom de la table
	public static final String TABLE_COMPONENT_RANK = "table_component_rank";

	// Colonnes de la table
	public static final String COL_ID = "ID";
	public static final String COL_RANK = "Rank";

	public ComponentRankDao(Context context) {
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
		public long insertComponentRank(int id, ComponentRank component) {
			ContentValues values = new ContentValues();
			values.put(COL_RANK, component.getRank());
			return dataBase.insert(TABLE_COMPONENT_RANK, null, values);
		}

		/**
		 * @brief update a rarity into the database
		 * @param the rarity to update
		 */
		public int updateComponentRank(int id, ComponentRank component) {
			ContentValues values = new ContentValues();
			values.put(COL_RANK, component.getRank());
			return dataBase.update(TABLE_COMPONENT_RANK, values, COL_ID + " = " +id, null);
		}
	}
