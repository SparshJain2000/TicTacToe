package com.example.sparsh.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Accounts extends AppCompatActivity {

    public static HashMap<String, String> accounts = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

    }


    public static void readFile(Context context) throws IOException {

        //Context context = getApplicationContext();
        File directory = context.getFilesDir();
        String filename = "s-jain.txt";
        File file = new File(directory, filename);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream io=new FileInputStream(file);
        //ArrayList<String> input = new ArrayList<>();
        try {
            io.read(bytes);
            io.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str=new String(bytes);
        String[] p=str.split("\n");
        for (int i = 0; i < p.length ; i++) {
            Log.e("login activity", "File found: " + p[i]);
            String[] x = p[i].split(" ");
            accounts.put(x[0], x[1]);
        }
    }

    private void writeToFile(String data, Context context) throws IOException {
        File directory = context.getFilesDir();
        File file = new File(directory, "s-jain.txt");
        FileOutputStream outputStream;
        if (!file.exists()) {
            outputStream = openFileOutput("s-jain.txt", Context.MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.close();
        } else {
            outputStream = openFileOutput("s-jain.txt", MODE_APPEND);
            outputStream.write(data.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.close();
        }
    }

    public void createAccount(View view) {
        EditText name = (EditText) findViewById(R.id.username);
        EditText pass = (EditText) findViewById(R.id.password);
        EditText chPass = (EditText) findViewById(R.id.Checkpassword);
        if((name.getText().toString().split(" ")).length==1){
        String data = name.getText().toString() + " " + pass.getText().toString();
        if (accounts.containsKey(name.getText().toString())) {
            Toast.makeText(getApplicationContext(), "USERNAME ALREADY TAKEN", Toast.LENGTH_SHORT).show();
        } else if (pass.getText().toString().equals(chPass.getText().toString())) {
            accounts.put(name.getText().toString(), pass.getText().toString());
            try {
                writeToFile(data, getApplicationContext());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent m = new Intent(this, MainActivity.class);
            startActivity(m);
        } else {
            Toast.makeText(getApplicationContext(), "PASSWORDS DON'T MATCH", Toast.LENGTH_SHORT).show();
        }
    }
        else{
            Toast.makeText(getApplicationContext(), "USERNAME can't contain spaces", Toast.LENGTH_SHORT).show();
        }
    }
}
