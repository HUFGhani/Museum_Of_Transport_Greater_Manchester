package com.gmts.museum_of_transport_greater_manchester;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventsListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] title;
    private final String[] description;



    public EventsListAdapter(Activity context, String[] title, String[] description) {
        super(context, R.layout.event_list, title);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.title=title;
        this.description=description;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.event_list, null ,true);

        TextView TitleView = (TextView) rowView.findViewById(R.id.txtTitle);

        TextView DescView = (TextView) rowView.findViewById(R.id.txtDescription);

        TitleView.setText(title[position]);
        DescView.setText(description[position]);

        return rowView;

    };
}