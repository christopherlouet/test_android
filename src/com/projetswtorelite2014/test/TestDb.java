package com.projetswtorelite2014.test;

import android.app.Activity;
import android.os.Bundle;

import com.projetswtorelite2014.R;
import com.projetswtorelite2014.data.dao.ComponentRankDao;
import com.projetswtorelite2014.data.dao.ComponentTypeDao;
import com.projetswtorelite2014.data.dao.RarityDao;
import com.projetswtorelite2014.data.dao.SkillDao;
import com.projetswtorelite2014.data.dao.SkillTypeDao;
import com.projetswtorelite2014.model.ComponentRank;
import com.projetswtorelite2014.model.ComponentType;
import com.projetswtorelite2014.model.Rarity;
import com.projetswtorelite2014.model.Skill;
import com.projetswtorelite2014.model.SkillType;

public class TestDb extends Activity {

	private SkillDao skillSource;
	private SkillTypeDao skillTypeSource;
	private RarityDao raritySource;
	private ComponentTypeDao componentTypeSource;
	private ComponentRankDao componentRankSource;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity);
		
		// Test Table Skill
		skillSource = new SkillDao(this);
		skillTypeSource = new SkillTypeDao(this);
		raritySource = new RarityDao(this);
		componentTypeSource = new ComponentTypeDao(this);
		componentRankSource = new ComponentRankDao(this);
		
		Skill s1 = new Skill(0, "skill 1");
		Skill s2 = new Skill(1, "skill 2");
		Skill s3 = new Skill(2, "skill 3");
		
		skillSource.insertSkill(s1.getId(), s1);
		skillSource.insertSkill(s2.getId(), s2);
		skillSource.insertSkill(s3.getId(), s3);

		// Test Table Skill Type
		SkillType st1 = new SkillType("Skill Type 1");
		SkillType st2 = new SkillType("Skill Type 2");
		SkillType st3 = new SkillType("Skill Type 3");
		
		skillTypeSource.insertSkillType(st1.getId(), st1);
		skillTypeSource.insertSkillType(st2.getId(), st2);
		skillTypeSource.insertSkillType(st3.getId(), st3);
		
		// Test Table Rarity
		Rarity r1 = new Rarity("Gris");
		Rarity r2 = new Rarity("Vert");
		Rarity r3 = new Rarity("Rouge");
		
		raritySource.insertRarity(0, r1);
		raritySource.insertRarity(1, r2);
		raritySource.insertRarity(2, r3);
		
		// Test Table ComponentType
		ComponentType c1 = new ComponentType("Test1");
		ComponentType c2 = new ComponentType("Test2");
		ComponentType c3 = new ComponentType("Test3");
	
		componentTypeSource.insertComponentType(0, c1);
		componentTypeSource.insertComponentType(1, c2);
		componentTypeSource.insertComponentType(2, c3);
		
		// Test Table ComponentRank
		ComponentRank cr1 = new ComponentRank(1);
		ComponentRank cr2 = new ComponentRank(2);
		ComponentRank cr3 = new ComponentRank(3);
		
		componentRankSource.insertComponentRank(0, cr1);
		componentRankSource.insertComponentRank(1, cr2);
		componentRankSource.insertComponentRank(2, cr3);
	}
}