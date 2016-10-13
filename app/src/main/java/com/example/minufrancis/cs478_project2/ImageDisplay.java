package com.example.minufrancis.cs478_project2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageDisplay extends AppCompatActivity {

    public String url = "";
    public String[] carDealers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        /* This activity displays the higher resolution image of the respective image that was clicked
        in the GridView
         */
        Intent intent = getIntent();
        ImageView image = (ImageView) findViewById(R.id.carImage);
        url = intent.getStringExtra(GridViewActivity.EXTRA_URL);
        carDealers = intent.getStringArrayExtra("string-array");
        int flag = intent.getIntExtra(GridViewActivity.EXTRA_FLAG,0);
        image.setImageResource(intent.getIntExtra(GridViewActivity.EXTRA_RES_ID,0));
        /*if(flag == 0)
        {
            image.setEnabled(true);
        }
        else
        {
            image.setEnabled(false);
        }*/
    }

    /* On click of the image, displayWebsite gets called and the website corresponding to the
    manufacturer is displayed in a new activity
     */
    public void displayWebsite(View view)
    {
        Intent intent = new Intent(ImageDisplay.this,BrowserDisplay.class);
        intent.putExtra("URL",url);
        //Uri uri = Uri.parse(url);
        //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
