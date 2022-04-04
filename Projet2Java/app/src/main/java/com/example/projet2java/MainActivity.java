package com.example.projet2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int mcount = 0;
    public TextView mshowcount;
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mshowcount = (TextView) findViewById(R.id.show_count);
        move = findViewById(R.id.Move);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void CountUp (View v)
    {
        mcount++;
//        if (mshowcount != null);
        mshowcount.setText(Integer.toString(mcount));
    }

    public void CountDown (View v)
    {
        mcount--;
        mshowcount.setText(Integer.toString(mcount));
    }

}