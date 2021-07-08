 package com.example.robot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

 public class  MainActivity extends AppCompatActivity {


     public void httpCall(String url) {

         RequestQueue queue = Volley.newRequestQueue(this);

         StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         // enjoy your response

                     }
                 }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 // enjoy your error status
             }
         });

         queue.add(stringRequest);

     }



     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         ToggleButton toggle = (ToggleButton) findViewById(R.id.przycisk);
         toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked) {
                     // The toggle is enabled
                     Log.d("INFO","Robot włączony");
                     httpCall("http://maarby.pythonanywhere.com/power_on");
                     TextView text = (TextView)findViewById(R.id.odpowiedz);
                     text.setText("Robot włączony");
                 } else {
                     // The toggle is disabled
                     Log.d("INFO","Robot wyłączony");
                     TextView text = (TextView)findViewById(R.id.odpowiedz);
                     text.setText("Robot wyłączony");
                 }
             }
         });



     }




 }




