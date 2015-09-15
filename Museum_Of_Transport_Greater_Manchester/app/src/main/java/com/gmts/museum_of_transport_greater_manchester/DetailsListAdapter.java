package com.gmts.museum_of_transport_greater_manchester;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

public class DetailsListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> title;
    private final ArrayList<String> info;
    private final String image;
    TextView TitleView;
    TextView DescView;
    ImageView ImgView;
    Bitmap bitmap;

    public DetailsListAdapter(Activity context, ArrayList<String> title, ArrayList<String> info, String image) {
        super(context, R.layout.details_list, title);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.title=title;
        this.info=info;
        this.image=image;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.details_list, null ,true);


       TitleView = (TextView) rowView.findViewById(R.id.detailsTitle);
       DescView = (TextView) rowView.findViewById(R.id.detailsInfo);
       ImgView = (ImageView) rowView.findViewById(R.id.detailsImage);

        TitleView.setText(title.get(position));
        DescView.setText(info.get(position));

        if(position == 0 && image != "null"){
            //new LoadImage().execute(image);
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
            .build();
            ImageLoader.getInstance().init(config);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(image,ImgView);
        }
        else{
            ImgView.setVisibility(View.INVISIBLE);
        }

        return rowView;

    };
}