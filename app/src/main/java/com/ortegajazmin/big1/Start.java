package com.ortegajazmin.big1;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Start extends AppCompatActivity {

    Button before;
    Button during;
    Button after;
    Button fault;
    Button staging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        before = findViewById(R.id.btnBefore);
        during = findViewById(R.id.btnDuring);
        after = findViewById(R.id.btnAfter);
        fault = findViewById(R.id.btnFault);
        staging = findViewById(R.id.btnStaging);

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBefore();
            }
        });
        during.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentDuring();
            }
        });
        after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentAfter();
            }
        });
        fault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.phivolcs.dost.gov.ph/index.php/the-phivolcs-fault-finder";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        staging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentStaging();
            }
        });
    }


    //before button
    public void intentBefore(){
        Intent intent = new Intent(Start.this, Before.class);
        startActivity(intent);
    }
    //during button
    public void intentDuring(){
        Intent intent = new Intent(Start.this, During.class);
        startActivity(intent);
    }
    //after button
    public void intentAfter(){
        Intent intent = new Intent(Start.this, After.class);
        startActivity(intent);
    }
    //fault button
    public void intentStaging(){
        Intent intent = new Intent(Start.this, Staging.class);
        startActivity(intent);
    }

    public void clickBack(View v){
        Intent intent = new Intent(Start.this, Intro.class);
        startActivity(intent);
    }

}


