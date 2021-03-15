package com.example.lyricsfinderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_Artist_Name, edt_Song_Name;
    Button btn_Get_Lyrics;
    TextView txt_Lyrics;

    // https://api.lyrics.ovh/v1/artist/title

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Artist_Name = findViewById(R.id.edt_Artist_Name);
        edt_Song_Name = findViewById(R.id.edt_Song_Name);
        btn_Get_Lyrics = findViewById(R.id.btn_Get_Lyrics);
        txt_Lyrics = findViewById(R.id.txt_Lyrics);

        btn_Get_Lyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "button tapped", Toast.LENGTH_SHORT).show();

            }
        });

    }
}