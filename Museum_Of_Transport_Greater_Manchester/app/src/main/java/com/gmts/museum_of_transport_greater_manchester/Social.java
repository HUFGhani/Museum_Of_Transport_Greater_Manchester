package com.gmts.museum_of_transport_greater_manchester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import info.androidhive.listviewfeed.MainActivity;


public class Social extends ActionBarActivity {
    ListView listView;

    Integer[] imgid={
            R.drawable.facebook2,
            R.drawable.twitter,
            R.drawable.tripadvisor2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        listView = (ListView) findViewById(R.id.socialList);

        listView.setAdapter(new SocialListAdapter(this, imgid));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                switch(myItemInt){
                    case 0:
                        startActivity(new Intent(Social.this, MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(Social.this, Twitter.class));
                        break;
                    case 2:
                        Toast.makeText(Social.this, "Trip Advisor is not currently implemented into the app", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_social, menu);
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
                startActivity(new Intent(Social.this, Scan.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
