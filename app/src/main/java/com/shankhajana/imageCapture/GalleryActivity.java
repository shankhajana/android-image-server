package com.shankhajana.imageCapture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    RecyclerView recview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new GridLayoutManager(this,3));

        String getImagesUrl = EndpointUtil.getGalleryEndpoint(this);
        Log.i("gallery url",getImagesUrl);
        JSONObject params = new JSONObject();
        try {
            params.put("userId","shankhajana@gmail.com");
            params.put("limit","50");
            params.put("offset","0");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                getImagesUrl, params, //Not null.
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("RESOPNSE", response.toString());
                        GsonBuilder gsonBuilder=new GsonBuilder();
                        Gson gson=gsonBuilder.create();
                        Log.e("Gallery- response",""+response.toString());

                        GalleryResponse res=gson.fromJson(response.toString(),GalleryResponse.class);
                        List<GalleryResponseBody> data = res.getBody();
                        recview.setAdapter(new ImageAdapter(data,getApplicationContext()));
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ERROR", "Error: " + error.getMessage());
                Toast.makeText(GalleryActivity.this, "Unable to load images !", Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(jsonObjReq);
    }
}