package com.gmts.museum_of_transport_greater_manchester;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;
import com.facebook.AppEventsLogger;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.fabric.sdk.android.Fabric;


public class Main extends Fragment {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "pvExZrFDqFaQ3TNeH5pHIkDbX";
    private static final String TWITTER_SECRET = "isxlC22mwF5Kc5mvKefkvimYWaPCYAkZdA09oKMCRzc57mpJxf";

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    public static final String PACKAGE_NAME = "com.gmst.museum_of_transport_greater_manchester";
    public static final String DATA_PATH = Environment
            .getExternalStorageDirectory().toString() + "/GMTS/";

    // You should have the trained data file in assets folder
    // You can get them at:
    // http://code.google.com/p/tesseract-ocr/downloads/list
    public static final String lang = "eng";

    private static final String TAG = "Main.java";

    protected EditText _field;
    protected String _path;
    protected boolean _taken;
    protected static final String PHOTO_TAKEN = "photo_taken";
    String OCR;
    String contents;
    EventsListAdapter adapter;
    ListView listview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_main, container, false);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(getActivity(), new Twitter(authConfig), new Crashlytics());

        setHasOptionsMenu(true);
        listview = (ListView) view.findViewById(R.id.eventlist);

        try{
            new async().execute("http://armafashion.co.uk/transportm/category/events/feed/");
        }
        catch (Exception e){
            String[] error = {"Error"};
            String[] message = {"Unable to get events due to no internet connection"};
            listview.setAdapter(new EventsListAdapter(getActivity(),error,message));

        }

       return view;
    }

    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }




    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_scan:
                startActivity(new Intent(getActivity(), Scan.class));
                return true;
            case R.id.action_social:
                startActivity(new Intent(getActivity(), Social.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(getActivity());
    }

    private class async extends AsyncTask<String, Integer, Map> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Map doInBackground(String... params) {
            ArrayList<String> headlines = new ArrayList();
            ArrayList<String> links = new ArrayList<>();
            ArrayList<String> descriptions = new ArrayList();

            try {
                URL url = new URL(params[0]);

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();

                // We will get the XML from an input stream
                xpp.setInput(getInputStream(url), "UTF_8");

        /* We will parse the XML content looking for the "<title>" tag which appears inside the "<item>" tag.
         * However, we should take in consideration that the rss feed name also is enclosed in a "<title>" tag.
         * As we know, every feed begins with these lines: "<channel><title>Feed_Name</title>...."
         * so we should skip the "<title>" tag which is a child of "<channel>" tag,
         * and take in consideration only "<title>" tag which is a child of "<item>"
         *
         * In order to achieve this, we will make use of a boolean variable.
         */
                boolean insideItem = false;

                // Returns the type of current event: START_TAG, END_TAG, etc..
                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {

                        if (xpp.getName().equalsIgnoreCase("item")) {
                            insideItem = true;
                        } else if (xpp.getName().equalsIgnoreCase("title")) {
                            if (insideItem)
                                headlines.add(xpp.nextText()); //extract the headline
                        } else if (xpp.getName().equalsIgnoreCase("link")) {
                            if (insideItem)
                                links.add(xpp.nextText()); //extract the link of article
                        } else if (xpp.getName().equalsIgnoreCase("content:encoded")) {
                            if (insideItem)

                                descriptions.add(android.text.Html.fromHtml(xpp.nextText()).toString());
                        }
                    }else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
                        insideItem=false;
                    }

                    eventType = xpp.next(); //move to next element
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Map dict = new HashMap();

            dict.put("headlines", headlines);
            dict.put("links", links);
            dict.put("descriptions", descriptions);

            return dict;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Map result) {
            super.onPostExecute(result);
            final Map r = result;
           // adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, (ArrayList)result.get("headlines"));
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> myAdapter, View myView, int position, long id) {
                    ArrayList<String> array = (ArrayList)r.get("links");
                    Uri uri = Uri.parse(array.get(position));
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            ArrayList<String> arrayH = (ArrayList<String>)result.get("headlines");
            String[] headlines = arrayH.toArray(new String[arrayH.size()]);

            ArrayList<String> arrayD = (ArrayList<String>)result.get("descriptions");
            String[] descriptions = arrayD.toArray(new String[arrayD.size()]);

            listview.setAdapter(new EventsListAdapter(getActivity(),headlines,descriptions));
          //  adapter = new EventsListAdapter(getActivity(), , (ArrayList<String>)result.get("headlines"));

          //  listview.setAdapter(adapter);
           // adapter.notifyDataSetChanged();
        }
    }
}


