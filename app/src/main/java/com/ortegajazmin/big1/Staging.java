package com.ortegajazmin.big1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Staging extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staging);


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Uri uri = Uri.parse("google.navigation:q="+ listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).replace(' ','+'));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");

                try
                {
                    startActivity(intent);
                }
                catch(ActivityNotFoundException ex)
                {
                    try
                    {
                        Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(unrestrictedIntent);
                    }
                    catch(ActivityNotFoundException innerEx)
                    {
                        Toast.makeText(getApplicationContext(), "Please install a maps application", Toast.LENGTH_LONG).show();
                    }
                }

                startActivity(intent);

                return false;
            }
        });


    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("North Quadrant");
        listDataHeader.add("South Quadrant");
        listDataHeader.add("East Quadrant");
        listDataHeader.add("West Quadrant");

        // Adding child data
        List<String> north = new ArrayList<String>();
        north.add("Cities covered by this Quadrant:\n" +
                "Caloocan\t\t\t\t\n" +
                "Valenzuela\n" +
                "Quezon City\t\t\t\t\n" +
                "San Juan\n" +
                "Mandaluyong");
        north.add("Staging Area/s:");
        north.add("Memorial Golf Course");
        north.add("University of the Philippines (UP) Diliman");

        List<String> south = new ArrayList<String>();
        south.add("Cities covered by this Quadrant:\n" +
                "Las Piñas\t\t\t\n" +
                "Makati\n" +
                "Muntinlupa\n" +
                "Parañaque\n" +
                "Pateros\n" +
                "Taguig\n" +
                "Pasay");
        south.add("Staging Area/s:");
        south.add("Villamor Air Base Golf Course");

        List<String> east = new ArrayList<String>();
        east.add("Cities covered by this Quadrant:\n" +
                "Pasig\t\n" +
                "Marikina");
        east.add("Staging Area/s:");
        east.add("LRT-2 Santolan Depot");
        east.add("Marikina Boys Town");
        east.add("Red Cross Marikina");
        east.add("Ultra Pasig");

        List<String> west = new ArrayList<String>();
        west.add("Cities covered by this Quadrant:\n" +
                "Manila\t\t\t\t\n" +
                "Malabon\n" +
                "Navotas");
        west.add("Staging Area/s:");
        west.add("Intramuros Golf Course");





        listDataChild.put(listDataHeader.get(0), north); // Header, Child data
        listDataChild.put(listDataHeader.get(1), south);
        listDataChild.put(listDataHeader.get(2), east);
        listDataChild.put(listDataHeader.get(3), west);
    }
    public void clickBack(View v){
        Intent i;
        i = new Intent(this, Start.class);
        startActivity(i);
    }


}