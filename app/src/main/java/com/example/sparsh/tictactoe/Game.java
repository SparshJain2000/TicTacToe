package com.example.sparsh.tictactoe;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Game extends AppCompatActivity {

    public static int chance = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView x = (TextView) findViewById(R.id.textView6);
        x.setText("Player 1's TURN");
        x.setTextColor(this.getResources().getColor(R.color.yellow));
    }

    boolean hasWon = false;

    @SuppressLint("ResourceAsColor")
    public void set(View view) {
        if(hasWon) {reset(findViewById(R.id.button3));return;}
        if(!hasWon) {
            Button b = (Button) findViewById(view.getId());
            if (b.getText().toString() == "X" || b.getText().toString() == "O") {
                Toast.makeText(getApplicationContext(), "INVALID CHOICE", Toast.LENGTH_SHORT).show();

                return;
            }
        }
        chance += 1;
        if (!hasWon) {
            if (chance % 2 == 0) {
                TextView x = (TextView) findViewById(R.id.textView6);
                x.setText("Player 1's TURN");
                x.setTextColor(this.getResources().getColor(R.color.yellow));
            }
            if (chance % 2 != 0) {
                TextView x = (TextView) findViewById(R.id.textView6);
                x.setText("Player 2's TURN");
                x.setTextColor(this.getResources().getColor(R.color.lyellow));
            }
        }
        //Button b=(Button)findViewById(view.getId());
        Button b = (Button) findViewById(view.getId());
        if (chance % 2 == 0) {
            b.setText("O");
            b.setTextColor(this.getResources().getColor(R.color.lyellow));

        } else {
            b.setText("X");
            b.setTextColor(this.getResources().getColor(R.color.yellow));
        }
        TextView a = (TextView) findViewById(R.id.textView5);
        if(!hasWon) {
            if (win().equals("X")) {
                a.setText("PLAYER 1 HAS WON !!!!!!");
                a.setTextColor(this.getResources().getColor(R.color.yellow));
                hasWon = true;
                TextView x = (TextView) findViewById(R.id.textView6);
                x.setText("");
            } else if (win().equals("O")) {
                a.setText("PLAYER 2 HAS WON !!!!!!");
                a.setTextColor(this.getResources().getColor(R.color.lyellow));
                hasWon = true;
                TextView x = (TextView) findViewById(R.id.textView6);
                x.setText("");
            } else if (isFull()) {
                a.setText("IT's A DRAW !!!");
                a.setTextColor(this.getResources().getColor(R.color.white));
                hasWon = true;
                TextView x = (TextView) findViewById(R.id.textView6);
                x.setText("");
            }
        }
    }

    public String win() {
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        if (!b3.getText().toString().equals("")) {
            if (b1.getText() == b2.getText() && b2.getText() == b3.getText())
                return b3.getText().toString();
            if (b3.getText() == b6.getText() && b6.getText() == b9.getText())
                return b3.getText().toString();
            if (b3.getText() == b5.getText() && b5.getText() == b7.getText())
                return b3.getText().toString();
        }
        if (!b4.getText().toString().equals("")) {
            if (b4.getText() == b5.getText() && b5.getText() == b6.getText())
                return b4.getText().toString();

            if (b1.getText() == b4.getText() && b4.getText() == b7.getText())
                return b4.getText().toString();
        }
        if (!b5.getText().toString().equals("")) {
            if (b2.getText() == b5.getText() && b5.getText() == b8.getText())
                return b2.getText().toString();

            if (b1.getText() == b5.getText() && b5.getText() == b9.getText())
                return b1.getText().toString();
        }
        if (!b7.getText().toString().equals("")) {
            if (b7.getText() == b8.getText() && b8.getText() == b9.getText())
                return b7.getText().toString();
        }
        return "";
    }

    public boolean isFull() {
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        if (b1.getText().toString().equals("") || b2.getText().toString().equals("") || b3.getText().toString().equals("") || b4.getText().toString().equals("")
                || b5.getText().toString().equals("") || b6.getText().toString().equals("") || b7.getText().toString().equals("") || b8.getText().toString().equals("") || b9.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    public void reset(View view) {
        chance = 0;
        hasWon = false;
        TextView x = (TextView) findViewById(R.id.textView6);
        x.setText("Player 1's TURN");
        x.setTextColor(this.getResources().getColor(R.color.yellow));
        TextView t = (TextView) findViewById(R.id.textView5);
        t.setTextColor(this.getResources().getColor(R.color.white));
        t.setText(R.string.tag);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }
}
