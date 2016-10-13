package com.example.minufrancis.cs478_project2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BrowserDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_display);

        /* Thsi activity displays the website corresponding to the manufacturer of the respecive car in the
        cicked Grid cell
         */
        Intent intent = getIntent();
        String url = intent.getStringExtra(GridViewActivity.EXTRA_URL);
        Uri uri = Uri.parse(url); // retrieves the URL that was passed from the ImageDisplay activity in case of short click and
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(browserIntent);
        finish();
    }
}
