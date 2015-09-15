package com.gmts.museum_of_transport_greater_manchester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import info.androidhive.listviewfeed.app.AppController;


public class ScannedDetails extends ActionBarActivity {
    public static Map Vehicle_Key_Info = new HashMap();
    public static Map Vehicle_Additional_Info = new HashMap();
    String url = "http://raspberrypi2014.x64.me/gmts/";
    String reg = "";
    ListView detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_details);
       // if (isInternetAvailable()){
            String urlKey = url +"Vehicle_key_info.php";
            // We first check for cached request
            Cache cache = AppController.getInstance().getRequestQueue().getCache();
            Cache.Entry entry = cache.get(urlKey);
            if (entry != null) {
                // fetch the data from cache
                try {
                    String data = new String(entry.data, "UTF-8");
                    try {
                        parseJSONKey(new JSONObject(data));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            } else {
                // making fresh volley request and getting json
                JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                        urlKey, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            parseJSONKey(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ScannedDetails.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                // Adding request to volley request queue
                AppController.getInstance().addToRequestQueue(jsonReq);
            }

            String urlAdditional = url+"Vehicle_key_info_add.php";
            // We first check for cached request
            Cache cache2 = AppController.getInstance().getRequestQueue().getCache();
            Cache.Entry entry2 = cache2.get(urlAdditional);
            if (entry2 != null) {
                // fetch the data from cache
                try {
                    String data = new String(entry2.data, "UTF-8");
                    try {
                        parseJSONAdditional(new JSONObject(data));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            } else {
                // making fresh volley request and getting json
                JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                        urlAdditional, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            parseJSONAdditional(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ScannedDetails.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                // Adding request to volley request queue
                AppController.getInstance().addToRequestQueue(jsonReq);
            }



            if (savedInstanceState == null){
                if(getIntent().getExtras() == null){
                    reg = "error reg not found";
                }
                else{
                    reg = getIntent().getExtras().getString("reg");
                }
            }
            else{
                reg = (String) savedInstanceState.getSerializable("reg");
            }

            //output details
            ArrayList Keyitems= (ArrayList)Vehicle_Key_Info.get(reg);
            ArrayList Additems= (ArrayList)Vehicle_Additional_Info.get(reg);
            String image = "null";

           detailsList= (ListView) findViewById(R.id.detailsList);

            final ArrayList<String> titleList = new ArrayList<>();
            final ArrayList<String> infoList = new ArrayList<>();

            if(Keyitems != null && Additems != null){
                titleList.add("Registration");
                titleList.add("Vehicle Type");
                titleList.add("Fleet Number");
                titleList.add("Commission Year");
                titleList.add("Decommission Year");
                titleList.add("Body_Manufacturer");
                titleList.add("Chassis_Manufacturer");
                titleList.add("Chassis_model");
                titleList.add("District");
                titleList.add("Operator");

                infoList.add((String)Keyitems.get(0));
                infoList.add((String)Keyitems.get(1));
                infoList.add((String)Keyitems.get(2));
                infoList.add((String)Keyitems.get(3));
                infoList.add((String)Keyitems.get(4));
                infoList.add((String)Additems.get(0));
                infoList.add((String)Additems.get(1));
                infoList.add((String)Additems.get(2));
                infoList.add((String)Additems.get(3));
                infoList.add((String)Additems.get(4));

                image = (String)Keyitems.get(5);
            }
            else{
                titleList.add("ERROR");
                infoList.add("Registration Plate not recognised correctly, please try again");
            }
            DetailsListAdapter adapter = new DetailsListAdapter(this,titleList,infoList,image);
            detailsList.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            detailsList.invalidateViews();


    }

    public void parseJSONKey(JSONObject json){
        try {
            JSONArray jsonArray = json.getJSONArray("Vehicles");

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = (JSONObject) jsonArray.get(i);
                ArrayList<String> Item = new ArrayList<>();

                Item.add(obj.getString("Registration_number_ID"));
                Item.add(obj.getString("Vehicle_type"));
                Item.add(obj.getString("Fleet_Number"));
                Item.add(obj.getString("Commission_year"));
                Item.add(obj.getString("Decommission_year"));
                Item.add(obj.getString("Vehicle_image"));
                Item.add(obj.getString("Video"));

                Vehicle_Key_Info.put(obj.getString("Registration_number_ID").toUpperCase().trim(), Item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parseJSONAdditional(JSONObject json){
        try {
            JSONArray jsonArray = json.getJSONArray("Vehicles");

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = (JSONObject) jsonArray.get(i);
                ArrayList<String> Item = new ArrayList<>();

             //   Item.add(obj.getString("Registration_number_ID"));
            //    Item.add(obj.getString("Additional_Vehicle_ID"));
                Item.add(obj.getString("Body_Manufacturer"));
                Item.add(obj.getString("Chassis_Manufacturer"));
                Item.add(obj.getString("Chassis_model"));
                Item.add(obj.getString("District"));
                Item.add(obj.getString("Operator"));

                Vehicle_Additional_Info.put(obj.getString("Registration_number_ID").toUpperCase().trim(), Item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scanned_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_scan:
                startActivity(new Intent(ScannedDetails.this, Scan.class));
                return true;
            case R.id.action_social:
                startActivity(new Intent(ScannedDetails.this, Social.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

//    private boolean isInternetAvailable(){
//        try {
//            InetAddress ipAddr = InetAddress.getByName("google.com");
//            if(ipAddr.equals("")){
//                return false;
//            }
//            else{
//                return true;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
}
