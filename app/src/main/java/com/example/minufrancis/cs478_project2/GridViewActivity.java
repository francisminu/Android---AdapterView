package com.example.minufrancis.cs478_project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class GridViewActivity extends AppCompatActivity {

    public static String EXTRA_RES_ID = "Extraresid";
    public static String EXTRA_FLAG = "FLAG";
    public static String EXTRA_URL = "URL";
    public static String EXTRA_DEALERS = "DEALERS";
    public String[] dealers = new String[3];
    public String longClickImageUrl = "";
    public int longClickImageId = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        final GridViewAdapater adapter = new GridViewAdapater(this);
        gridView.setAdapter(adapter);

        /* The below code sets the itemClickListener for each item in the Grid View.
        * On click of a particular cell in the Grid View should bring up a larger image of the Car displayed
        * in the clicked cell. */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(GridViewActivity.this,ImageDisplay.class);
                intent.putExtra(EXTRA_FLAG,0);
                /* (adapter.getItem(position).getImageHighResolutionId()) gets the position of the image that is
                chosen from the GridViewAdapter class. This is then passed as a parameter to the intent */
                intent.putExtra(EXTRA_RES_ID, (int) (adapter.getItem(position).getImageHighResolutionId()));
                intent.putExtra(EXTRA_URL,(adapter.getItem(position).getImageUrlString())); // This statement passes the URL of the respective manufacturer to the ImageDIsplay class
                startActivity(intent); }
        });

        /* Below step sets the onLongClickListener for each item in the gridview.
        On long click of a Grid Cell, the user should be provided with a Context menu with 3 options */
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id)
            {
                registerForContextMenu(gridView);
                openContextMenu(gridView);
                dealers = adapter.getItem(position).getCarDealers();
                // The below statement gets the id of the high resolution image corresponding to the cell that is cicked
                longClickImageId = (int) adapter.getItem(position).getImageHighResolutionId();
                //Log.i("CheckforValue", String.valueOf((int) adapter.getItem(position).getImageId()));
                longClickImageUrl = adapter.getItem(position).getImageUrlString();
                return true;
            }
        });
    }


    /* onCreateContextMenu is overrided below to implement the Context Menu Feature */
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gridmenu, menu);

    }

    /* The method onContextItemSelected implements the logic for the actions to be performed on
     clicking each item of the Context Menu
      */
    @Override
    public boolean onContextItemSelected (MenuItem item){
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.menuitem1: {
                /* On choosing option 1, 'View Full Image', a higher resolution image of the car
                corresponding to the clicked cell should be displayed */

                Intent intent = new Intent(GridViewActivity.this,ImageDisplay.class);
                intent.putExtra(EXTRA_RES_ID, longClickImageId);
                intent.putExtra(EXTRA_URL,longClickImageUrl);
                intent.putExtra("FLAG",1);
                startActivity(intent);
            }
            break;
            case R.id.menuitem2: {

                //Uri uri = Uri.parse(longClickImageUrl);
                //Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                /* On choosing option 2, 'View Manufaturer Website', the manufacturer website should be displayed */

                Intent intent = new Intent(GridViewActivity.this,BrowserDisplay.class);
                intent.putExtra(EXTRA_URL,longClickImageUrl);
                startActivity(intent);
            }
            break;
            case R.id.menuitem3: {

                /* On choosing option 3, 'View Dealers List', a new activity with ListView containing list of
                3 dealers for the respective car company should be displayed
                 */
                Intent intent = new Intent(GridViewActivity.this,DealersList.class);
                intent.putExtra(EXTRA_DEALERS,dealers);
                startActivity(intent);
            }
            break;
        }

        return super.onContextItemSelected(item);
    }

}
