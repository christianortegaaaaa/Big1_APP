package com.ortegajazmin.big1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class After extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after);



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
        listDataHeader.add("Check yourself ");
        listDataHeader.add("Check water, gas, chemical spill, and electric lines for damage.");
        listDataHeader.add("Turn on the radio");
        listDataHeader.add("Be careful around broken glass and debris");
        listDataHeader.add("Control Fire");
        listDataHeader.add("Follow Emergency Plan");
        listDataHeader.add("Stay Alert");
        listDataHeader.add("Don't...");
        listDataHeader.add("Reconnect and Rest");
        // Adding child data
        List<String> checku = new ArrayList<String>();
        checku.add("Check for injuries. Provide first aid for anyone who needs it.");

        List<String> checkt = new ArrayList<String>();
        checkt.add("If any are damaged, shut off the valves.");
        checkt.add("Check for the smell of gas. If you smell it, open all the windows and doors, leave immediately, and report it to the authorities (use someone else's phone).");



        List<String> radio = new ArrayList<String>();
        radio.add("Check for announcements and other advisories from authorities.");
        radio.add("Follow their instructions.");


        List<String> care = new ArrayList<String>();
        care.add("Wear boots or sturdy shoes to keep from cutting your feet.");

        List<String> fire = new ArrayList<String>();
        fire.add("Fires may spread after an earthquake. Put this out as soon as possible, or get out quickly.");


        List<String> plan = new ArrayList<String>();
        plan.add("Go to your staging areas or meetup with your family");
        plan.add("Pick up your emergency bag you prepared ahead of time");


        List<String> alert = new ArrayList<String>();
        alert.add("Expect aftershocks which may happen following the main shock of a large eartquake.");

        List<String> dont = new ArrayList<String>();
        dont.add("Do NOT go near the coastline. Earthquakes can trigger large ocean waves called tsunamis.");
        dont.add("Do NOT go near downed power lines - stay at least 10 metres away to avoid injury.");
        dont.add("Do NOT enter damaged buildings.");
        dont.add("Do NOT use the phone unless it's an emergency.");
        dont.add("Do NOT use matches, candles, or any flame. Broken gas lines and fire don't mix.");


        List<String> recon = new ArrayList<String>();
        recon.add("Restore daily life by reconnecting with others, repairing damage, and rebuilding community.");




        listDataChild.put(listDataHeader.get(0), checku);
        listDataChild.put(listDataHeader.get(1), checkt); // Header, Child data
        listDataChild.put(listDataHeader.get(2), radio);
        listDataChild.put(listDataHeader.get(3), care);
        listDataChild.put(listDataHeader.get(4), fire); // Header, Child data
        listDataChild.put(listDataHeader.get(5), plan);
        listDataChild.put(listDataHeader.get(6), alert);
        listDataChild.put(listDataHeader.get(7), dont); // Header, Child data
        listDataChild.put(listDataHeader.get(8), recon);
    }

    public void clickBack(View v){
        Intent i;
        i = new Intent(this, Start.class);
        startActivity(i);
    }

}
