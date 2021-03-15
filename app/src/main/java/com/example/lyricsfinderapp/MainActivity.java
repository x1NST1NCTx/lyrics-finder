package com.example.lyricsfinderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

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

                //Toast.makeText(getApplicationContext(), "button tapped", Toast.LENGTH_SHORT).show();
                String url = "https://api.lyrics.ovh/v1/" + edt_Artist_Name.getText().toString() + "/" + edt_Song_Name.getText().toString();
                url.replace(" ","20%");
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            txt_Lyrics.setText(response.getString("lyrics"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(getApplicationContext(),"Song not found",Toast.LENGTH_SHORT).show();

                            }
                        });
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}