package com.ortegajazmin.big1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class During extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during);


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
        listDataHeader.add("If You are Indoors...");
        listDataHeader.add("If You are Outdoors...");
        listDataHeader.add("If You are Driving...");
        listDataHeader.add("Don't...");

        // Adding child data
        List<String> in = new ArrayList<String>();
        in.add("Stay inside and stay calm.");
        in.add("If you can't get under something strong, or if you are in a hallway, flatten yourself or crouch against an interior wall.");
        in.add("Stay away from windows, and shelves with heavy objects.");
        in.add("DROP where you are, onto your hands and knees. This position protects you from being knocked down and also allows you to stay low and crawl to shelter if nearby.");
        in.add("COVER your head and neck with one arm and hand");
        in.add("HOLD ON until shaking stops. Beware of falling objects. Be alert and keep eyes open.");

        List<String> out = new ArrayList<String>();
        out.add("Move to an open area");
        out.add("Stay in the open away from power lines, posts, and concrete structures.");
        out.add("Stay away from buildings (stuff might fall off the building or the building could fall on you).T");
        out.add("Move away from steep slopes which may be affected by landslides.");
        out.add("If you are in a crowded public place, take cover where you won't be trampled.");


        List<String> drive = new ArrayList<String>();
        drive.add("Stop the car and stay inside the car until the earthquake stops");
        drive.add("Pull over to a safe place where you are not blocking the road. Keep roads clear for rescue and emergency vehicles.");
        drive.add("Avoid bridges, overpasses, underpasses, buildings or anything that could collapse.");
        drive.add("Listen to your car radio for instructions from emergency officials.");
        drive.add("Place a HELP sign in your window if you need assistance.");
        drive.add("If you are on a bus, stay in your seat until the bus stops. Take cover in a protected place. If you can't take cover, sit in a crouched position and protect your head from falling debris.");

        List<String> donts = new ArrayList<String>();
        donts.add("Do NOT attempt to get out of your car if downed power lines are across it. Wait to be rescued.");
        donts.add("Do NOT use elevators");
        donts.add("Do NOT run outside or to other rooms during shaking");
        donts.add("Do NOT stand in a doorway");



        listDataChild.put(listDataHeader.get(0), in); // Header, Child data
        listDataChild.put(listDataHeader.get(1), out); // Header, Child data
        listDataChild.put(listDataHeader.get(2), drive);
        listDataChild.put(listDataHeader.get(3), donts);
    }
    public void clickBack(View v){
        Intent i;
        i = new Intent(this, Start.class);
        startActivity(i);
    }

}
