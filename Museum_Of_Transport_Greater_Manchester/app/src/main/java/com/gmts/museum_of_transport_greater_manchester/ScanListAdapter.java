package com.gmts.museum_of_transport_greater_manchester;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ScanListAdapter extends ArrayAdapter<Integer> {

    private final Activity context;
    private final Integer[] imgid;

    public ScanListAdapter(Activity context, Integer[] imgid) {
        super(context, R.layout.scan_list, imgid);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.scan_list, null,true);

       // EditText text = (EditText) rowView.findViewById(R.id.editText2);
        Button button = (Button) rowView.findViewById(R.id.btnScan);
        ImageView img = (ImageView) rowView.findViewById(R.id.imageView);


        rowView.setPadding(0, 50, 0, 50);




        if (position != 2){
            img.setImageResource(imgid[position]);
            button.setVisibility(View.GONE);
        }
        else{
            img.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);

            RelativeLayout relativeLayout = (RelativeLayout) rowView.findViewById(R.id.relative);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            EditText text = new EditText(context);
            text.setLayoutParams(params);
            relativeLayout.addView(text);
            Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/UKNumberPlate.ttf");
            text.setTypeface(myTypeface);
            text.setHint("ENTR R3G");
            text.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
            Display display = context.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = (int) (width/5);
            text.setGravity(Gravity.BOTTOM|Gravity.CENTER);

            text.setTextSize(height/2-40);
            Drawable dr = getContext().getResources().getDrawable(imgid[position]);
            Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
            Drawable d = new BitmapDrawable(getContext().getResources(), Bitmap.createScaledBitmap(bitmap, width, height, true));
            text.setBackground(d);
text.setPadding(50,50,0,50);
            text.setId(R.id.txt);
            RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            relativeParams.addRule(RelativeLayout.BELOW,R.id.txt);
            button.setLayoutParams(relativeParams);

//            Button button = new Button(context);
//            button.setLayoutParams(params);
//            button.setText("Search Number Plate");

//            linear.addView(button);

        }
        return rowView;

    };
}