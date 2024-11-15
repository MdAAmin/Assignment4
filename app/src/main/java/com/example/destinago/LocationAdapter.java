package com.example.destinago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationAdapter extends BaseAdapter {
    String[] regions;
    String[] europeLocations;
    String[] asiaLocations;
    String[] northAmericaLocations;
    Integer[] img;
    Context context;

    public LocationAdapter(Context context, String[] regions, String[] europeLocations, String[] asiaLocations, String[] northAmericaLocations, Integer[] img) {
        this.context = context;
        this.regions = regions;
        this.europeLocations = europeLocations;
        this.asiaLocations = asiaLocations;
        this.northAmericaLocations = northAmericaLocations;
        this.img = img;
    }

    @Override
    public int getCount() {
        return regions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.location_view, parent, false);
        }

        // Get the views from the layout
        TextView title = convertView.findViewById(R.id.title);
        TextView subtitle1 = convertView.findViewById(R.id.subtitle1);
        TextView subtitle2 = convertView.findViewById(R.id.subtitle2);
        TextView subtitle3 = convertView.findViewById(R.id.subtitle3);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        // Set region title
        title.setText(regions[position]);

        // Set subtitles based on the region
        switch (regions[position]) {
            case "Europe":
                subtitle1.setText(europeLocations[0]);
                subtitle2.setText(europeLocations[1]);
                subtitle3.setText(europeLocations[2]);
                break;
            case "Asia":
                subtitle1.setText(asiaLocations[0]);
                subtitle2.setText(asiaLocations[1]);
                subtitle3.setText(asiaLocations[2]);
                break;
            case "North America":
                subtitle1.setText(northAmericaLocations[0]);
                subtitle2.setText(northAmericaLocations[1]);
                subtitle3.setText(northAmericaLocations[2]);
                break;
        }

        // Set image resource for the list item
        imageView.setImageResource(img[position]);

        return convertView;
    }
}
