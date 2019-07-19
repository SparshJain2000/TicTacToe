package com.example.sparsh.tictactoe;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Single extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
    }

    public static int chance = 0;
    boolean hasWon = false;

    @SuppressLint("ResourceAsColor")
    public void set(View view) {
        if(hasWon) {reset((Button)findViewById(R.id.button3));return;}
        chance += 1;
        if (!hasWon) {

            TextView x = (TextView) findViewById(R.id.textView6);
            x.setText("Your TURN");
            x.setTextColor(this.getResources().getColor(R.color.yellow));

        }
        //Button b=(Button)findViewById(view.getId());
        Button b = (Button) findViewById(view.getId());
        if(b.getText().toString()=="X" || b.getText().toString()=="O"){
            Toast.makeText(getApplicationContext(), "INVALID CHOICE", Toast.LENGTH_SHORT).show();
            chance--;
            return;
        }
        b.setText("X");
        b.setTextColor(this.getResources().getColor(R.color.magenta));
        result();

        if(!hasWon) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int i = (int) (Math.random() * 9);
                    if (chance != 9) {
                        while (set(i).getText().toString() == "X" || set(i).getText().toString() == "O")
                            i = (int) (Math.random() * 9);
                        Button x = set(i);
                        x.setText("O");
                        x.setTextColor(getResources().getColor(R.color.lyellow));
                        chance++;
                        result();
                    }
                }
            }, 300);
        }


    }

    public void result() {
        TextView a = (TextView) findViewById(R.id.textView5);
        if (!hasWon) {
            if (win().equals("X")) {
                a.setText("YOU HAVE WON !!!!!!");
                a.setTextColor(this.getResources().getColor(R.color.magenta));
                hasWon = true;
                TextView y = (TextView) findViewById(R.id.textView6);
                y.setText("");
            } else if (win().equals("O")) {
                a.setText("YOU LOST !!!!!!");
                a.setTextColor(this.getResources().getColor(R.color.yellow));
                hasWon = true;
                TextView y = (TextView) findViewById(R.id.textView6);
                y.setText("");
            } else if (isFull()) {
                a.setText("IT's A DRAW !!!");
                a.setTextColor(this.getResources().getColor(R.color.blue));
                hasWon = true;
                TextView y = (TextView) findViewById(R.id.textView6);
                y.setText("");
            }
        }
    }

    public Button set(int i) {
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        Button[] bArray = {b1, b2, b3, b4, b5, b6, b7, b8, b9};
        return bArray[i];
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
        x.setText("Your TURN");
        x.setTextColor(this.getResources().getColor(R.color.yellow));
        TextView t = (TextView) findViewById(R.id.textView5);
        t.setTextColor(this.getResources().getColor(R.color.white));
        t.setText(R.string.sing);
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
