package com.example.minufrancis.cs478_project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by minufrancis on 9/30/16.
 */

/*
 GridViewAdapter is an adapter that inherits BaseAdapter to implement basic functionalities
 * and this Adapter is made use so that each Gridview cell can compose of both image thumbnails
 * and a textview.
*/
public class GridViewAdapater extends BaseAdapter {


    private Context context;
    private static LayoutInflater inflater = null;

    String[] cadillacDealers = {"Grossinger City Autoplex, Address: 1530 N Dayton St, Chicago, IL 60642",
            "Shirey Cadillac, Address: 10125 S Cicero Ave, Oak Lawn, IL 60453",
            "Grossinger Autoplex, Address: 6900 N McCormick Lincolnwood, IL 60712"};
    String[] chevroletDealers = {"Mike Anderson Chevrolet of Chicago,Address: 5333 W Irving Rd, Chicago, IL 60642",
            "Kingdom Chevy,Address: 6603 S Western Ave, Chicago, IL 60636",
            "Rogers Chevrolet,2720 S Michigan Ave, Chicago, IL 60616"};
    String[] fordDealers = {"Metro Ford, Address: 6455 S Western Ave, Chicago, IL 60636",
            "McCarthy Ford, Address: 11400 S Pulaski Rd, Chicago, IL 60655",
            "Haggerty Ford, Address: 330 E Roosevelt Rd, West Chicago, IL 60185"};
    String[] hondaDealers = {"Fletcher Jones Honda, Address: 1100 N Clark St, Chicago, IL 60610",
            "McGrath City Honda, Address: 6720 W Grand Ave, Chicago, IL 60707",
            "Honda City Chicago, Address: 4950 S Pulaski Rd, Chicago, IL 60632"};
    String[] chryslerDealers = {"Napleton's Northwestern Chrysler Jeep Dodge, Address: 5950 N Western Ave, Chicago, IL 60659",
            "South Chicago Dodge Chrysler Jeep, Address: 7340 S Western Ave, Chicago, IL 60636",
            "Marino Chrysler Jeep Dodge, Address: 5133 W Irving Park Rd, Chicago, IL 60641"};
    String[] toyotaDealers = {"Midtown Toyota, Address: 2700 N Cicero Ave, Chicago, IL 60639",
            "Chicago Northside Toyota, Address: 5625 North Broadway, Chicago, IL 60660",
            "Toyota on Western, Address: 6941 S Western Ave, Chicago, IL 60636"};

    /*
    An array of objects of Class ImageDetails. This class contains the details of the grid cells like:
     * ImageId of the low resolution images, ImageId of the high resolution images,
      * Image Text to be displayed in each cell, Website of respective car manufacturer and a String array to
      * hold the list of dealers with respect to each car make
      */
    private ImageDetails[] imageIds = {

            new ImageDetails(R.drawable.cadillac,R.drawable.cadillachighres,"Cadillac","http://www.cadillac.com/",cadillacDealers),
            new ImageDetails(R.drawable.chevrolet,R.drawable.chevrolethighres,"Chevrolet", "http://www.chevrolet.com/",chevroletDealers),
            new ImageDetails(R.drawable.ford,R.drawable.fordhighres,"Ford","https://www.ford.com/",fordDealers),
            new ImageDetails(R.drawable.honda,R.drawable.hondahighres,"Honda","http://www.honda.com/",hondaDealers),
            new ImageDetails(R.drawable.chrysler,R.drawable.chryslerhighres,"Chrysler","https://www.chrysler.com/",chryslerDealers),
            new ImageDetails(R.drawable.toyota,R.drawable.toyotahighres,"Toyota","http://www.toyota.com/",toyotaDealers)

            };

    // The default constructor takes in only the context as other features are provided using the class ImageDetails
    public GridViewAdapater(Context con)
    {
        this.context = con;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount()
    {
        return imageIds.length;
    }

    public long getItemId(int position)
    {
        return 0;
    }

    public ImageDetails getItem(int position) {
        return imageIds[position];
    }
    public View getView(int position, View view, ViewGroup parent) {

        View carsGridView;
        if(view == null)
        {
            carsGridView = inflater.inflate(R.layout.gridlayout,null);
            TextView txt = (TextView)carsGridView.findViewById(R.id.gridViewText);
            ImageView imgView = (ImageView) carsGridView.findViewById(R.id.gridViewImage);
            imgView.setImageResource(imageIds[position].getImageId());
            txt.setText(imageIds[position].getImageText());
        }
        else
        {
            carsGridView = (View) view;
        }

        return carsGridView;
    }

    /* ImageDetails class has the details of the Cars that are displayed in each grid cell
     * The getters defined in this method are used by GridViewActivity to perform various actions
      * */
    protected class ImageDetails extends Object {
        private int imageId;
        private int imageIdHighResolution;
        private String imageText;
        private String imageUrlString;
        private String[] carDealers = new String[3];


        ImageDetails(int id, int idHighRes, String text,String url,String[] dealers) {
            imageId = id;
           imageIdHighResolution = idHighRes;
            imageText = text;
            imageUrlString = url;
            carDealers = dealers;
        }
        public int getImageId() {
            return imageId; // returns the image id of the image contained in the clicked cel
        }

        public int getImageHighResolutionId()
        {
            return imageIdHighResolution; // returns the image id corresponding to the higher resolution version of the image contained in the clicked cell
        }

        public String getImageText(){
            return imageText; // returns the text (Name of the manufacturer of the car)
        }


        public String getImageUrlString() {
            return imageUrlString; // returns the URL of the manufacturer of the clicked car
        }

        public String[] getCarDealers(){
            return carDealers; // return the list of cardealers for the respective car that was clicked
        }
    }


}
