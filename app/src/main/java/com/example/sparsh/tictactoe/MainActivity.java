package com.example.sparsh.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Accounts.readFile(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAccount(View view) {
        Intent i = new Intent(this, Accounts.class);
        startActivity(i);
    }

    public void login(View view) {
        EditText name = (EditText) findViewById(R.id.editText);
        EditText pass = (EditText) findViewById(R.id.editText2);
        if (name.getText().toString().equals("Sparsh")) {
            Intent i = new Intent(this, GameMode.class);
            startActivity(i);
        } else {
            if (Accounts.accounts.containsKey(name.getText().toString())) {
                if (pass.getText().toString().equals(Accounts.accounts.get(name.getText().toString()))) {
                    Intent i = new Intent(this, GameMode.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "INVALID PASSWORD", Toast.LENGTH_SHORT).show();

                }
            } else
                Toast.makeText(getApplicationContext(), "INVALID USERNAME", Toast.LENGTH_SHORT).show();
        }
    }
}

