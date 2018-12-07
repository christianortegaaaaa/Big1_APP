package com.ortegajazmin.big1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Before extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before);


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


    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Things to Prepare");
        listDataHeader.add("Learn First Aid");
        listDataHeader.add("Identify the Safest Spots");
        listDataHeader.add("Find Exit Points");
        listDataHeader.add("Prepare your Home");
        listDataHeader.add("Meeting Place");

        // Adding child data
        List<String> prep = new ArrayList<String>();
        prep.add("First Aid Supplies");
        prep.add("Water - one gallon of water per person per day for at least three days, for drinking and sanitation");
        prep.add("Flashlight with fresh batteries");
        prep.add("Battery-operated radio with fresh batteries");
        prep.add("Extra batteries");
        prep.add("Essential medications");
        prep.add("Whistle or other signaling device");
        prep.add("Food - at least a three-day supply of non-perishable food (nutrition bars, trail mix, etc.)");

        List<String> aid = new ArrayList<String>();
        aid.add("What are the health and safety risks connected with landslides and earthquakes? Consider these:");
        aid.add("*Understand that the biggest risk is musculoskeletal injury. Falls, falling debris, and collapsing buildings often cause musculoskeletal injuries. Of those injuries, 65 percent are lacerations, 22 percent are fractures and 20 percent are crush injuries. The majority of the crush injuries occur to the lower limbs of the body.");
        aid.add("*Realize that failure to get prompt treatment can lead to complications. People who suffer a crush injury can lose substantial amounts of blood, causing serious illness or death. Sepsis from infected wounds is also a risk.");
        aid.add("*Head injuries are a leading cause of death and trauma after an injury. If you are attempting to give first aid to someone, know how to watch for head injuries.");


        List<String> idtfy = new ArrayList<String>();
        idtfy.add("Identify the safest spots in each room of your home, and instruct your family or colleagues how to drop, cover and hold on during an earthquake.");

        List<String> exit = new ArrayList<String>();
        exit.add("Find your nearest exit in your home.");
        exit.add("Inform other people about the best escape route in your place.");
        exit.add("Study the emergency plan of your workplace.");


        List<String> home = new ArrayList<String>();
        home.add("Make sure your home was built to handle the stresses of an earthquake.");
        home.add("Anchor the home to its foundation properly");
        home.add("Anchor heavy furniture to the wall and secure objects that present a safety hazard.");
        List<String> meet = new ArrayList<String>();
        meet.add("Make up a plan of where to meet your family after an earthquake in case you get separated");




        listDataChild.put(listDataHeader.get(0), prep); // Header, Child data
        listDataChild.put(listDataHeader.get(1), aid);
        listDataChild.put(listDataHeader.get(2), idtfy);
        listDataChild.put(listDataHeader.get(3), exit);
        listDataChild.put(listDataHeader.get(4), home);
        listDataChild.put(listDataHeader.get(5), meet);
    }

    public void clickBack(View v){
        Intent i;
        i = new Intent(this, Start.class);
        startActivity(i);
    }
}