package com.ortegajazmin.big1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class What extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigone);



    }
    public void clickBack(View v){
        Intent i;
        i = new Intent(this, Intro.class);
        startActivity(i);
    }

}
