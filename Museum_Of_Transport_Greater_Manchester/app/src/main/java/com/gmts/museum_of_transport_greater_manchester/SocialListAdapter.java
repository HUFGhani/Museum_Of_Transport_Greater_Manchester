package com.gmts.museum_of_transport_greater_manchester;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class SocialListAdapter extends ArrayAdapter<Integer> {

    private final Activity context;
    private final Integer[] imgid;

    public SocialListAdapter(Activity context, Integer[] imgid) {
        super(context, R.layout.social_list, imgid);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.social_list, null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        imageView.setImageResource(imgid[position]);
        return rowView;

    };
}