package com.example.alson.mathx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import bsh.EvalError;
import bsh.Interpreter;
public class HomeScreen extends AppCompatActivity {
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        b = (Button) findViewById(R.id.button);
        Interpreter interpreter = new Interpreter();
        try {
            System.out.println(String.valueOf(interpreter.eval("1+2")));
        } catch (EvalError evalError) {
            evalError.printStackTrace();
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreen.this,Secondary_Education.class);
                startActivity(i);

            }
        });
    }
}
