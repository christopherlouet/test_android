package com.projetswtorelite2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.projetswtorelite2014.screens.SkillsScreenActivity;

public class MainActivity extends Activity {
	private ProgressBar progressBar;
	private int total = 0;
	private CountDownTimer cdt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		progressBar.setProgress(total);
		cdt = new CountDownTimer(1000, 1000) { 

			public void onTick(long millisUntilFinished) {
				progressBar.setProgress(0);
			}

			public void onFinish() {
				Intent i = new Intent(MainActivity.this, SkillsScreenActivity.class);
				startActivity(i);
			}
		}.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
