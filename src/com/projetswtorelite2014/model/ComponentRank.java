package com.projetswtorelite2014.model;

public class ComponentRank {

	private int id;
	private int rank;

	public ComponentRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String toString(){
		return "ID : "+id+ "\nRank : "+rank;
	}
}
