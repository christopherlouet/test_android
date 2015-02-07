package com.projetswtorelite2014.screens;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.projetswtorelite2014.R;
import com.projetswtorelite2014.controller.JSONParser;
import com.projetswtorelite2014.model.WorldPopulation;

public class TabResultsFragmentActivity extends FragmentActivity {
	private JSONObject jsonobject;
	private JSONArray jsonarray;
	ArrayList<String> worldlist;
	ArrayList<WorldPopulation> world;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_results_fragment_activity);

		// Download JSON file AsyncTask
		new DownloadJSON().execute();
	}

	// Download JSON file AsyncTask
	private class DownloadJSON extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) 
		{
			// Locate the WorldPopulation Class
			world = new ArrayList<WorldPopulation>();
			// Create an array to populate the spinner
			worldlist = new ArrayList<String>();

			// JSON file URL address
			jsonobject = JSONParser
					.getJSONfromURL("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");

			try {
				// Locate the NodeList name
				jsonarray = jsonobject.getJSONArray("worldpopulation");
				for (int i = 0; i < jsonarray.length(); i++) {
					jsonobject = jsonarray.getJSONObject(i);

					WorldPopulation worldpop = new WorldPopulation();

					worldpop.setRank(jsonobject.optString("rank"));
					worldpop.setCountry(jsonobject.optString("country"));
					worldpop.setPopulation(jsonobject.optString("population"));
					worldpop.setFlag(jsonobject.optString("flag"));
					world.add(worldpop);

					// Populate spinner with country names
					worldlist.add(jsonobject.optString("country"));
				}

			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void args) {
			// Locate the spinner in activity_main.xml
			Spinner mySpinner = (Spinner) findViewById(R.id.spinnerType);

			// Spinner adapter
			mySpinner
			.setAdapter(new ArrayAdapter<String>(TabResultsFragmentActivity.this,
					android.R.layout.simple_spinner_dropdown_item,
					worldlist));

			// Spinner on item click listener
			mySpinner
			.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0,
						View arg1, int position, long arg3) {
					// TODO Auto-generated method stub
					// Locate the textviews in activity_main.xml
					TextView txtrank = (TextView) findViewById(R.id.rank);
					TextView txtcountry = (TextView) findViewById(R.id.country);
					TextView txtpopulation = (TextView) findViewById(R.id.population);

					// Set the text followed by the position
					txtrank.setText("Rank : "
							+ world.get(position).getRank());
					txtcountry.setText("Country : "
							+ world.get(position).getCountry());
					txtpopulation.setText("Population : "
							+ world.get(position).getPopulation());
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
				}
			});
		}
	}

}
