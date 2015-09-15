package com.gmts.museum_of_transport_greater_manchester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.twitter.sdk.android.core.AppSession;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.LoadCallback;
import com.twitter.sdk.android.tweetui.TweetViewFetchAdapter;

import java.util.ArrayList;
import java.util.List;


public class Twitter extends ActionBarActivity {

    TweetViewFetchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        adapter = new TweetViewFetchAdapter<CompactTweetView>(this);
        ListView listViewt = (ListView) findViewById(R.id.listViewT);
        listViewt.setAdapter(adapter);

        TwitterCore.getInstance().logInGuest(new Callback<AppSession>() {
            @Override
            public void success(Result result) {
                AppSession session = (AppSession) result.data;
                TwitterApiClient twitterApiClient =  TwitterCore.getInstance().getApiClient(session);
                getTweets(twitterApiClient);
            }

            @Override
            public void failure(TwitterException exception) {
                // unable to get an AppSession with guest auth
                Toast.makeText(Twitter.this, exception.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_twitter, menu);
        return true;
    }

    public void getTweets(TwitterApiClient twitterApiClient) {


        //what each value is in userTimeLine
//        void userTimeline(@Query("user_id") Long userId,
//                @Query("screen_name") String screenName,
//                @Query("count") Integer count,
//                @Query("since_id") Long sinceId,
//                @Query("max_id") Long maxId,
//                @Query("trim_user") Boolean trimUser,
//                @Query("exclude_replies") Boolean excludeReplies,
//                @Query("contributor_details") Boolean contributeDetails,
//                @Query("include_rts") Boolean includeRetweets,
//                Callback<List<Tweet>> cb);


        twitterApiClient.getStatusesService().userTimeline(Long.valueOf(442734638), null, 50, null, null, null, true, null, true, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                List<Long> tweetIds = new ArrayList<Long>();

                for (Tweet Tweet : result.data) {
                    tweetIds.add(Tweet.id);
                }
                addToAdapter(tweetIds);
            }

            public void failure(TwitterException exception) {
                Toast.makeText(Twitter.this, exception.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addToAdapter(List<Long> t) {
        adapter.setTweetIds(t,
                new LoadCallback<List<Tweet>>() {
                    @Override
                    public void success(List<Tweet> tweets) {
                        // my custom actions
                    }
                    @Override
                    public void failure(TwitterException exception) {
                        Toast.makeText(Twitter.this, "Failed " + exception.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_scan:
                startActivity(new Intent(Twitter.this, Scan.class));
                return true;
            case R.id.action_social:
                startActivity(new Intent(Twitter.this, Social.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
