package com.projetswtorelite2014.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.projetswtorelite2014.R;

public class SkillsScreenActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onButtonClick(View v) {
		switch (v.getId()) {

		case R.id.btn_skill_artifice:
			Intent artifice = new Intent(this, TabResultsFragmentActivity.class);
			startActivity(artifice);
			break;

		case R.id.btn_skill_biochem:
			Intent biochem = new Intent(this, TabResultsFragmentActivity.class);
			startActivity(biochem);
			break;

		case R.id.btn_skill_cybertech:
			Intent cybertech = new Intent(this, TabResultsFragmentActivity.class);
			startActivity(cybertech);
			break;

		case R.id.btn_skill_armstech:
			Intent armstech = new Intent(this, TabResultsFragmentActivity.class);
			startActivity(armstech);
			break;

		case R.id.btn_skill_armortech:
			Intent armortech = new Intent(this, TabResultsFragmentActivity.class);
			startActivity(armortech);
			break;

		case R.id.btn_skill_synthweaving:
			Intent synthweaving = new Intent(this, TabResultsFragmentActivity.class);
			startActivity(synthweaving);
			break;
		}
	}
}
