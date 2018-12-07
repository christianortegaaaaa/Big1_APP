package com.ortegajazmin.big1;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    Dialog popup;
    Button start;
    Button what;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        popup = new Dialog(this);
        start = findViewById(R.id.btnStart);
        what = findViewById(R.id.btnWhat);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentStart();
            }
        });
        what.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentWhat();
            }
        });


    }
    //start button
    public void intentStart(){
        Intent intent = new Intent(Intro.this, Start.class);
        startActivity(intent);
    }
    //what button
    public void intentWhat(){
        Intent intent = new Intent(Intro.this, What.class);
        startActivity(intent);
    }


    //show popup
    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnClose;
        popup.setContentView(R.layout.popup_info);

        btnClose = (Button) popup.findViewById(R.id.btnclose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popup.show();
    }


}

