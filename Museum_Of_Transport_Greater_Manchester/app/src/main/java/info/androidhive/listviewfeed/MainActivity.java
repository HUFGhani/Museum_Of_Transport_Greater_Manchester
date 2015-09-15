package info.androidhive.listviewfeed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.Session;
import com.gmts.museum_of_transport_greater_manchester.R;
import com.gmts.museum_of_transport_greater_manchester.Scan;
import com.gmts.museum_of_transport_greater_manchester.Social;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import info.androidhive.listviewfeed.adapter.FeedListAdapter;
import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.FeedItem;

public class MainActivity extends ActionBarActivity {
	private static final String TAG = MainActivity.class.getSimpleName();
	private ListView listView;
	private FeedListAdapter listAdapter;
	private List<FeedItem> feedItems;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facebook);
        listView = (ListView) findViewById(R.id.list);
        Session session = Session.getActiveSession();

        if (session != null){

            feedItems = new ArrayList<FeedItem>();

            listAdapter = new FeedListAdapter(this, feedItems);
            listView.setAdapter(listAdapter);

           String id = "283233901725524";
           String URL_FEED = "https://graph.facebook.com/" + id + "?access_token=" + session.getAccessToken() + "&fields=feed{id,name,full_picture,description,message,link},name,picture&type=large";

            // We first check for cached request
            Cache cache = AppController.getInstance().getRequestQueue().getCache();
            Cache.Entry entry = cache.get(URL_FEED);
            if (entry != null) {
                // fetch the data from cache
                try {
                    String data = new String(entry.data, "UTF-8");
                    try {
                        parseJsonFeed(new JSONObject(data));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            } else {
                // making fresh volley request and getting json
                JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                        URL_FEED, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.d(TAG, "Response: " + response.toString());
                        if (response != null) {
                            parseJsonFeed(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                    }
                });

                // Adding request to volley request queue
                AppController.getInstance().addToRequestQueue(jsonReq);
            }
        }
	}

	/**
	 * Parsing json reponse and passing the data to feed view list adapter
	 * */
	private void parseJsonFeed(JSONObject response) {
		try {
           // JSONObject j = response.getJSONObject("feed");
            JSONObject profilePic = response.getJSONObject("picture").getJSONObject("data");
			JSONArray feedArray = response.getJSONObject("feed").getJSONArray("data");

			for (int i = 0; i < feedArray.length(); i++) {
				JSONObject feedObj = (JSONObject) feedArray.get(i);
            //    JSONObject profileObj = (JSONObject) profileArray.get(i);

				FeedItem item = new FeedItem();
				item.setId(response.getInt("id"));
				item.setName(response.getString("name"));

				// Image might be null sometimes
				String image = feedObj.isNull("full_picture") ? null : feedObj
						.getString("full_picture");
				item.setImge(image);
				item.setStatus(feedObj.getString("message"));
				item.setProfilePic(profilePic.getString("url"));
				//item.setTimeStamp(feedObj.getString("created_time"));
                item.setTimeStamp("1403375851930");
				// url might be null sometimes
				String feedUrl = feedObj.isNull("link") ? null : feedObj.getString("link");


                item.setUrl(feedUrl);

				feedItems.add(item);
			}

			// notify data changes to list adapter
			listAdapter.notifyDataSetChanged();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
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
                startActivity(new Intent(MainActivity.this, Scan.class));
                return true;
            case R.id.action_social:
                startActivity(new Intent(MainActivity.this, Social.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
