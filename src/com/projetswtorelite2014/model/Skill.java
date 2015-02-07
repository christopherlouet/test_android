package com.projetswtorelite2014.model;

public class Skill {
	
	private int id;
	private int idSkillType;
	private String name;

	public Skill(int idSkillType, String name) {
		this.idSkillType = idSkillType;
		this.name = name;
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
	 * @return the idSkillType
	 */
	public int getIdSkillType() {
		return idSkillType;
	}

	/**
	 * @param idSkillType the idSkillType to set
	 */
	public void setIdSkillType(int idSkillType) {
		this.idSkillType = idSkillType;
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

	public String toString(){
		return "ID : "+id+"\nidSkillType : "+idSkillType+"\nName : "+name;
	}
}
