package com.example.sparsh.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

    }
    public void start(View view){

        Intent i=new Intent(this,Game.class);
        startActivity(i);
    }
    public void start1(View view){

        Intent i=new Intent(this,Single.class);
        startActivity(i);
    }
}
