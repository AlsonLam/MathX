package com.example.alson.mathx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Secondary_Education extends AppCompatActivity {
    private Button b;
    private Button a;
    private Button c;
    private Button d;
    private Button e;
    private Button f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary__education);

        f = (Button) findViewById(R.id.button13);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(Secondary_Education.this,Secondary_Four.class);
                startActivity(t);
            }
        });

        e = (Button) findViewById(R.id.button12);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent(Secondary_Education.this,Secondary_Three.class);
                startActivity(r);
            }
        });

        d = (Button) findViewById(R.id.button18);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(Secondary_Education.this,Notes.class);
                startActivity(w);
            }
        });
        c = (Button) findViewById(R.id.button19);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(Secondary_Education.this,Calculator.class);
                startActivity(q);
            }
        });
        a = (Button) findViewById(R.id.button11);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(Secondary_Education.this,Secondary_Two.class);
                startActivity(p);
            }
        });
        b = (Button) findViewById(R.id.button10);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Secondary_Education.this,Secondary_One.class);
                startActivity(i);
            }
        });

    }
}
