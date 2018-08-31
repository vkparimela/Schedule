package com.example.raviteja.timepickerdialog;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ScreenZero extends AppCompatActivity {

    ImageView i,j,k,l,m,n,o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_zero);

        i = (ImageView)findViewById(R.id.sil);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(ScreenZero.this,ScreenFirst.class);
                startActivity(first);
            }
        });
        j=(ImageView)findViewById(R.id.air);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second=new Intent(ScreenZero.this,ScreenSecond.class);
                startActivity(second);
            }
        });
        k = (ImageView)findViewById(R.id.dnd);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent third=new Intent(ScreenZero.this,ScreenThird.class);
                startActivity(third);
            }
        });
        l = (ImageView)findViewById(R.id.wifi);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent four=new Intent(ScreenZero.this,ScreenFour.class);
                startActivity(four);
            }
        });
        m = (ImageView)findViewById(R.id.md);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent five=new Intent(ScreenZero.this,ScreenFive.class);
                startActivity(five);
            }
        });
        n = (ImageView)findViewById(R.id.ps);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent six=new Intent(ScreenZero.this,ScreenSix.class);
                startActivity(six);
            }
        });
        o = (ImageView)findViewById(R.id.loc);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent seven=new Intent(ScreenZero.this,ScreenSeven.class);
               startActivity(seven);
            }
        });


    }
}
