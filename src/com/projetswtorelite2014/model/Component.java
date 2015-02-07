package com.projetswtorelite2014.model;

public class Component {

	private int id;
	private int componentRank;
	private String componentType;
	private String name;
	private int rarity;
	
	public Component() {}
	
	public Component(int componentRank, String componentType, String name, int rarity) {
		this.componentRank = componentRank;
		this.componentType = componentType;
		this.name = name;
		this.rarity = rarity;
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
	 * @return the componentRank
	 */
	public int getComponentRank() {
		return componentRank;
	}

	/**
	 * @param componentRank the componentRank to set
	 */
	public void setComponentRank(int componentRank) {
		this.componentRank = componentRank;
	}

	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return componentType;
	}

	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rarity
	 */
	public int getRarity() {
		return rarity;
	}

	/**
	 * @param rarity the rarity to set
	 */
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
}
