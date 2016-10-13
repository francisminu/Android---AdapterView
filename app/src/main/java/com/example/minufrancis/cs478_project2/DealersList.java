package com.example.minufrancis.cs478_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DealersList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers_list);

        /* This activity contains a ListView and displays the dealers information in it */
        Intent intent = getIntent();
        String [] stringArray = intent.getStringArrayExtra(GridViewActivity.EXTRA_DEALERS);

        final ListView carsGrid = (ListView) findViewById(R.id.list); //ListView in which the dealers information is displayed

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listlayout,stringArray); // ArrayAdapter is used instead of a custom adapter as this alone would suffice for a ListView
        carsGrid.setAdapter(adapter);
    }
}
