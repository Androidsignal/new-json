package com.example.akshar.imagejson;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView recyclerView;
    ArrayList<Bean>arrayList;


    String url_data="http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(ListView)findViewById(R.id.recycleview);
        arrayList=new ArrayList<>();
    //    loadRecycledata();
        loadjson();

        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),Detail.class);
                i.putExtra("pos",position);
                i.putExtra("ravi",arrayList);
                startActivity(i);
            }
        });
    }

    private void loadjson() {
        AsyncLoader helper=new AsyncLoader(MainActivity.this,"https://api.androidhive.info/contacts/", new Onacysnkloader() {
        @Override
        public void Onresult(String result) {
            try {
                JSONObject jsonObject=new JSONObject(result);
                JSONArray jsonArray=jsonObject.getJSONArray("worldpopulation");
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);


                        Bean bean=new Bean();
                        bean.setCountry(jsonObject1.getString("country"));
                        bean.setRank(jsonObject1.getString("rank"));
                        bean.setPopulation(jsonObject1.getString("population"));
                        bean.setImageUrl(jsonObject1.getString("flag"));
                        arrayList.add(bean);
                        MyAdpt adpt=new MyAdpt(MainActivity.this,arrayList);
                        recyclerView.setAdapter(adpt);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    });
        helper.execute();
    }
//    public void loadRecycledata(){
//        final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("wait data load");
//        progressDialog.show();
//
//        RequestQueue requestQueue= Volley.newRequestQueue(this);
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, url_data, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                progressDialog.dismiss();
//                try {
//                    JSONObject jsonObject=new JSONObject(response);
//                    JSONArray jsonArray=jsonObject.getJSONArray("worldpopulation");
//                    for(int i=0;i<jsonArray.length();i++){
//                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
//
//
//                        Bean bean=new Bean();
//                        bean.setCountry(jsonObject1.getString("country"));
//                        bean.setRank(jsonObject1.getString("rank"));
//                        bean.setPopulation(jsonObject1.getString("population"));
//                        bean.setImageUrl(jsonObject1.getString("flag"));
//                        arrayList.add(bean);
//                        MyAdpt adpt=new MyAdpt(MainActivity.this,arrayList);
//                        recyclerView.setAdapter(adpt);
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                progressDialog.dismiss();
//                Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//        requestQueue.add(stringRequest);

    }



